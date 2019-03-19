
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Questa classe rappresenta un oggetto attivitaDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class attivitaDAO {
	private attivitaDAO(){}
	
	/**
	 * Restituisce codAttivita2=codAttivita se l'attività è già presente nel database, altrimenti una stringa vuota
	 * @param codAttivita una stringa che rappresenta il codice di un attività
	 * @return codAttivita2 una stringa che rappresenta il codice di un attività
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String codAttivita) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String codAttivita2="";
		
		up="SELECT CodAttivita FROM attivita WHERE CodAttivita=? GROUP BY CodAttivita";			  

		statp=con.prepareStatement(up);
		
		statp.setString(1, codAttivita);
		
		result= statp.executeQuery();
		if(result.next())
			codAttivita2=result.getString("CodAttivita");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return codAttivita2; //SE codAttivita2 CORRISPONDE AL PARAMETRO ESPLICITO( codAttivita ), LA CHIAVE PRIMARIA È GIA' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Ritorna un array di oggetti di tipo attivita, presenti nel database
	 * @return a un array di oggetti di tipo attivita
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<attivita> stampaAttivita() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		Statement query=con.createStatement();
		ResultSet result;
		ArrayList<attivita> a=new ArrayList<>();;
				  
		result=query.executeQuery("SELECT * FROM attivita GROUP BY CodAttivita");
		
		 //MANCA ASSEGNASENTO ALL'ARRAY LIST DEL RISULTATO
	  	while(result.next()){
	  			a.add(new attivita(result.getString("CodAttivita"),result.getString("nome"),
	  				 result.getFloat("costo"),result.getString("orario"),
	  				result.getBoolean("disponibilita"),result.getInt("IdParco"),
	  				result.getString("CodStruttura")));
	  						}
	  	
	  	//CHIUDO LA CONNESSIONE CON IL DATABASE
	  	con.close();
	  	return a;
	}
	
	/**
	 * Inserisce un oggetto attivita, passato come parametro esplicito, nel database
	 * @param a un oggetto di tipo attività
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciAttivita(attivita a) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		 
		PreparedStatement statp;
		String up;
		 //modificare
		up="INSERT INTO attivita() VALUES (?,?,?,?,?,?,?) ";
		statp=con.prepareStatement(up);
		
		statp.setString(1,a.getCodAttivita());
		
		statp.setString(2, a.getNome());
		
		statp.setFloat(3, a.getCosto());
		
		statp.setString(4, a.getOrario());
		
		statp.setBoolean(5, a.isDisponibilita());
		
		statp.setInt(6, a.getIdParco());
		
		statp.setString(7, a.getCodStruttura());
		
		if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Attività aggiunta al database");
		else JOptionPane.showMessageDialog(null, "Attività non aggiunta al database");;  
	  
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
	}		

}
