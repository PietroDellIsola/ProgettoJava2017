
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;


/**
 * Questa classe rappresenta un oggetto pacchettoDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class pacchettoDAO {
	private pacchettoDAO(){}
	
	/**
	 * Il metodo restituisce codPacchetto2=codPacchetto se il pacchetto è già presente nel database, altrimenti una stringa vuota
	 * @param codPacchetto - una stringa che rappresenta il codice del pacchetto 
	 * @return codPacchetto2 - una stringa che rappresenta il codice del pacchetto 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String codPacchetto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String codPacchetto2="";
		
		up="SELECT CodPacchetto FROM pacchetto WHERE CodPacchetto=? GROUP BY CodPacchetto";			  

		statp=con.prepareStatement(up);
		
		statp.setString(1, codPacchetto);
		
		result= statp.executeQuery();
		if(result.next())
			codPacchetto2=result.getString("CodPacchetto");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return codPacchetto2; //SE codAttivita2 CORRISPONDE AL PARAMETRO ESPLICITO( codAttivita ), LA CHIAVE PRIMARIA È GIA' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Il metodo permette di inserire un nuovo pacchetto all'interno del database
	 * @param p - un oggetto di tipo pacchetto
	 * @param P_IVA - una stringa che rappresenta la partita iva di un agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void creaPacchetto(pacchetto p,String P_IVA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//creare pacchetti; 
		System.out.println(P_IVA);
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				 
		PreparedStatement statp;
		String up;
				  
		up="INSERT INTO pacchetto VALUES(?,?,?,(?),(?),?,?,?,null,null)";
			statp=con.prepareStatement(up);
			
			statp.setString(1, p.getCodPAcchetto());
			
			statp.setString(2, p.getNome());
			
			statp.setString(3, p.getDescrizione());
						
			GregorianCalendar calendar= p.getDataI();
			String data=calendar.get(GregorianCalendar.YEAR)+"/"+((calendar.get(GregorianCalendar.MONTH))+1)+"/"+calendar.get(GregorianCalendar.DAY_OF_MONTH);
			statp.setString(4, data);
			
			calendar= p.getDataF();
			data=calendar.get(GregorianCalendar.YEAR)+"/"+((calendar.get(GregorianCalendar.MONTH))+1)+"/"+calendar.get(GregorianCalendar.DAY_OF_MONTH);			
			statp.setString(5, data);
			
			statp.setFloat(6, p.getPrezzo());
			
			statp.setInt(7, p.getIdRA());
			
			statp.setString(8, P_IVA);	//NON BISOGNA INSERIRE LA P_IVA DELL'AGENZIA POICHE LA REPERIAMO DAL LOGIN			
			
			if(statp.executeUpdate()==1)
				JOptionPane.showMessageDialog(null, "Pacchetto inserito");
			else JOptionPane.showMessageDialog(null, "Pacchetto non inserito");
			
			 //CHIUDO LA CONNESSIONE CON IL DATABASE
			  con.close();
			  statp.close();
				  
	}
	
	/**
	 * Il metodo modifica il pacchetto dato in input, aggiornando il parametro CF 
	 * @param p - un oggetto pacchetto
	 * @param P_IVA - una stringa che rappresenta la partita iva di un agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void vendiPacchetto(pacchetto p,String P_IVA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		 //vendere pacchetti;
		
		//APRO LA CONNESSIONE AL DATABASE
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
			
			PreparedStatement statp;
			String up;
			
			up="UPDATE pacchetto "
			  		+"SET pacchetto.CF=?, pacchetto.dataPrenotazione=?  "
			  		+"WHERE pacchetto.CodPacchetto=? AND P_IVA=?";
			statp=con.prepareStatement(up);
			
			statp.setString(3, p.getCodPAcchetto());
			
			statp.setString(4, P_IVA);
			
			//AGGIUNGIAMO LA DATA ODIERNA AL PACCHETTO NEL DATABASE
			GregorianCalendar calendar=new GregorianCalendar();
			String data=calendar.get(GregorianCalendar.YEAR)+"/"+((calendar.get(GregorianCalendar.MONTH))+1)+"/"+calendar.get(GregorianCalendar.DAY_OF_MONTH);
			
			statp.setString(2, data);//INSERIAMO LA DATA ODIERNA NEL PACCHETTO SCELTO
			
			statp.setString(1, p.getCF());//INSERIAMO IL CF DEL CLIENTE NEL PACCHETTO SCELTO
			
			if(statp.executeUpdate()==1)
				JOptionPane.showMessageDialog(null, "Pacchetto venduto");
			else JOptionPane.showMessageDialog(null, "Pacchetto non venduto");
							
		//CHIUDO LA CONNESSIONE CON IL DATABASE
			 con.close();
			 statp.close();
	}
	
	/**
	 * Il metodo ritorna tutti i pacchetti venduti dall'agenzia con partita iva = P_IVA
	 * @param P_IVA - una stringa che rappresenta la partita iva di un agenzia
	 * @return pac - un array di oggetti di tipo pacchetto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<pacchetto> stampaPacchettiVenduti(String P_IVA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//visualizzare i pacchetti venduti ed il relativo incasso. 
		//L'INCASSO VA CALCOLATO AL MOMENTO DELLA STAMPA NELLA CLASSE FRAME
		
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		ArrayList<pacchetto> pac=new ArrayList<>();
		PreparedStatement statp;
		
		String up="SELECT *"
					+ "FROM agenzia INNER JOIN pacchetto ON pacchetto.P_IVA=agenzia.P_IVA  "
					+ "WHERE pacchetto.CF IS NOT NULL "
					+ "AND pacchetto.P_IVA=?"
					+ "GROUP BY agenzia.P_IVA,pacchetto.CodPacchetto";
		
		statp=con.prepareStatement(up);
		
		statp.setString(1,P_IVA);
		
		result= statp.executeQuery();
		
	  	while(result.next()){
	  		
	  		String d=result.getString("dataI");
	  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		
	  		d=result.getString("dataF");
	  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		
	  		d=result.getString("dataPrenotazione");
	  		GregorianCalendar dataPrenotazione=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		
	  		pac.add(new pacchetto(result.getString("codPAcchetto"),result.getString("nome"),
	  					result.getString("descrizione"), dataI,
	  					dataF, Float.parseFloat(result.getString("prezzo")), 
	  					Integer.parseInt(result.getString("IdRA")),result.getString("P_IVA"),
	  					result.getString("CF"), dataPrenotazione));
	  		
	  						}
	  	//CHIUDO LA CONNESSIONE CON IL DATABASE
	  	con.close();
	  	return pac;
		
	}
	
	/**
	 * Ritorna tutti i pacchetti disponibili dell'agenzia con partita iva = P_IVA
	 * @param P_IVA - una stringa che rappresenta la partita iva di un agenzia
	 * @return pac - un array di oggetti di tipo pacchetto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<pacchetto> stampaPacchettiDisponibili(String P_IVA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		PreparedStatement statp;
		ResultSet result;
		ArrayList<pacchetto> pac=new ArrayList<>();
				  
		String up="SELECT* FROM pacchetto "
				+ "WHERE pacchetto.dataPrenotazione IS NULL AND  pacchetto.CF IS NULL "
				+ "AND pacchetto.P_IVA=? GROUP BY CodPacchetto ";
		
		statp=con.prepareStatement(up);
		
		statp.setString(1,P_IVA);
		
		result= statp.executeQuery();
	  	while(result.next()){
	  		
	  		String d=result.getString("dataI");
	  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		
	  		d=result.getString("dataF");
	  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  			  		
	  		pac.add(new pacchetto(result.getString("codPAcchetto"),result.getString("nome"),
	  					result.getString("descrizione"), dataI,
	  					dataF, Float.parseFloat(result.getString("prezzo")), 
	  					Integer.parseInt(result.getString("IdRA")),result.getString("P_IVA"),
	  					null,null));
	  		
	  						}
	  	//CHIUDO LA CONNESSIONE CON IL DATABASE
	  	con.close();
	  	return pac;
		
	}

	/**
	 * Ritorna tutti i pacchetti disponibili
	 * @return pac - un array di oggetti di tipo pacchetto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<pacchetto> stampaTuttiPacchettiDisponibili() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//visualizzare i pacchetti in vendita da parte delle agenzie;
	
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		Statement query=con.createStatement();
		 
		ArrayList<pacchetto> pac=new ArrayList<>();
		
		result=query.executeQuery("SELECT * FROM pacchetto WHERE CF IS NULL "
				+ "AND pacchetto.dataPrenotazione IS NULL GROUP BY CodPacchetto");
			
			while(result.next()){
				String d=result.getString("dataI");
		  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
		  		
		  		d=result.getString("dataF");
		  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
		  		
				pac.add(new pacchetto(result.getString("CodPacchetto"),result.getString("nome"),
						result.getString("descrizione"),dataI,dataF,
						Float.parseFloat(result.getString("prezzo")),
						Integer.parseInt(result.getString("IdRA")),
						result.getString("P_IVA"),null,null));
								}
		
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
	  	con.close();
	  	return pac;
		
	}
	
}
