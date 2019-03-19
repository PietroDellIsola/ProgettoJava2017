import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Questa classe rappresenta un oggetto ristoroAlloggioDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class ristoroAlloggioDAO {

	private ristoroAlloggioDAO(){}
	
	public static int isPresente(int idRA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		int idRA2=0;
		
		up="SELECT  idRA FROM ristoroalloggio WHERE idRA=? GROUP BY idRA";			  

		statp=con.prepareStatement(up);
		
		statp.setInt(1, idRA);
		
		result= statp.executeQuery();
		if(result.next())
			idRA2=result.getInt("idRA");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return idRA2; //SE CF2 CORRISPONDE AL PARAMETRO ESPLICITO( CF ), IL CLIENTE E' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Restituisce tutti i ristoranti ed hotel presenti nel database
	 * @return ristoroAlloggio - un array di oggetti di tipo ristoroAlloggio 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<ristoroAlloggio> stampaRistoroAlloggio() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				
		ResultSet result;
		Statement query=con.createStatement();
		
		ArrayList<ristoroAlloggio>ristoroAlloggio=new ArrayList<>();
		//STAMPA DI TUTTI I PARCHI
		result=query.executeQuery("SELECT * FROM ristoroalloggio GROUP BY ristoroalloggio.IdRA");

		while(result.next()){
			ristoroAlloggio.add(new ristoroAlloggio(Integer.parseInt(result.getString("IdRA")),result.getString("nome"),result.getString("tipo"),
					result.getString("via"),result.getString("citta"),result.getString("CAP"),result.getString("telefono")));
		
		}
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
	 	con.close();
	   		
		return ristoroAlloggio;
	}
	
}
