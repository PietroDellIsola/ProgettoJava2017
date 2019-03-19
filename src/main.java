
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;

/**
 * Questa classe rappresenta il main del progetto
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class main {

	/**
	 * 
	 * @param args
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		frameLogin login=new frameLogin();
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
		
	}

}
