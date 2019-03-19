
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Questa classe rappresenta un oggetto promozioneDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class promozioneDAO {
	private promozioneDAO(){}
	
		
	/**
	 * Questo metodo ritorna tutte le promozioni attive nell'intervallo di date date in input, presenti nel database
	 * @param dataIinput - una stringa che rappresenta la prima data
	 * @param dataFinput - una stringa che rappresenta la secoda data
	 * @return pac - un array di oggetti di tipo promozione
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<promozione> stampaPromozioniAttive(String dataIinput,String dataFinput) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				ResultSet result;
				PreparedStatement statp;
				ArrayList<promozione> pac=new ArrayList<>();
				
				String up="  SELECT * FROM promozione WHERE dataI >= ?  AND  dataI <=  ? "
	  						+ "GROUP BY CodPromozione" ;
	  				
	  			statp=con.prepareStatement(up);
	  				
	  			statp.setString(1,dataIinput);
	  				
	  			statp.setString(2, dataFinput);
	  			    
	  			result= statp.executeQuery();
	  			
	  			while(result.next()){
	  				String d=result.getString("dataI");
	  		  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		  			
	  		  		d=result.getString("dataF");
	  		  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
		  			
             	   pac.add(new promozione(result.getString("CodPromozione"),dataI,dataF,
             			   result.getString("nome"),result.getString("descrizione"),
             			   Float.parseFloat(result.getString("prezzo")),result.getInt("IdParco")));
                					}
	  			//CHIUDO LA CONNESSIONE CON IL DATABASE
				 con.close();
				 statp.close();     
				return pac;
				
	}
	
	/**
	 * Questo metodo ritorna le promozioni attive per un'attivita con nome attivita = nomeAttivita
	 * @param CodAttivita - una stringa che rappresenta il codice di un attività
	 * @param ordine - una stringa che rappresenta l'ordine di stampa(cronologico o lessicografico)
	 * @return prom - un array di oggetti di tipo promozione
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	//METODO PER STAMPARE PROMZIONI PER UN ATTIVITA' CHE PRENDE IN INPUT IL CODATTIVITA,
	// ED UNA STRINGA CHE SARA' UGUALE A 'C' PER ORDINE CRONOLOGICO UGUALE A 'L' ALTRIMENTI
	public static ArrayList<promozione> stampaPromozione(String nomeAttivita,String ordine) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		PreparedStatement statp;
		ArrayList<promozione> prom=new ArrayList<>();
		
		String up="";
		
		
		if(ordine.equalsIgnoreCase("C"))//	ORDINE CRONOLOGICO
			{
				up="SELECT * "
				+ "FROM promozionecomprende INNER JOIN promozione ON promozionecomprende.CodPromozione=promozione.CodPromozione "
				+ "INNER JOIN attivita on promozionecomprende.CodAttivita=attivita.CodAttivita "
				+ "WHERE attivita.nome=? GROUP BY attivita.CodAttivita,promozione.CodPromozione "
				+ "ORDER BY promozione.dataI ";
			}
		
		if(ordine.equalsIgnoreCase("L"))//ORDINE LESSICOGRAFICO
			{
				up="SELECT * "
					+ "FROM promozionecomprende INNER JOIN promozione ON promozionecomprende.CodPromozione=promozione.CodPromozione "
					+ "INNER JOIN attivita on promozionecomprende.CodAttivita=attivita.CodAttivita "
					+ "WHERE attivita.nome=? GROUP BY attivita.CodAttivita,promozione.CodPromozione "
					+ "ORDER BY promozione.nome ";
			}
		
		statp=con.prepareStatement(up);
		
		statp.setString(1, nomeAttivita);
				
		result= statp.executeQuery();
        while(result.next()){
        	String d=result.getString("dataI");
		  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
		  			
		  		d=result.getString("dataF");
		  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
  			
     	   prom.add(new promozione(result.getString("CodPromozione"),dataI,dataF,
     			   result.getString("nome"),result.getString("descrizione"),
     			   Float.parseFloat(result.getString("prezzo")),result.getInt("IdParco")));
     	   
        					}
		
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		 con.close();
		 statp.close();
		return prom;
	}
	
	/**
	 * Il metodo ritorna tutte le promozioni di un parco con idParco dato come parametro esplicito
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco 
	 * @return prom - un array di oggetti di tipo promozione
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<promozione> stampaPromozioniParco(int idParco) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				ResultSet result;
				PreparedStatement statp;
				ArrayList<promozione> prom=new ArrayList<>();
				
				String up="  SELECT * FROM promozione WHERE IdParco=? AND curdate() BETWEEN dataI AND dataF "
	  						+ "GROUP BY CodPromozione" ;
	  				
	  			statp=con.prepareStatement(up);
	  				
	  			statp.setInt(1,idParco);
	  			    
	  			result= statp.executeQuery();
	  			
	  			while(result.next()){
	  				String d=result.getString("dataI");
	  		  		GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
	  		  			
	  		  		d=result.getString("dataF");
	  		  		GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
		  			
             	   prom.add(new promozione(result.getString("CodPromozione"),dataI,dataF,
             			   result.getString("nome"),result.getString("descrizione"),
             			   Float.parseFloat(result.getString("prezzo")),result.getInt("IdParco")));
                					}
	  			//CHIUDO LA CONNESSIONE CON IL DATABASE
				 con.close();
				 statp.close();     
				return prom;
				
	}
	
	/**
	 * Ritorna il prezzo di una promozione con codPromozione passato come parametro esplicito
	 * @param codPromozione - una stringa che rappresenta il codice della promozione
	 * @return prezzo - un float che rappresenta il prezzo della promozione 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static float prezzoPromozione(String codPromozione) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		ResultSet result;
		PreparedStatement statp;
		float prezzo=0;
		
		String up="  SELECT prezzo FROM promozione WHERE CodPromozione=? "
					+ "GROUP BY CodPromozione" ;
		statp=con.prepareStatement(up);
			
		statp.setString(1,codPromozione);
		result= statp.executeQuery();
			
		while(result.next()){
				prezzo=Float.parseFloat(result.getString("prezzo"));
        					}
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		 con.close();
		 statp.close();   
		 
		return prezzo;
		
	}
	
}
