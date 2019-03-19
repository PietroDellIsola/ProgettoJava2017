import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

/**
 * Questa classe rappresenta il frame relativo all'aggiunta di una convenzione tra un parco ed un agenzia
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class frameConvenzionato extends JFrame
{
	public frameConvenzionato(String p_IVA){
		setSize(1000,300);
		setTitle("Aggiungi le convenzioni tra i parchi e l'agenzia");
		setLayout(new BorderLayout());
		
		add(frameConvenzionato2(p_IVA),BorderLayout.NORTH);
		
		JTextArea areaVisualizzazione=new JTextArea(10,20);
		JScrollPane scrollPane = new JScrollPane(areaVisualizzazione,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(scrollPane,BorderLayout.SOUTH);//AREA DI STAMPA
		//STAMPO TUTTI I PARCHI
		ArrayList<parco>parchi=new ArrayList<>();
		try {
			parchi=parcoDAO.stampaParchi();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e2) {
				e2.printStackTrace();
		}
		
		areaVisualizzazione.setText("\nParchi:\n");
		for(parco p:parchi){
			areaVisualizzazione.append("\n"+p.toString()+"\n");
		}
		//--------------------
		
	}
	
	
	public JPanel frameConvenzionato2(String p_IVA){
		JPanel panel=new JPanel();
		JLabel labelIdParco=new JLabel("IdParco");
		panel.add(labelIdParco);
		idParcoField=new JTextField("",10);
		panel.add(idParcoField);
		JButton button=new JButton("PROCEDI");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
								
				try {
					convenzionatoDAO.inserisciConvenzione(new convenzionato(Integer.parseInt(idParcoField.getText()), p_IVA));
					idParcoField.setText("");
				} catch (NumberFormatException | InstantiationException | IllegalAccessException
						| ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		panel.add(button);
		
		return panel;
	}
	
	private JTextField idParcoField;
}
