
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Questa classe rappresenta un oggetto convenzionatoDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class convenzionatoDAO {
	
	private convenzionatoDAO(){}
	
	/**
	 * Questo metodo inserisce un oggetto di tipo convenzionato nel database
	 * @param c un oggetto di tipo convenzionato
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciConvenzione(convenzionato c) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		 
		PreparedStatement statp;
		String up;
		
		up="INSERT INTO convenzionato() VALUES (?,?) ";
		statp=con.prepareStatement(up);
			
		statp.setInt(1, c.getIdParco());//INSERISCO L'ID DEL PARCO
		statp.setString(2, c.getP_IVA());//INSERISCO LA P.IVA DELL' AGENZIA
		
		if(statp.executeUpdate()==1)JOptionPane.showMessageDialog(null, "Convenzione aggiunta al database");
		else JOptionPane.showMessageDialog(null, "Convenzione non aggiunta al database");;  
	  
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
		
		
								}

}
