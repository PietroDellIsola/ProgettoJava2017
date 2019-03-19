import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

/**
 * Questa classe rappresenta il frame relativo all'inserimento di un nuovo cliente nel database
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class frameInsertCliente extends JFrame
{
	/**
	 * Costruttore, crea un frameInsertCliente
	 */
	public frameInsertCliente(){
		setTitle("Inserimento dati cliente");
		add(frameInsertCliente2(),new BorderLayout().WEST);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String cF=cFfield.getText();
				cFfield.setText("");
				
				String nome=nomeField.getText();
				nomeField.setText("");
				
				String cognome=cognomeField.getText();
				cognomeField.setText("");
				
				int eta= Integer.parseInt(etaField.getText());
				etaField.setText("");
				
				String telefono=telefonoField.getText();
				telefonoField.setText("");
				
				String email=emailField.getText();
				emailField.setText("");
				
				cliente nuovoCliente=new cliente(cF, nome, cognome, eta, telefono, email);
				try {
					clienteDAO.inserisciCliente(nuovoCliente);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Puoi inserire un altro cliente se lo desideri o chiudere la finestra");
				
			}
		});
		
		add(button,new BorderLayout().EAST);
					
		pack();
	}
	
	/**
	 * Questo metodo restituisce un pannello che contiene tutti i componenti necessari all'inserimento del nuovo cliente
	 * @return panel un pannello che contiene tutti i componenti necessari all'inserimento del nuovo cliente
	 */
	public JPanel frameInsertCliente2(){
		JPanel panel =new JPanel(new GridLayout(6,2));
				
		JLabel labelCF=new JLabel("CF");
		panel.add(labelCF);
		cFfield=new JTextField("",10);
		panel.add(cFfield);
		
		JLabel labelNome=new JLabel("Nome");
		panel.add(labelNome);
		nomeField=new JTextField("",10);
		panel.add(nomeField);
		
		JLabel labelCognome=new JLabel("Cognome");
		panel.add(labelCognome);
		cognomeField=new JTextField("",10);
		panel.add(cognomeField);
		
		JLabel labelEta=new JLabel("Età");
		panel.add(labelEta);
		etaField=new JTextField("",10);
		panel.add(etaField);
		
		JLabel labelTelefono=new JLabel("Telefono");
		panel.add(labelTelefono);
		telefonoField=new JTextField("",10);
		panel.add(telefonoField);
		
		JLabel labelEmail=new JLabel("Email");
		panel.add(labelEmail);
		emailField=new JTextField("",10);
		panel.add(emailField);
				
		return panel;
	}
	
	
	
	private JTextField cFfield;
	private JTextField nomeField;
	private JTextField cognomeField;
	private JTextField etaField;
	private JTextField telefonoField;
	private JTextField emailField;
}
