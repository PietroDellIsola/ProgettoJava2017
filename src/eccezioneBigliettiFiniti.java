import javax.swing.JOptionPane;

/**
 * Questa calsse, estende RuntimeException, e può essere lanciata per scrivere un messaggio
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class eccezioneBigliettiFiniti extends RuntimeException {
	
	/**
	 * Stampa il messaggio attraverso una JOptionPane
	 */
	public eccezioneBigliettiFiniti(){
		JOptionPane.showMessageDialog(null, "Biglietti disponibili, terminati. Non è possibile acquistare altri biglietti per il parco selezionato");
	}

}
