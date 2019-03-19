
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
 * Questa classe rappresenta un oggetto bigliettoDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class bigliettoDAO {
	
private bigliettoDAO(){}

	/**
	 * Il metodo restituisce un codBiglietto2 se è già presente nel database, altrimenti una stringa vuota
	 * @param codBiglietto una stringa che rappresenta il codice del biglietto
	 * @return codBiglietto2 una stringa che rappresenta il codice del biglietto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String codBiglietto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String codBiglietto2="";
	
		up="SELECT CodBiglietto FROM biglietto WHERE CodBiglietto=? GROUP BY CodBiglietto";			  

		statp=con.prepareStatement(up);
	
		statp.setString(1, codBiglietto);
	
		result= statp.executeQuery();
		if(result.next())
			codBiglietto2=result.getString("CodBiglietto");
	
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
			
			return codBiglietto2; //SE codBiglietto2 CORRISPONDE AL PARAMETRO ESPLICITO( codBiglietto ), LA CHIAVE PRIMARIA È GIA' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Questo metodo permette di inserire un oggetto di tipo biglietto all'interno del database
	 * @param b un oggetto di tipo biglietto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciBiglietto(biglietto b) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		 
		  PreparedStatement statp;
		  String up;
		  
		  up="INSERT INTO biglietto VALUES (?,?,?,?,?,?,null,null) ";
			statp=con.prepareStatement(up);
				
			statp.setString(1, b.getCodBiglietto());
					
			statp.setString(2, b.getTipo());
		
			statp.setString(3, b.getCF());
			
			if(b.getCodPromozione().equals(""))statp.setString(4,null);
			else statp.setString(4,b.getCodPromozione());
			
			statp.setInt(5, b.getIdParco());
			
			//AGGIUNGIAMO LA DATA ODIERNA AL BIGLIETTO NEL DATABASE
			String data=b.getDataAcquisto().get(GregorianCalendar.YEAR)+"/"+((b.getDataAcquisto().get(GregorianCalendar.MONTH))+1)+"/"+b.getDataAcquisto().get(GregorianCalendar.DAY_OF_MONTH);
			statp.setString(6, data);
						
			if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Biglietto venduto");
			else JOptionPane.showMessageDialog(null, "Biglietto non venduto");
		  
		  //CHIUDO LA CONNESSIONE CON IL DATABASE
		  con.close();
		  statp.close();
	}
	
	/**
	 * Questo metodo restituisce un array di oggetti di tipo biglietto, presenti nel database
	 * @return biglietti un array di oggetti di tipo biglietto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<biglietto> stampaBiglietti()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		Statement query=con.createStatement();
		ArrayList<biglietto> biglietti=new ArrayList<>();
		//STAMPA DI TUTTI I BIGLIETTI
		result=query.executeQuery("SELECT biglietto.* FROM biglietto GROUP BY CodBiglietto");

		while(result.next()){
			String d=result.getString("dataAcquisto");
	  		GregorianCalendar dataAcquisto=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		
	  		String codPacchetto=result.getString("CodPacchetto");
	  		if(codPacchetto==null)codPacchetto="";
	  		
	  		biglietti.add(new biglietto(result.getString("codBiglietto"), 
			result.getString("tipo"),result.getString("CF"),
			result.getString("CodPromozione"),result.getInt("IdParco"),
			dataAcquisto,result.getFloat("prezzoTotale"), codPacchetto));
							}
					
		 
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
									
		return biglietti;	
						
										
															}
	
	/**
	 * Questo metodo calcola il prezzo di un biglietto in base alle attività scelte e lo ritorna
	 * @param CodBiglietto una stinga che rappresenta il codice di un biglietto
	 * @return prezzoTotale un float che rappresenta il coso totale del biglietto 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String calcoloPrezzoBigliettoNormale(String CodBiglietto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		PreparedStatement statp;
		
		//CALCOLIAMO IL PREZZO DEL BIGLIETTO
		String up="SELECT biglietto.CodBiglietto, SUM(attivita.costo)as prezzoTotale "
		+"FROM biglietto INNER JOIN bigliettocomprende ON biglietto.CodBiglietto=bigliettocomprende.CodBiglietto " 
		+"INNER JOIN attivita ON attivita.CodAttivita=bigliettocomprende.CodAttivita "
		+"WHERE biglietto.tipo='Normale' AND biglietto.CodBiglietto=? "
		+"GROUP BY biglietto.CodBiglietto ";
	    
		statp=con.prepareStatement(up);
		
		statp.setString(1, CodBiglietto);
		
		result= statp.executeQuery();
		
		String prezzoTotale = "";
		while(result.next()){
			prezzoTotale=result.getString("prezzoTotale");
		}
		
		
		//AGGIORNIAMO IL PREZZO DEL BIGLIETTO NEL DATABASE
		up="UPDATE biglietto SET biglietto.prezzoTotale=? "
				+ "WHERE biglietto.CodBiglietto=? ";
		statp=con.prepareStatement(up);
		
		statp.setString(1, prezzoTotale);
		 
		statp.setString(2, CodBiglietto);
		
		if(statp.executeUpdate()==1)
			JOptionPane.showMessageDialog(null, "Prezzo totale del biglietto aggiornato");
		else JOptionPane.showMessageDialog(null, "Prezzo totale del biglietto non aggiornato");
		                       
				
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		
		return prezzoTotale;
									}
	
	/**
	 * Il metodo permette di aggiornare il prezzo di un biglietto, presente nel database, con il costo della
	 * promozione selezionata
	 * @param CodBiglietto una stringa che rappresenta il codice del biglietto
	 * @param codPromozione una stringa che rappresenta il codice di una promozione
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void aggiuntaPrezzoBigliettoPromozione(String CodBiglietto,String codPromozione) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		float costoPromozione=0;
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		PreparedStatement statp;
		
		//AGGIORNIAMO IL PREZZO DEL BIGLIETTO NEL DATABASE
		String up="UPDATE biglietto SET biglietto.prezzoTotale=? "
						+ "WHERE biglietto.CodBiglietto=? ";
		statp=con.prepareStatement(up);
		
		costoPromozione=promozioneDAO.prezzoPromozione(codPromozione);
		statp.setFloat(1, costoPromozione);
				 
		statp.setString(2, CodBiglietto);
				
		if(statp.executeUpdate()==1)
				JOptionPane.showMessageDialog(null, "Prezzo del biglietto con promozione aggiornato a: "+costoPromozione);
		else JOptionPane.showMessageDialog(null, "Prezzo del biglietto con promozione non aggiornato");
				                       
						
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		
			
		//SE VA A BUON FINE STAMPA UN JOPTION PANE CON IL PRETZZO DEL BIGLIETTO TOTALE
		
	}
	
	/**
	 * Questo metodo permette di agiungere al biglietto il codice del pacchetto acquistato dal cliente
	 * @param CodBiglietto una stringa che rappresenta il codice del biglietto
	 * @param cF una stringa che rappresenta il codice fiscale di un cliente
	 * @param codPacchetto una stringa che rappresenta il codice del pacchetto
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void aggiornaCodPacchetto(String CodBiglietto, String cF, String codPacchetto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		 //AGGIUNGO IL PACCHETTO AL BIGLIETTO
		biglietto biglietto=null;
		ArrayList<biglietto>biglietti=new ArrayList<>();
		
		//APRO LA CONNESSIONE AL DATABASE
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
			
			PreparedStatement statp = null;
			String up;
			//CARICO TUTTI I BIGLIETTI
			biglietti=bigliettoDAO.stampaBiglietti();
			for(biglietto b:biglietti){
				if(b.getCodBiglietto().equals(CodBiglietto)){
						biglietto=b;
																			}
			}
			
			up="UPDATE biglietto SET biglietto.CodPacchetto=? "
			  		+"WHERE biglietto.CodBiglietto=? ";
			statp=con.prepareStatement(up);
			
			statp.setString(1, codPacchetto);
			
			statp.setString(2, biglietto.getCodBiglietto());
			
			
			
			if(statp.executeUpdate()==1)
				JOptionPane.showMessageDialog(null, "Pacchetto aggiuto al biglietto del cliente");
			else JOptionPane.showMessageDialog(null, "Pacchetto non aggiuto al biglietto del cliente");
				
		//CHIUDO LA CONNESSIONE CON IL DATABASE	
			 con.close();
			 statp.close();
	}
	
}
