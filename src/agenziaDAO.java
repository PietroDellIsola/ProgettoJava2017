
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
 * Questa classe rappresenta un oggetto agenziaDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class agenziaDAO {
	private agenziaDAO(){}
	
	/**
	 * Il metodo ritorna un array di biglietti presenti nel database, dei parchi convenzionati con l'agenzia avente partita iva= p_iva 
	 * @param p_iva una stringa che rappresenta la partita iva di un agenzia
	 * @return biglietti un array di oggetti di tipo biglietto 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<biglietto> bigliettiParchiConvenzionati(String p_iva) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//RITORNA I BIGLIETTI DEI PARCHI CONVENZIONATI CON L'AGENZIA CHE HA QUELLA PARTITA IVA
				
		//APRO LA CONNESSIONE AL DATABASE
		
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
							 
				PreparedStatement statp;
				ResultSet result;
				String up;
				ArrayList<biglietto> biglietti=new ArrayList<>();
				
				up="SELECT biglietto.* "
						+"FROM convenzionato INNER JOIN biglietto ON biglietto.IdParco=convenzionato.IdParco "
						+"WHERE convenzionato.P_IVA= ? "
						+"GROUP BY biglietto.CodBiglietto ";			  

				statp=con.prepareStatement(up);
				
				statp.setString(1, p_iva);
				
				result= statp.executeQuery();
				
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
				statp.close();
						
		
		return biglietti;
	}
	
	/**
	 * Il metodo ritorna p_iva2=p_iva se è già presente nel database altrimenti una stringa vuota
	 * @param p_iva una stringa che rappresenta la partita iva di un agenzia
	 * @return p_iva2 una stringa che rappresenta la partita iva di un agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String p_iva) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String p_iva2="";
		
		up="SELECT P_IVA FROM agenzia WHERE P_IVA=? GROUP BY P_IVA";			  

		statp=con.prepareStatement(up);
		
		statp.setString(1, p_iva);
		
		result= statp.executeQuery();
		if(result.next())
			p_iva2=result.getString("P_IVA");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return p_iva2; //SE p_iva2 CORRISPONDE AL PARAMETRO ESPLICITO( p_iva ), LA CHIAVE PRIMARIA È GIA' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Il metodo permette l'inserimento nel database di un oggetto di tipo agenzia, passato come parametro esplicito
	 * @param a un oggetto di tipo agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciAgenzia(agenzia a) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		 
		  PreparedStatement statp;
		  String up;
		  
		  up="INSERT INTO agenzia() VALUES (?,?,?,?,?,?,?) ";
			statp=con.prepareStatement(up);
				
			statp.setString(1, a.getP_IVA());
					
			statp.setString(2, a.getNome());
		
			statp.setString(3, a.getTelefono());
			
			statp.setString(4, a.getEmail());
			
			statp.setString(5, a.getVia());
			
			statp.setString(6, a.getCitta());
			
			statp.setString(7, a.getCAP());
			
			if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Agenzia aggiunta al database");
			else JOptionPane.showMessageDialog(null, "Agenzia non aggiunta al database");;  
		  
		  //CHIUDO LA CONNESSIONE CON IL DATABASE
		  con.close();
		  statp.close();
	}
	
	
	/**
	 *Il metodo ritorna un array di oggetti di tipo agenzia, presenti nel database
	 * @param a un oggetto di tipo agenzia
	 * @return ag un array di oggetti di tipo agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<agenzia> stampaAgenzia(agenzia a) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		Statement query=con.createStatement();
		ResultSet result;
		ArrayList<agenzia> ag=new ArrayList<>();;
				  
		result=query.executeQuery("SELECT * FROM agenzia GROUP BY P_IVA");
		
	  	while(result.next()){
	  			ag.add(new agenzia(result.getString("P_IVA"),result.getString("nome"),
	  					result.getString("telefono"), result.getString("email"),
	  					result.getString("via"),result.getString("citta"),
	  					result.getString("CAP")));
	  						}
	  	
	  	//CHIUDO LA CONNESSIONE CON IL DATABASE
	  	con.close();
	  	return ag;
	}
}
