
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Questa classe rappresenta un oggetto parcoDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class parcoDAO {
	private parcoDAO(){}
	
	/**
	 * Restituisce una stringa uguale a quella passata come parametro esplicito se la struttura è presente 
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco 
	 * @return idParco2 - un intero che rappresenta il codice identificativo di un parco 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static int isPresente(int idParco) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		int idParco2=0;
		
		up="SELECT  idParco FROM parco WHERE idParco=? GROUP BY idParco";			  

		statp=con.prepareStatement(up);
		
		statp.setInt(1, idParco);
		
		result= statp.executeQuery();
		if(result.next())
			idParco2=result.getInt("idParco");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return idParco2; //SE CF2 CORRISPONDE AL PARAMETRO ESPLICITO( CF ), IL CLIENTE E' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Questo metodo restituisce true se i biglietti disponibili di un parco sono uguali a 0, altrimenti false
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco 
	 * @return boolean
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static boolean bigliettiFiniti(int idParco) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
							 
		PreparedStatement statp;
		ResultSet result;
		String up;
				
		up="SELECT numBigliettiVendita FROM parco WHERE idParco=? GROUP BY idParco";			  

		statp=con.prepareStatement(up);
				
		statp.setInt(1, idParco);
				
		result= statp.executeQuery();
		if(result.next())
			if(result.getString("numBigliettiVendita").equals("0")){
				//CHIUDO LA CONNESSIONE CON IL DATABASE
				con.close();
				statp.close();		
				return true;			
													}
				
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		return false;
		
	}
	
	/**
	 * Restituisce tutti i parchi presenti nel database
	 * @return parchi - un array di oggetti di tipo parco
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<parco> stampaParchi() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		
		ResultSet result;
		Statement query=con.createStatement();
		ArrayList<parco> parchi=new ArrayList<>();
		//STAMPA DI TUTTI I PARCHI
		result=query.executeQuery("SELECT  parco.* FROM parco GROUP BY parco.IdParco");

		while(result.next()){
				//SE È UN PARCO ACQUATICO 
				if(result.getString("numPiscine")!=null){	
					parchi.add(new parcoAcquatico(result.getInt("IdParco"),result.getString("nome"),
						result.getString("sede"),result.getString("email"),
						result.getString("telefono"),result.getInt("numBigliettiVendita"),
						result.getInt("numPiscine")));
														}
			
				//SE È UN PARCO TEMATICO 
				if(result.getString("tema")!=null){	
					parchi.add(new parcoTematico(result.getInt("IdParco"),result.getString("nome"),
						result.getString("sede"),result.getString("email"),
						result.getString("telefono"),result.getInt("numBigliettiVendita"),
						result.getString("tema")));
					
													}
				
				//SE È UN PARCO AVVENTURA 
				if(result.getString("percorso")!=null){	
					parchi.add(new parcoAvventura(result.getInt("IdParco"),result.getString("nome"),
						result.getString("sede"),result.getString("email"),
						result.getString("telefono"),result.getInt("numBigliettiVendita"),
						result.getString("percorso")));
					
														}
			
		
							}
			//CHIUDO LA CONNESSIONE CON IL DATABASE
		 	con.close();
		   
			return parchi;	
				
								}
	
	/**
	 * Il metodo restituisce l'incasso in base all'ordine settimanale/mensile/annuale
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 * @param ordine - una stringa che rappresenta la visualizzazione (settimanale/mensile/annuale)
	 * @return incasso - un float che rappresenta l'incasso totale di un parco 
	 * @throws NumberFormatException
	 * @throws SQLException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 */
	public static float incasso(int idParco,String ordine) throws NumberFormatException, SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException{
		//if ordine= 'S' incasso settimanale
		//if ordine= 'M' incasso mensile
		//if ordine= 'A' incasso annuale
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		
		PreparedStatement statp = null;
		String up="";
				  
		float incasso=0;
		
		if(ordine.equals("S")){
		
		String data1=JOptionPane.showInputDialog("Inserisci la prima data dell'Intervallo");
		String data2=JOptionPane.showInputDialog("Inserisci la seconda data dell'Intervallo");
		
		up="SELECT parco.IdParco , SUM(biglietto.prezzoTotale)as incasso  "
				+"FROM biglietto INNER JOIN parco ON parco.IdParco=biglietto.IdParco  "
				+"WHERE parco.IdParco=? AND DataAcquisto>=? AND dataAcquisto<=?  "
				+ "GROUP BY parco.IdParco";
		statp=con.prepareStatement(up);
		statp.setString(2, data1);
		statp.setString(3, data2);
							}
		
		if(ordine.equals("M")){
			up="SELECT parco.IdParco , SUM(biglietto.prezzoTotale)as incasso  "
					+"FROM biglietto INNER JOIN parco ON parco.IdParco=biglietto.IdParco  "
					+"WHERE parco.IdParco=? AND  MONTH(dataAcquisto)=MONTH(curdate())"
					+ "GROUP BY parco.IdParco";
			statp=con.prepareStatement(up);
								}
		
		if(ordine.equals("A")){
			up="SELECT parco.IdParco , SUM(biglietto.prezzoTotale)as incasso  "
					+"FROM biglietto INNER JOIN parco ON parco.IdParco=biglietto.IdParco  "
					+"WHERE parco.IdParco=? AND  YEAR(dataAcquisto)=YEAR(curdate())"
					+ "GROUP BY parco.IdParco";
			statp=con.prepareStatement(up);
								}
		
		
		
		statp.setString(1, ""+idParco);
		
		
		result=statp.executeQuery();
		while(result.next()){
		incasso=Float.parseFloat(result.getString("incasso"));
							}
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		return incasso;
	}
	
	/**
	 * Il metodo permette di aggiornare il numero di biglietti disponibili per un parco, all'interno di un database
	 * @param IdParco - un intero che rappresenta il codice identificativo di un parco
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void decrementaNumBiglietti(String IdParco) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		PreparedStatement statp;
				
				
		//AGGIORNIAMO IL PREZZO DEL BIGLIETTO NEL DATABASE
		String up="UPDATE parco SET numBigliettiVendita=numBigliettiVendita-1 "
				+ "WHERE parco.IdParco=? ";
		statp=con.prepareStatement(up);
		
		statp.setString(1, IdParco);
				
		if(statp.executeUpdate()==1)
				JOptionPane.showMessageDialog(null, "Numero biglietti in vendita del parco, aggiornato");
		else JOptionPane.showMessageDialog(null, "Numero biglietti in vendita del parco, non aggiornato");
				                       
						
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		
	}
	
		
						}

