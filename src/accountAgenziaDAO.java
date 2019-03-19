
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 * Questa classe rappresenta un oggetto accountAgenziaDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class accountAgenziaDAO {
	
	private accountAgenziaDAO(){}
	
	/**
	 * Il metodo permette l'inserimento di un oggetto accountAgenzia nel database
	 * @param aA un oggetto accountAgenzia che contiene ID, password e P_IVA
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void insertAccount(accountAgenzia aA) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
				 
		PreparedStatement statp;
		String up;
		
		up="INSERT INTO accountagenzia() VALUES (?,?,?) ";
				statp=con.prepareStatement(up);
				
				statp.setString(1,aA.getID());
				
				statp.setString(2, aA.getPassword());
				
				statp.setString(3, aA.getP_IVA());
								
				if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Account aggiunto al database");
				else JOptionPane.showMessageDialog(null, "Account non aggiunto al database");;  
			  
				//CHIUDO LA CONNESSIONE CON IL DATABASE
				con.close();
				statp.close();
		
	}
	
	/**
	 * Il metodo confronta l'ID e la password del parametro esplicito di tipo accountAgenzia, e restituisce la P_IVA presente nel database se da esito positivo, altrimenti una stringa vuota
	 * @param a un oggetto accountAgenzia che contiene ID, password e P_IVA
	 * @return P_IVA una stringa che rappresenta la partita iva dell'agenzia
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static String login(accountAgenzia a) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
			 
			  PreparedStatement statp;
			  ResultSet result;
			  String up;
		  	  String P_IVA="";
		 
		up="SELECT P_IVA FROM accountAgenzia "
						+ "WHERE ID=? AND password=? GROUP BY P_IVA";
		 
		statp=con.prepareStatement(up);
		statp.setString(1,a.getID());
		statp.setString(2,a.getPassword());
		
		result= statp.executeQuery();
		while(result.next())
			P_IVA=result.getString("P_IVA"); //ASSEGNAMO IL RISULTATO DELLA QUERY A P_IVA
		
		
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		
		return P_IVA; //RESTITUISCE LA P_IVA DELL'AGENZIA CHE HA EFFETTUATO IL LOGIN
	}

}
