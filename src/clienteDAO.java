
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Questa classe rappresenta un oggetto clienteDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class clienteDAO {
	private clienteDAO(){}
	
	/**
	 * Questo metodo restituisce CF2=CF se il cliente è già presente nel database
	 * @param CF una stringa che rappresenta il codice fiscale del cliente
	 * @return CF2 una stringa che rappresenta il codice fiscale del cliente
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String isPresente(String CF) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
					 
		PreparedStatement statp;
		ResultSet result;
		String up;
		String CF2="";
		
		up="SELECT  CF FROM cliente WHERE CF=? GROUP BY CF";			  

		statp=con.prepareStatement(up);
		
		statp.setString(1, CF);
		
		result= statp.executeQuery();
		if(result.next())
			CF2=result.getString("CF");
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
				
		return CF2; //SE CF2 CORRISPONDE AL PARAMETRO ESPLICITO( CF ), IL CLIENTE E' PRESENTE NEL DATABASE		
	}
	
	/**
	 * Questo metodo permette di inserire un nuovo cliente nel database
	 * @param c un oggetto di tipo cliente
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciCliente(cliente c) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		 
		  PreparedStatement statp;
		  String up;
		  
		  up="INSERT INTO cliente() VALUES (?,?,?,?,?,?) ";
			statp=con.prepareStatement(up);
				
			statp.setString(1, c.getCF());
					
			statp.setString(2, c.getNome());
		
			statp.setString(3, c.getCognome());
			
			statp.setInt(4, c.getEta());
			
			statp.setString(5, c.getTelefono());
			
			statp.setString(6, c.getEmail());
			
			if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Cliente aggiunto al database");
			else JOptionPane.showMessageDialog(null, "Cliente non aggiunto al database");;  
		  
		  //CHIUDO LA CONNESSIONE CON IL DATABASE
		  con.close();
		  statp.close();
	}
	
	/**
	 * Questo metodo restituisce un array di oggetti di tipo cliente
	 * @return clienti un arrrey di oggetti di tipo cliente
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<cliente> visualizzaClienti()throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//STAMPO TUTTI I CLIENTI PRESENTI NEL DATABASE
		
		//APRO LA CONNESSIONE AL DATABASE
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				ResultSet result;
				Statement query=con.createStatement();
				 
				ArrayList<cliente> clienti=new ArrayList<>();
				
				result=query.executeQuery("SELECT * FROM cliente");
					
					while(result.next()){
						clienti.add(new cliente(result.getString("CF"),result.getString("nome"), 
								result.getString("cognome"), Integer.parseInt(result.getString("eta")),
								result.getString("telefono"), result.getString("email")));
										}
				
				
				//CHIUDO LA CONNESSIONE CON IL DATABASE
			  	con.close();
			  	return clienti;
		
		
	}
}
