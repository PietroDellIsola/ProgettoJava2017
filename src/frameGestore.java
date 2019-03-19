

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 * Questa classe rappresenta il frame relativo alle operazioni che può svolgere un gestore
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class frameGestore extends JFrame
{
	
	/**
	 * Costruttore, crea un frameGestore
	 */
	public frameGestore(){
		setTitle("Salve gestore");
		setLayout(new BorderLayout());
		
		areaVisualizzazione=new JTextArea(15,20);
		areaVisualizzazione.setEditable(false);
		
		add(totPanel(), BorderLayout.NORTH); //LISTA DI OPERAZIONI DA POTER ESEGUIRE
		
		JScrollPane scrollPane = new JScrollPane(areaVisualizzazione,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane,BorderLayout.SOUTH);//AREA DI STAMPA
				
		setExtendedState( JFrame.MAXIMIZED_BOTH);//SETTA LA FINESTRA ALLA GRANDEZZA MASSIMA DELLO SCHERMO
		
							}
	
	/**
	 * Questo metodo restituisce un pannello che contiene tutti i pannelli necessari per le operazioni del gestore	
	 * @return panel - un pannello contenente tutti i pannelli occorrenti per le operazioni del gestore
	 */
	public JPanel totPanel(){
		//LISTA DI OPERAZIONI DA POTER ESEGUIRE
		JPanel panel=new JPanel(new GridLayout(4,2));
		panel.add(primoPannello());
		panel.add(secondoPannello());
		panel.add(terzoPannello());
		panel.add(quartoPannello());
		panel.add(quintoPannello());
		panel.add(sestoPannello());
		panel.add(settimoPannello());
		panel.add(ottavoPannello());
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la prima operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel primoPannello(){
		//PRIMA OPERAZIONE DA POTER ESEGUIRE
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Visualizza le informazioni relative ad i parchi ed i biglietti venduti");
		panel.setBorder(titleBorder);
		
		JButton button=new JButton("PROCEDI"); 
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				ArrayList<parco> par=new ArrayList<>();
				int c=0,j=0;
				
				try {
					par = parcoDAO.stampaParchi();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				
					e1.printStackTrace();
				}
		 		ArrayList<biglietto> bigl=new ArrayList<>();
		 		
				try {
					bigl = bigliettoDAO.stampaBiglietti();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
		 		for(parco parco:par){
		 			
		 			areaVisualizzazione.append("\n"+parco.toString());
		 			c=0;
		 			for(j=0;j<bigl.size()-1;j++){
		 				if(bigl.get(j).getIdParco()==parco.getIdParco()){
		 					areaVisualizzazione.append("\n"+bigl.get(j).toString());
		 					c++;
		 																}
		 										}
		 			if(c==0)areaVisualizzazione.append("\nNessun biglietto venduto per questo parco");
		 			areaVisualizzazione.append("\n\n");
		 							}
			}
		});
		
		panel.add(button);
		
		return panel;
	}
	
	
	/**
	 * Il metodo crea un pannello occorrente per la seconda operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel secondoPannello(){
		//SECONDA OPERAZIONE 2.0
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Visualizza promozioni attive, inserendo due date");
		panel.setBorder(titleBorder);
		
		panel.add(secondoPannello2());
		
		JButton button=new JButton("PROCEDI"); 
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("\nPromozioni attive dal "+data1.getText()+" al "+data2.getText()+" :\n");
				ArrayList<promozione> pac=new ArrayList<>();
				boolean isTherePromozione=false;
				try {
					pac=promozioneDAO.stampaPromozioniAttive(data1.getText(), data2.getText());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
				for(promozione p: pac){
					areaVisualizzazione.append("\n"+p.toString()+"\n");
					isTherePromozione=true;
				}
			
				if(isTherePromozione==false)areaVisualizzazione.append("\nNessuna promozione attiva durante l'intervallo di tempo specificato");
			}
		});
		
		panel.add(button);
	
		return panel;
									}
	
	/**
	 * Il metodo crea un pannello occorrente per la seconda operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel secondoPannello2(){
		//SECONDA OPERAZIONE 1.0
		JPanel panel=new JPanel(new GridLayout(2,2));
		
		JLabel label1=new JLabel("Data iniziale");
		panel.add(label1);
		data1=new JTextField("yyyy/mm/dd",10);
		panel.add(data1);
		
		JLabel label2=new JLabel("Data finale");
		panel.add(label2);
		data2=new JTextField("yyyy/mm/dd",10);
		panel.add(data2);
		
		return panel;
		
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la terza operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel terzoPannello(){
		//TERZA OPERAZIONE 2.0
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Visualizza promozioni attive per una "
				+ "determinata attività (specifica con quale ordine: cronologico o lessicografico)");
		panel.setBorder(titleBorder);
				
		panel.add(terzoPannello2());
		
		JButton buttonVisualizza=new JButton("Visualizza attività");
		buttonVisualizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<attivita>attivita=new ArrayList<>();	
				areaVisualizzazione.setText("\nElenco attività: \n");
				try {
					attivita=attivitaDAO.stampaAttivita();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					 e1.printStackTrace();
				}
				for(attivita a:attivita){
					areaVisualizzazione.append("\n"+a.toString()+"\n");
				}
			}
		});
		
		panel.add(buttonVisualizza);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				boolean isThereAttivita=false;
				areaVisualizzazione.setText("\nPromozioni per l'attività ' "+nomeAttivitaField.getText()+" ':\n");
				ArrayList<promozione> prom=new ArrayList<>();
				if(radioButton1.isSelected())
					try {
						prom=promozioneDAO.stampaPromozione(nomeAttivitaField.getText(),"C");
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e2) {
						e2.printStackTrace();
					}
				if(radioButton2.isSelected())
					try {
						prom=promozioneDAO.stampaPromozione(nomeAttivitaField.getText(),"L");
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
							| SQLException e1) {
						e1.printStackTrace();
					}
				
				for(promozione p: prom){
					isThereAttivita=true;
					areaVisualizzazione.append("\n"+p.toString()+"\n");
				}

				if(isThereAttivita==false)areaVisualizzazione.append("\nNon ci sono promozioni per l'attività  ' "+nomeAttivitaField.getText()+" ',"
						+ " oppure il nome inserito è errato");
			}
		});
		

		panel.add(button);
				
		return panel;
	
	}

	/**
	 * Il metodo crea un pannello occorrente per la terza operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel terzoPannello2(){
		//TERZA OPERAZIONE 2.0
		JPanel panel=new JPanel(new GridLayout(3,3));
		JLabel attivita=new JLabel("Nome attivita");
		panel.add(attivita);
		
		nomeAttivitaField=new JTextField("",10);
		panel.add(nomeAttivitaField);
		
		JLabel ordine=new JLabel("Ordine:");
		radioButton1=new JRadioButton("Cronologico");
		radioButton2=new JRadioButton("Lessicografico");
		
		ButtonGroup bg=new ButtonGroup();
		bg.add(radioButton1);
		bg.add(radioButton2);
		
		panel.add(ordine);
		
		JPanel panel2=new JPanel();
		panel2.add(radioButton1);
		panel2.add(radioButton2); 
		radioButton1.setSelected(true);
		
		panel.add(panel2);
		
		return panel;
	
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la quarta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel quartoPannello(){
		//QUARTA OPERAZIONE
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Visualizza tutti i pacchetti in vendita dalle agenzie");
		panel.setBorder(titleBorder);
		

		JButton button=new JButton("PROCEDI"); 
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("\nPacchetti disponibili :\n");
				ArrayList<pacchetto> pac=new ArrayList<>();
				boolean isTherePacchetto=false;
				try {
					pac=pacchettoDAO.stampaTuttiPacchettiDisponibili();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
				for(pacchetto p:pac){
					areaVisualizzazione.append("\n"+p.toString()+"\n");
					isTherePacchetto=true;
				}
			
				if(isTherePacchetto==false)areaVisualizzazione.append("\nI paccheti in vendita da parte delle agenzie, sono terminati");
			}			
		});
		
		panel.add(button);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la quinta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel quintoPannello(){
		//QUINTA OPERAZIONE
		JPanel panel=new JPanel();
		TitledBorder titleBorder = new TitledBorder("Inserisci una nuova attività");
		panel.setBorder(titleBorder);
		panel.add(quintoPannello2());
		
		JPanel panelVisualizzazione=new JPanel(new GridLayout(2,1));
		
		JButton buttonVisParchi=new JButton("Visualizza parchi");
		
		buttonVisParchi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("\nParchi: \n");
				ArrayList<parco>parchi=new ArrayList<>();
				try {
					parchi=parcoDAO.stampaParchi();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
				for(parco p:parchi){
					areaVisualizzazione.append("\n"+p.toString()+"\n");
									}
				
				}
		});
		
		panelVisualizzazione.add(buttonVisParchi);
		
		JButton buttonVisStrutture=new JButton("Visualizza le strutture del parco");
		
		buttonVisStrutture.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("\nStrutture: \n");
				ArrayList<struttura>strutture=new ArrayList<>();
				try {
					strutture=strutturaDAO.stampaStrutture();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				for(struttura s:strutture){
					if(s.getIdParco()==Integer.parseInt(IdParcoField.getText()))
						areaVisualizzazione.append("\n"+s.toString()+"\n");
				}
				
			}
		});
		
		panelVisualizzazione.add(buttonVisStrutture);
		
		panel.add(panelVisualizzazione);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				
				String codAttivita=attivitaField.getText();
				
				try {
					if(attivitaDAO.isPresente(codAttivita).equals("")){
					
					String nome=nomeField.getText();
					
					Float costo=Float.parseFloat(costoField.getText());
					
					String orario=orarioField.getText();
					
					boolean disponibilita=Boolean.parseBoolean(disponibilitaField.getText());
										
					int idParco=Integer.parseInt(IdParcoField.getText());
					if(parcoDAO.isPresente(idParco)==idParco){
										
					String codStruttura=CodStrutturaField.getText();
					if(strutturaDAO.isPresente(codStruttura).equals(codStruttura)){
					
					attivita nuovaAttivita=new attivita(codAttivita, nome, costo, orario, disponibilita, 
							idParco, codStruttura);
					try {
						attivitaDAO.inserisciAttivita(nuovaAttivita);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
					
					attivitaField.setText("");
					nomeField.setText("");
					costoField.setText("");
					orarioField.setText("");
					disponibilitaField.setText("");
					IdParcoField.setText("");
					CodStrutturaField.setText("");
					
																				}
					
					else{
							CodStrutturaField.setText("");
							throw new eccezioneChiaveNonValida("Il codice struttura il serito, non è valido"); 
						}
					
																}
										
					else {
							IdParcoField.setText("");
							throw new eccezioneChiaveNonValida("Il codice identificativo del parco inserito, non è valido");			
						 }
					
					}//CHIUSURA IF(codATTIVITA SE PRESENTE)
					
					else throw new eccezioneChiavePrimariaGiaPresente("Attenzione, il CodAttività inserito è già presente nel database");
					
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
	 * Il metodo crea un pannello occorrente per la quinta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel quintoPannello2(){
		//QUINTA OPERAZIONE 2.0
		JPanel panel=new JPanel(new GridLayout(7,2));
		
		JLabel labelAttivita=new JLabel("CodAttività");
		panel.add(labelAttivita);
		attivitaField=new JTextField("",10);
		panel.add(attivitaField);
		
		JLabel labelNome=new JLabel("Nome");
		panel.add(labelNome);
		nomeField=new JTextField("",10);
		panel.add(nomeField);
		
		JLabel labelCosto=new JLabel("Costo");
		panel.add(labelCosto);
		costoField=new JTextField("",10);
		panel.add(costoField);
		
		JLabel labelOrario=new JLabel("Orario"); 
		panel.add(labelOrario);
		orarioField=new JTextField("",10);
		panel.add(orarioField);
		
		JLabel labelDisponibilta=new JLabel("Disponibilità (true/false)");
		panel.add(labelDisponibilta);
		disponibilitaField= new JTextField("",10);
		panel.add(disponibilitaField);
		
		JLabel labelIdParco=new JLabel("IdParco");
		panel.add(labelIdParco);
		IdParcoField=new JTextField("",10);
		panel.add(IdParcoField);
		
		JLabel labelCodStruttura=new JLabel("CodStruttura");
		panel.add(labelCodStruttura);
		CodStrutturaField=new JTextField("",10);
		panel.add(CodStrutturaField);
		
		return panel;
		
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la sesta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel sestoPannello(){
		//SESTA OPERAZIONE
		JPanel panel=new JPanel(new BorderLayout());
		
		TitledBorder titleBorder = new TitledBorder("Inserisci una nuova agenzia");
		panel.setBorder(titleBorder);
		
		panel.add(sestoPannello2(),BorderLayout.WEST);
		
		JPanel panelDestro=new JPanel(new BorderLayout());
		
		panelDestro.add(sestoPannello3(),BorderLayout.NORTH);
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				//INSERIMENTO DATI AGENZIA NEL DATABASE
				
				String p_IVA = p_ivaField.getText();
				p_ivaField.setText("");
				
				try {
					if(agenziaDAO.isPresente(p_IVA).equals("")){
					
					String nome = nomeAgenziaField.getText();
					nomeAgenziaField.setText("");
					
					String telefono=telefonoAgenziaField.getText();
					telefonoAgenziaField.setText("");
					
					String email=emailAgenziaField.getText();
					emailAgenziaField.setText("");
					
					String via= viaAgenziaField.getText();
					viaAgenziaField.setText("");
					
					String citta= cittaAgenziaField.getText();
					cittaAgenziaField.setText("");
					
					String cAP= capAgenziaField.getText();
					capAgenziaField.setText("");
					
					agenzia nuovaAgenzia=new agenzia(p_IVA, nome, telefono, email, via, citta, cAP);
					
					try {
						agenziaDAO.inserisciAgenzia(nuovaAgenzia);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
						e1.printStackTrace();
					}
					
					//INSERIMENTO DATI ACCOUNT AGENZIA NEL DATABASE
					String iD=IDagenziaField.getText();
					IDagenziaField.setText("");
					
					String password=passwordAgenziaField.getText();
					passwordAgenziaField.setText("");
					
					accountAgenzia nuovoAccountAgenzia=new accountAgenzia(iD, password, p_IVA);
					
					try {
						accountAgenziaDAO.insertAccount(nuovoAccountAgenzia);
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
					
					frameConvenzionato fC=new frameConvenzionato(p_IVA);
					fC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					fC.setVisible(true);
					
					}//CHIUSURA IF(P_IVA PRESENTE NEL DATABASE)
					
					else throw new eccezioneChiavePrimariaGiaPresente("Attenzione, la P_IVA inserita è già presente nel database");
				
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				
					e1.printStackTrace();
				}
				
				
			}
		});
				
		panelDestro.add(button,BorderLayout.SOUTH);
		
		panel.add(panelDestro,BorderLayout.EAST);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la sesta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel sestoPannello2(){
		//SESTA OPERAZIONE 2.0 (PANNELLO PER INSERIRE I DATI DELL'AGENZIA)
		JPanel panel=new JPanel(new GridLayout(7,2));
		
		JLabel labelPiva=new JLabel("P.IVA");
		panel.add(labelPiva);
		p_ivaField=new JTextField("",10);
		panel.add(p_ivaField);
		
		JLabel labelnome=new JLabel("Nome");
		panel.add(labelnome);
		nomeAgenziaField=new JTextField("",10);
		panel.add(nomeAgenziaField);
		
		JLabel labeltelefono=new JLabel("Telefono");
		panel.add(labeltelefono);
		telefonoAgenziaField=new JTextField("",10);
		panel.add(telefonoAgenziaField);
		
		JLabel labelEmail=new JLabel("Email");
		panel.add(labelEmail);
		emailAgenziaField=new JTextField("",10);
		panel.add(emailAgenziaField);
		
		JLabel labelVia=new JLabel("Via");
		panel.add(labelVia);
		viaAgenziaField=new JTextField("",10);
		panel.add(viaAgenziaField);
		
		JLabel labelCitta=new JLabel("Citta");
		panel.add(labelCitta);
		cittaAgenziaField=new JTextField("",10);
		panel.add(cittaAgenziaField);
		
		JLabel labelCAP=new JLabel("CAP");
		panel.add(labelCAP);
		capAgenziaField=new JTextField("",10);
		panel.add(capAgenziaField);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la sesta operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel sestoPannello3(){
		//SESTA OPERAZIONE 3.0 (PANNELLO PER INSERIRE DATI ACCOUNT AGENZIA)
		JPanel panel=new JPanel(new GridLayout(2,1));
		JLabel labelAccount=new JLabel("Dati per l'account");
		panel.add(labelAccount);
		
		JPanel panelField=new JPanel(new GridLayout(2,2));
		
		JLabel labeID=new JLabel("ID");
		panelField.add(labeID);
		IDagenziaField=new JTextField("",10);
		panelField.add(IDagenziaField);
		
		JLabel labePassword=new JLabel("Password");
		panelField.add(labePassword);
		passwordAgenziaField=new JTextField("",10);
		panelField.add(passwordAgenziaField);
		
		panel.add(panelField);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la settima operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel settimoPannello(){
		JPanel panel=new JPanel();
		
		TitledBorder titleBorder = new TitledBorder("Vendere singoli biglietti");
		panel.setBorder(titleBorder);
		
		panel.add(settimoPannello2());
		
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				areaVisualizzazione.setText("");
				String codBiglietto=CodBigliettoField.getText();
				
				try {
					if(bigliettoDAO.isPresente(codBiglietto).equals("")){
					
					String cF=cFClienteField.getText();
					biglietto nuovoBiglietto=null;
					
					//SE IL CLIENTE NN È PRESENTE
					
					try {
						if((clienteDAO.isPresente(cF)).equals("")){
							JOptionPane.showMessageDialog(null, "Il cliente non è presente nel database, procedere con l'inserimento");
							frameInsertCliente frameCliente=new frameInsertCliente();
							frameCliente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
							frameCliente.setVisible(true);
									
								 								}
						
						else{
							
						String tipo="";
						if(radioButtonTipo1.isSelected())tipo="Normale";
						if(radioButtonTipo2.isSelected())tipo="Promozione";
						
						//AGGIUNGIAMO LA DATA ODIERNA AL BIGLIETTO NEL DATABASE
						GregorianCalendar dataAcquisto=new GregorianCalendar();
						
						int idParco=Integer.parseInt(iDparco2Field.getText());
						
						if(parcoDAO.isPresente(idParco)==idParco){
						
						if(parcoDAO.bigliettiFiniti(idParco)==false){
						
						String codPromozione=promozioneField.getText();
						
						
						//INSERIAMO IL NUOVO BIGLIETTO
						nuovoBiglietto=new biglietto(codBiglietto, tipo, cF, codPromozione, idParco, dataAcquisto, 0, "");
						
						try {
							bigliettoDAO.inserisciBiglietto(nuovoBiglietto);
						} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
							
							e2.printStackTrace();
						}
						
						if(nuovoBiglietto.getTipo().equals("Normale")){
							//flag==false --> NESSUNA PROMOZIONE PRESENTE
							frameScegliAttivita fSa;
							try {
								fSa = new frameScegliAttivita(codBiglietto,idParco);
								fSa.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
								fSa.setVisible(true);
								} catch (InstantiationException | IllegalAccessException | ClassNotFoundException
									| SQLException e1) {
								
									e1.printStackTrace();
														}
																																	}
							
						if(nuovoBiglietto.getTipo().equals("Promozione")){
							
							bigliettoDAO.aggiuntaPrezzoBigliettoPromozione(codBiglietto, codPromozione);
							
							}																										
						
						
						
					
					//DECREMENTIAMO IL NUMERO DI BIGLIETTI DISPONIBILI DEL PARCO
					
					try {
						parcoDAO.decrementaNumBiglietti(iDparco2Field.getText());
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
					
					//SVUOTIAMO I CAMPI FIELD
					cFClienteField.setText("");
					CodBigliettoField.setText("");
					iDparco2Field.setText("");
					promozioneField.setText("");
								
					
					} //CHIUSURA IF(PARCO BIGLIETTI FINITI==FALSE)
						else  throw new eccezioneBigliettiFiniti();
					
					}//CHIUSURA PARCO IF IDPARCO VALIDO
						
					else{
							iDparco2Field.setText("");
							throw new eccezioneChiaveNonValida("Il codice identificativo del parco inserito, non è valido");
						}
						
					}//CHIUSURA ELSE CLIENTE PRESENTE
					
					} catch (HeadlessException | NumberFormatException | InstantiationException | IllegalAccessException
							| ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
					
					}//CHIUSURA IF(CodBiglietto È PRESENTE NEL DATABASE)
					
					else throw new eccezioneChiavePrimariaGiaPresente("Attenzione, il CodBiglietto inserito è già presente nel database");
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			  }
			
			
			});
		
		
		panel.add(button);
		
		return panel;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per la settima operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel settimoPannello2(){
		
		
		JPanel panel=new JPanel(new GridLayout(3,3));
		JPanel panel2=new JPanel(new GridLayout(4,1));
		JPanel panelParco=new JPanel();
		JPanel panelPromozione=new JPanel();
		JPanel finale=new JPanel(new BorderLayout());
		
		JPanel panelRadioButton=new JPanel();
		//PRIMO PANNELLO
		JLabel labelCf=new JLabel("CF");
		panel.add(labelCf);
		cFClienteField=new JTextField();
		panel.add(cFClienteField);
		
		JLabel labelCodBiglietto=new JLabel("CodBiglietto");
		panel.add(labelCodBiglietto);
		CodBigliettoField=new JTextField();
		panel.add(CodBigliettoField);
		
		JLabel tipo=new JLabel("Tipo:");
		radioButtonTipo1=new JRadioButton("Normale");
		radioButtonTipo2=new JRadioButton("Promozione");
		
		ButtonGroup bg2=new ButtonGroup();
		bg2.add(radioButtonTipo1);
		bg2.add(radioButtonTipo2);
		
		panel.add(tipo);
		
		panelRadioButton.add(radioButtonTipo1);
		panelRadioButton.add(radioButtonTipo2); 
		radioButtonTipo1.setSelected(true);
		
		panel.add(panelRadioButton);
		//----------------
		//Panel parco
		JLabel labelParco=new JLabel("ID Parco");
		panelParco.add(labelParco);
		iDparco2Field=new JTextField("",10);
		panelParco.add(iDparco2Field);
		//---------------
		//Panel promozioni
		JLabel labelPromozione=new JLabel("CodPromozione");
		panelPromozione.add(labelPromozione);
		promozioneField=new JTextField("",10);
		panelPromozione.add(promozioneField);
		//---------------
		//SECONDO
		JButton buttonVisParco=new JButton("Visualizza parchi");
		buttonVisParco.addActionListener(new ActionListener() {
		ArrayList<parco> parchi=new ArrayList<>();
			public void actionPerformed(ActionEvent e) {
				try {
					parchi=parcoDAO.stampaParchi();
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
				
					e1.printStackTrace();
				}
				areaVisualizzazione.setText("\nParchi:\n");
				
				for(parco p:parchi){
					areaVisualizzazione.append("\n"+p.toString()+"\n");
											}
				
			}
		});
		
		
		panel2.add(buttonVisParco);
		panel2.add(panelParco);
		
		JButton buttonVisPromozioni=new JButton("Visualizza promozioni");
		buttonVisPromozioni.addActionListener(new ActionListener() {
		ArrayList<promozione> promozioni=new ArrayList<>();
		boolean flag=false;	
			public void actionPerformed(ActionEvent e) {
				flag=false;
				try {
					promozioni=promozioneDAO.stampaPromozioniParco(Integer.parseInt(iDparco2Field.getText()));
				} catch (NumberFormatException | InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e1) {
					
					e1.printStackTrace();
				}
				areaVisualizzazione.setText("\nPromozioni presenti nel parco: \n");
				for(promozione p:promozioni){
					areaVisualizzazione.append("\n"+p.toString()+"\n");
					flag=true;
											}
				if(flag==false){
					areaVisualizzazione.append("\nNessuna promozione presente per questo parco");
					radioButtonTipo1.setSelected(true);
								}
			}
		});
		
		panel2.add(buttonVisPromozioni);
		panel2.add(panelPromozione);
		
		//----------
		
		finale.add(panel,BorderLayout.WEST);
		finale.add(panel2,BorderLayout.EAST);
		
		return finale;
	}
	
	/**
	 * Il metodo crea un pannello occorrente per l'ottava operazione
	 * @return panel - un pannello che contiene tutti i componenti necessari 
	 */
	public JPanel ottavoPannello(){
		JPanel panel=new JPanel(new GridLayout(2,1));
		JPanel panelRadioButton=new JPanel();
		JPanel centerPanel=new JPanel();
		
		TitledBorder titleBorder = new TitledBorder("Visualizzare l'incasso giornaliero/settimanale/mensile");
		panel.setBorder(titleBorder);
		
		//PANEL RADIO BUTTON
		settimanaleRadioButton=new JRadioButton("Settimanale");
		mensileRadioButton=new JRadioButton("Mensile");
		annualeRadioButton=new JRadioButton("Annuale");
		
		ButtonGroup bg3=new ButtonGroup();
		bg3.add(settimanaleRadioButton);
		bg3.add(mensileRadioButton);
		bg3.add(annualeRadioButton);
		
		panelRadioButton.add(settimanaleRadioButton);
		panelRadioButton.add(mensileRadioButton);
		panelRadioButton.add(annualeRadioButton);
		settimanaleRadioButton.setSelected(true);
		//--------------------
		//PANEL LABEL E FIELD
		JLabel labelParco=new JLabel("ID parco");
		centerPanel.add(labelParco);
		idparco3Field=new JTextField("",4);
		centerPanel.add(idparco3Field);
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String ordine="";
				areaVisualizzazione.setText("");
				if(settimanaleRadioButton.isSelected())ordine="S";
				if(mensileRadioButton.isSelected())ordine="M";
				if(annualeRadioButton.isSelected())ordine="A";
				
				int idParco=Integer.parseInt(idparco3Field.getText());
				
				try {
					if(parcoDAO.isPresente(idParco)==idParco){
					
					try {
						areaVisualizzazione.append("\nIncasso del parco: "+parcoDAO.incasso(Integer.parseInt(idparco3Field.getText()), ordine));
					} catch (NumberFormatException | InstantiationException | IllegalAccessException
							| ClassNotFoundException | SQLException e1) {
						e1.printStackTrace();
					}
																								
															  }
					else {
							idparco3Field.setText("");
							throw new eccezioneChiaveNonValida("Il codice identificativo del parco inserito, non è valido");						
						 }
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e1) {
			
					e1.printStackTrace();
				}
				
			}
		});
		centerPanel.add(button);
		//--------------------
		
		panel.add(panelRadioButton);
		panel.add(centerPanel);
		
		return panel;
	}
	
	
	
	
	//SECONDO PANNELLO---------
	private JTextField data2;
	private JTextField data1;
	//------------------------------
	//TERZO PANNELLO---
	private JTextField nomeAttivitaField;
	private JRadioButton radioButton1;
	private JRadioButton radioButton2;
	//-----------
	///QUINTO PANNELLO-----------
	private JTextField attivitaField;
	private JTextField nomeField;
	private JTextField costoField;
	private JTextField orarioField;
	private JTextField disponibilitaField;
	private JTextField IdParcoField;
	private JTextField CodStrutturaField;
	//---------------------------
	//SESTO PANNELLO----------
	private JTextField p_ivaField;
	private JTextField nomeAgenziaField;
	private JTextField telefonoAgenziaField;
	private JTextField emailAgenziaField;
	private JTextField viaAgenziaField;
	private JTextField cittaAgenziaField;
	private JTextField capAgenziaField;
	
	private JTextField IDagenziaField;
	private JTextField passwordAgenziaField;
	//-------------------------
	//SETTIMO PANNELLO----------
	private JTextField cFClienteField;
	private JTextField CodBigliettoField;
	private JRadioButton radioButtonTipo1;
	private JRadioButton radioButtonTipo2;
	private JTextField iDparco2Field;
	private JTextField promozioneField; 
	//-----------------------
	//OTTAVO PANNELLO-----------
	private JRadioButton settimanaleRadioButton;
	private JRadioButton mensileRadioButton;
	private JRadioButton annualeRadioButton;
	private JTextField idparco3Field;
	//--------------------------
	
	
	private JTextArea areaVisualizzazione; 
	

}
