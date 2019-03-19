

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

/**
 * Questa classe rappresenta il frame relativo al login di un gestore o agenzia
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class frameLogin extends JFrame
{
	/**
	 * Costruttore, crea un frameLogin
	 */
	public frameLogin(){
		setTitle("Benvenuto");
		setLayout(new BorderLayout());
		
		add(pannelloNord(),BorderLayout.NORTH);
		add(pannelloEst(),BorderLayout.EAST);
		
		setSize(350,130);
	}
	
	/**
	 * Questo metodo restituisce un pannello che contiene tutti i componenti necessari 
	 * @return panel - un pannello contenente tutti i componenti necessari 
	 */
	public JPanel pannelloNord(){
		JPanel panel=new JPanel();
		panel.setLayout(new GridLayout(2,2));
		
		IDlabel=new JLabel("ID:",10);
		panel.add(IDlabel);
		ID=new JTextField(10);
		panel.add(ID);
		
		passwordLabel=new JLabel("Password",10);
		panel.add(passwordLabel);
		password=new JPasswordField(10);
		panel.add(password);
		
		
		return panel;
	}
	
	/**
	 * Questo metodo restituisce un pannello che contiene un bottone
	 * @return panel - un pannello che contiene un bottone
	 */
	public JPanel pannelloEst(){
		JPanel panel=new JPanel();
		
		inoltra=new JButton("INOLTRA");
		inoltra.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					if(ID.getText().equals("admin")&&password.getText().equals("admin"))
						{
						//APRO L'INTERFACCIA  GESTORE
						frameGestore fG=new frameGestore();
						fG.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);//IL PRGRAMMA NON TERMINA
																// VIENE OCCULTATO SOLTANTO IL FRAME
						fG.setVisible(true);
						}
						
						
					else{
					PIVAag="";
					PIVAag=accountAgenziaDAO.login(new accountAgenzia(ID.getText(),password.getText(),null));
					if(PIVAag.equals(""))JOptionPane.showMessageDialog(null, "ID o password errati!");
					else{
							//APRO L'INTERFACCIA AGENZIA DI QUELL AGENZIA(P_IVA)
							frameAgenzia fA=new frameAgenzia(PIVAag,ID.getText());
							fA.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
							fA.setVisible(true);
						}
					
					}
					ID.setText("");
					password.setText("");
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
																													}
				
													}
		});
		
		panel.setLayout(new BorderLayout());
		panel.add(inoltra,BorderLayout.EAST);
		
		return panel;
	}
	
	public String PIVAag;
	private JTextField ID;
	private JPasswordField password;
	private JLabel IDlabel;
	private JLabel passwordLabel;
	private JButton inoltra;
}
