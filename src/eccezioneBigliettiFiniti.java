import javax.swing.JOptionPane;

/**
 * Questa calsse, estende RuntimeException, e pu� essere lanciata per scrivere un messaggio
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class eccezioneBigliettiFiniti extends RuntimeException {
	
	/**
	 * Stampa il messaggio attraverso una JOptionPane
	 */
	public eccezioneBigliettiFiniti(){
		JOptionPane.showMessageDialog(null, "Biglietti disponibili, terminati. Non � possibile acquistare altri biglietti per il parco selezionato");
	}

}
