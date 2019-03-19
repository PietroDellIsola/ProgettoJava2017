import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Questa classe rappresenta il frame per scegliere le attività ed associarle ad un biglietto acquistato
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class frameScegliAttivita extends JFrame 
{
	/**
	 * Costruttore, crea un frameScegliAttivita
	 * @param CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @param idParco - un intero che rappresenta il codice identificativo del parco
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public frameScegliAttivita(String CodBiglietto,int idParco) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		JPanel panelSouth=new JPanel();
		
		setLayout(new BorderLayout());
		setTitle("Scegli le attività");
		
		add(AttivitaPanel(CodBiglietto),BorderLayout.NORTH);
				
		areaVisualizzazione=new JTextArea(10,80);
		areaVisualizzazione.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(areaVisualizzazione,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		panelSouth.add(scrollPane,BorderLayout.SOUTH);//AREA DI STAMPA
		
		
		ArrayList<attivita>attivita=new ArrayList<>();
		attivita=attivitaDAO.stampaAttivita();
		areaVisualizzazione.append("\nAttività presenti nel parco:\n");
		for(attivita a:attivita){
			if(a.getIdParco()==idParco)
				areaVisualizzazione.append("\n"+a.toString()+"\n");
		}
		
		panelSouth.add(calcoloPanel(CodBiglietto));
		
		add(panelSouth);
		pack();
	}
	
	/**
	 * Questo metodo restituisce un pannello che contiene tutti i componenti necessari 
	 * @param CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @return panel - un pannello contenente tutti i componenti necessari 
	 */
	public JPanel AttivitaPanel(String CodBiglietto){
		
		JPanel panel=new JPanel();
		
		TitledBorder titleBorder = new TitledBorder("Inserisci il codice dell'attività che vuoi agiungere al biglietto");
		panel.setBorder(titleBorder);
		
		JLabel labelAttivita=new JLabel("CodAttività");
		panel.add(labelAttivita);
		attivitaField=new JTextField("",10);
		panel.add(attivitaField);
		
		JButton AggiungiAttivita=new JButton("Aggiungi attività");
		AggiungiAttivita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String codAttivita=attivitaField.getText();
				attivitaField.setText("");
				
				bigliettoComprende bC=new bigliettoComprende(CodBiglietto, codAttivita);
				try {
					bigliettoComprendeDAO.inserisciBigliettoComprende(bC);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		panel.add(AggiungiAttivita);
				
		return panel;
	}
	
	/**
	 *  Questo metodo restituisce un pannello che contiene tutti i componenti necessari 
	 * @param CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @return panel - un pannello contenente tutti i componenti necessari 
	 */
	public JPanel calcoloPanel(String CodBiglietto){
		JPanel panel=new JPanel();
		JTextField prezzoTot=new JTextField("",10);
		
		
		JButton CalcoloPrezzo=new JButton("Calcola prezzo biglietto");
		CalcoloPrezzo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String risultatoPrezzo = "";
				try {
					risultatoPrezzo=calcoloPrezzoTotale(CodBiglietto);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				prezzoTot.setText(risultatoPrezzo);
				
			}
		});
		
		panel.add(CalcoloPrezzo);
		
		panel.add(prezzoTot);
		prezzoTot.setEditable(false);
		
		return panel;
	}
	
	/**
	 * Il metodo calcola il prezzo totale del biglietto
	 * @param CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @return totPrezzo - un float che rappresenta il prezzo totale del biglietto, sommando il costo di tutte le attività selezionate
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String calcoloPrezzoTotale(String CodBiglietto) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
		String totPrezzo="";
		
		totPrezzo=bigliettoDAO.calcoloPrezzoBigliettoNormale(CodBiglietto);
		
		return totPrezzo;
	}
	
	private JTextArea areaVisualizzazione;
	private JTextField attivitaField;
}
