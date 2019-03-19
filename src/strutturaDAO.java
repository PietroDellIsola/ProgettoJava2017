import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Questa classe rappresenta un oggetto strutturaDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class strutturaDAO {
	private strutturaDAO(){};
	
	/**
	 * Restituisce tutte le strutture presenti nel parco
	 * @return strutture - un array di oggetti di tipo struttura
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<struttura> stampaStrutture() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		
		ResultSet result;
		Statement query=con.createStatement();
		ArrayList<struttura> strutture=new ArrayList<>();
		//STAMPA DI TUTTI I PARCHI
		result=query.executeQuery("SELECT * FROM struttura GROUP BY CodStruttura");

		while(result.next()){
			strutture.add(new struttura(result.getString("CodStruttura"),result.getString("nome"),
					result.getInt("IdParco")));
							}
			//CHIUDO LA CONNESSIONE CON IL DATABASE
		 	con.close();
		   
			return strutture;	
				
								}
	
	/**
	 * Restituisce una stringa uguale a guella passata come parametro esplicito se struttura è presente
	 * @param CodStruttura - una stringa che rappresenta il codice di una struttura
	 * @return CodStruttura2 - una stringa che rappresenta il codice di una struttura
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String CodStruttura) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String CodStruttura2="";
		
		up="SELECT  CodStruttura FROM struttura WHERE CodStruttura=? GROUP BY CodStruttura";			  

		statp=con.prepareStatement(up);
		
		statp.setString(1, CodStruttura);
		
		result= statp.executeQuery();
		if(result.next())
			CodStruttura2=result.getString("CodStruttura");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return CodStruttura2; //SE CF2 CORRISPONDE AL PARAMETRO ESPLICITO( CF ), IL CLIENTE E' PRESENTE NEL DATABASE		
	}
	
}
