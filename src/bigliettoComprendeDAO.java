
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

/**
 * Questa classe rappresenta un oggetto bigliettoComprendeDAO
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class bigliettoComprendeDAO {
	private bigliettoComprendeDAO(){}
	
	/**
	 * Il metodo permette l'inserimento di un oggetto bigliettoComprende, all'interno del database
	 * @param bC un oggetto di tipo bigliettoComprende che contiene 
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void inserisciBigliettoComprende(bigliettoComprende bC) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		//APRO LA CONNESSIONE AL DATABASE
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/progettojava?user=root");
		
		PreparedStatement statp;
		String up;
		
		up="INSERT INTO bigliettocomprende VALUES(?,?)";
		
		statp=con.prepareStatement(up);
			
		statp.setString(2, bC.getCodAttivita());
	
		statp.setString(1, bC.getCodBiglietto());
		
		if(statp.executeUpdate()==1)
			JOptionPane.showMessageDialog(null, "Attività aggiunta al biglietto");
		else JOptionPane.showMessageDialog(null, "Attività non aggiunta al biglietto");
				
		//CHIUDO LA CONNESSIONE CON IL DATABASE
		con.close();
		statp.close();
	}
}
