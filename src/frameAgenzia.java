
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Questa classe rappresenta il frame relativo alle operazioni che può svolgere un'agenzia
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class frameAgenzia  extends JFrame 
{
	
	/**
	 * Costruttore, crea un frameAgenzia
	 * @param P_IVA - una stringa che rappresenta la partita iva di un'agenzia che ha effettuato il login
	 * @param ID una - stringa che rappresenta il nome dell'agenzia che ha effettuato il login
	 */
	public frameAgenzia(String P_IVA,String ID){
		this.PIVAag=P_IVA;
		
		setTitle("Bentornato: "+ID);
		setLayout(new GridLayout(4,1));
		
		add(primoPannello());
		add(secondoPannello());
		add(terzoPannello());
		
		areaVisualizzazione=new  JTextArea(50,50);
		areaVisualizzazione.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(areaVisualizzazione,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane);//AREA DI STAMPA
		
		setExtendedState( JFrame.MAXIMIZED_BOTH);//SETTA LA FINESTRA ALLA GRANDEZZA MASSIMA DELLO SCHERMO
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la prima operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel primoPannello(){
		JPanel panel=new JPanel();
		
		TitledBorder titleBorder = new TitledBorder("Creare singoli pacchetti");
		panel.setBorder(titleBorder);
		
		panel.add(primoPannello2());
		
		JButton buttonVisualizza=new JButton("VISUALIZZA HOTEL E RISTORANTI");
		buttonVisualizza.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("\nHotel e ristoranti presenti nel database:\n");
				ArrayList<ristoroAlloggio>ristoroAlloggi=new ArrayList<>();
				try {
					ristoroAlloggi=ristoroAlloggioDAO.stampaRistoroAlloggio();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				for(ristoroAlloggio rA:ristoroAlloggi){
					areaVisualizzazione.append("\n"+rA.toString());
				}
			}
		});
		
		panel.add(buttonVisualizza);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				
				String codPacchetto= codPacchettoField.getText();
								
				try {
					if(pacchettoDAO.isPresente(codPacchetto).equals("")){
					
					String nome=nomeField.getText();
														
					String descrizione=descrizioneField.getText();
					
					
					String d=dataIField.getText();
					GregorianCalendar dataI=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
					
					
					d=dataFField.getText();
					GregorianCalendar dataF=new GregorianCalendar(Integer.parseInt(d.substring(0, 4)),Integer.parseInt(d.substring(5,7)),Integer.parseInt(d.substring(8, 10)));
					
					
					float prezzo=Float.parseFloat(prezzoField.getText());
					
					
					int idRA=Integer.parseInt(idRAField.getText());
					
					
					if(ristoroAlloggioDAO.isPresente(idRA)==idRA){
					
					pacchetto p= new pacchetto(codPacchetto, nome, descrizione, dataI, dataF, prezzo, idRA, PIVAag, null, null);
					try {
						pacchettoDAO.creaPacchetto(p, PIVAag);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
					
					
					codPacchettoField.setText("");
					nomeField.setText("");
					descrizioneField.setText("");
					dataIField.setText("");
					dataFField.setText("");
					prezzoField.setText("");
					idRAField.setText("");
					
					}//CHIUSURA IL IDRA È VALIDO
					
					else{
							idRAField.setText("");
							throw new eccezioneChiaveNonValida("Il codice identificativo del hotel/ristorante inserito, non è valido");
						}
					
					}//CHIUSURA IF(CodPacchetto È PRESENTE NEL DATABASE)
					
					else throw new eccezioneChiavePrimariaGiaPresente("Attenzione, il CodPacchetto inserito è già presente nel database");
				
				} catch (NumberFormatException | InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
			
			}
		});
		
		panel.add(button);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la prima operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel primoPannello2(){
		JPanel panel=new JPanel(new GridLayout(7,2));
		
		JLabel labelCodPacchetto=new JLabel("CodPacchetto");
		panel.add(labelCodPacchetto);
		codPacchettoField=new JTextField("",10);
		panel.add(codPacchettoField);
		
		JLabel labelnome=new JLabel("Nome pacchetto");
		panel.add(labelnome);
		nomeField=new JTextField("",10);
		panel.add(nomeField);
		
		JLabel labelDescrizione=new JLabel("Descrizione");
		panel.add(labelDescrizione);
		descrizioneField=new JTextField("",10);
		panel.add(descrizioneField);
		
		JLabel labelDataI=new JLabel("Data iniziale (yyyy/mm/dd)");
		panel.add(labelDataI);
		dataIField=new JTextField("",10);
		panel.add(dataIField);
		
		JLabel labelDataF=new JLabel("Data finale (yyyy/mm/dd)");
		panel.add(labelDataF);
		dataFField=new JTextField("",10);
		panel.add(dataFField);
		
		JLabel labelprezzo=new JLabel("Prezzo");
		panel.add(labelprezzo);
		prezzoField=new JTextField("",10);
		panel.add(prezzoField);
		
		JLabel labelIdRA=new JLabel("ID Rist./All.");
		panel.add(labelIdRA);
		idRAField=new JTextField("",10);
		panel.add(idRAField);
						
		//LA PARTITA IVA NN LA RICHIEDIAMO POICHÈ LA REPERIAMO DAL LOGIN
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la seconda operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel secondoPannello(){
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Vendere singoli pacchetti");
		panel.setBorder(titleBorder);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new GridLayout(3,1));
		
		//PRIMA DI INSERIRE IL CF IN PACCHETTO STAMPA TUTTI I CLIENTI PRESENTI NEL DATABASE
		
		panel.add(secondoPannello2());
		
		JButton button2=new JButton("VISUALIZZA PACCHETTI E CLIENTI");
		button2.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("Clienti presenti nel database:\n");
				//VISUALIZZO TUTTI I CLIENTI
				ArrayList<cliente>clienti=new ArrayList<>();
				try {
					clienti=clienteDAO.visualizzaClienti();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				for(cliente c:clienti){
					areaVisualizzazione.append("\n"+c.toString());
				}
				
				areaVisualizzazione.append("\n\nPacchetti Disponibili:\n");
				//VISUALIZZO PACCHETTI DISPONIBILI RELATIVI ALL'AGENZIA CHE HA EFFETTUATO IL LOGIN
				boolean flag=false;
				ArrayList<pacchetto>pacchetti=new ArrayList<>();
				try {
					pacchetti=pacchettoDAO.stampaPacchettiDisponibili(PIVAag);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				for(pacchetto p:pacchetti){
					areaVisualizzazione.append("\n"+p.toString());
					flag=true;
				}
				if(flag==false)areaVisualizzazione.append("\nNessun pacchetto disponibile\n");
				
				
			}
		});
		
		panel2.add(button2);
		
		JButton button3=new JButton("Visualizza biglietti acquistati dal cliente");
		button3.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				ArrayList<biglietto>biglietti=new ArrayList<>();
				boolean haveBiglietto=false;
				try {
					biglietti=agenziaDAO.bigliettiParchiConvenzionati(PIVAag);
					
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				areaVisualizzazione.setText("\nBiglietti acquistati dal cliente selezionato:\n");
				
				for(biglietto b: biglietti){
					if((b.getCF().equals(cFField.getText()))&&(b.getCodPacchetto().equals(""))){
						areaVisualizzazione.append("\n"+b.toString());
						haveBiglietto=true;		
															}
				}
				if(haveBiglietto==false)areaVisualizzazione.append("\nIl cliente non ha acquistato biglietti, oppure"
						+ " quelli acquistati sono già associati ad un altro pacchetto disponibili, oppure il clienti non ha acquistato biglietti "
						+ "di parchi convenzionati con questa agenzia");
				
			}
		});
		
		panel2.add(button3);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
				//PRELEVO IL CF DEL CLIENTE
				String cF=cFField.getText();
				
				try {
					if(clienteDAO.isPresente(cF).equals(cF)){
										
					String codPacchetto= codPacchettoField2.getText();
					
					if(pacchettoDAO.isPresente(codPacchetto).equals(codPacchetto)){
										
					String codBiglietto=codBigliettoField.getText();
					
					if(bigliettoDAO.isPresente(codBiglietto).equals(codBiglietto)){
												
					try {
						
							pacchetto pacchettoVendere=new pacchetto(codPacchetto, "", "", null, null, 0, 0, PIVAag, cF, null);
							pacchettoDAO.vendiPacchetto(pacchettoVendere, PIVAag);
							bigliettoDAO.aggiornaCodPacchetto(codBiglietto,cF, codPacchetto);
							
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
							e1.printStackTrace();
					}
					
					cFField.setText("");
					codPacchettoField2.setText("");
					codBigliettoField.setText("");
					
					}//CHIUSURA IF, CODBIGLIETTO VALIDO
					
					else{
							codBigliettoField.setText("");
							throw new eccezioneChiaveNonValida("Il CodBiglietto inserito non è presente nel database. Inserire un CodBiglietto valido");
						}
					
					}//CHIUSURA IF, CODPACCHETTOVALIDO
					
					else{
							codPacchettoField2.setText("");
							throw new eccezioneChiaveNonValida("Il CodPacchetto inserito non è presente nel database. Inserire un CodPacchetto valido");
						}
					
					}//CHIUSURA IF, CF VALIDO
					
					else {
							cFField.setText("");
							throw new eccezioneChiaveNonValida("Il CF inserito non è presente nel database. Inserire un CF valido");
						}
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
					
			}
		});
		
		panel2.add(button);
		
		panel.add(panel2);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la seconda operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel secondoPannello2(){
		JPanel panel=new JPanel(new GridLayout(3,3));
		
		JLabel labelCF=new JLabel("CF");
		panel.add(labelCF);
		cFField=new JTextField("",10);
		panel.add(cFField);

		JLabel labelCodBiglietto=new JLabel("CodBiglietto");
		panel.add(labelCodBiglietto);
		codBigliettoField=new JTextField("",10);
		panel.add(codBigliettoField);
		
		JLabel labelCodPacchetto=new JLabel("CodPacchetto");
		panel.add(labelCodPacchetto);
		codPacchettoField2=new JTextField("",10);
		panel.add(codPacchettoField2);
		
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la terza operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel terzoPannello(){
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Visualizza i pacchetti ed il relativo incasso");
		panel.setBorder(titleBorder);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				
				ArrayList<pacchetto>pacchetti=new ArrayList<>();
				try {
					pacchetti=pacchettoDAO.stampaPacchettiVenduti(PIVAag);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
				float incassoTot=0;
				for(pacchetto p:pacchetti){
					areaVisualizzazione.append("\n"+p.toString());
					incassoTot=incassoTot+p.getPrezzo();
										}
				if(incassoTot==0)areaVisualizzazione.append("\nNessun pacchetto Venduto\n");
				if(incassoTot!=0)areaVisualizzazione.append("\n\nIncasso totale:  "+incassoTot);
				
			}
		});
		
		
		panel.add(button);
		
		return panel;
	}
	
	
	
	
	//PRIMO PANNELLO----------------
	private JTextField codPacchettoField;
	private JTextField nomeField;
	private JTextField descrizioneField;
	private JTextField dataIField;
	private JTextField dataFField;
	private JTextField prezzoField;
	private JTextField idRAField;
	//----------------------------
	//SECONDO- PANNELLO------------
	private JTextField cFField;
	private JTextField codPacchettoField2;
	private JTextField codBigliettoField;
	//--------------------------
	
	private String PIVAag;
	private JTextArea areaVisualizzazione; 
}
