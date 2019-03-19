import javax.swing.JOptionPane;

/**
 * Questa calsse, estende RuntimeException, e può essere lanciata per scrivere un messaggio
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class eccezioneChiaveNonValida extends RuntimeException
{
	
	/**
	 * Stampa un messaggio attraverso una JOptionPane
	 */
	public eccezioneChiaveNonValida(){
		JOptionPane.showMessageDialog(null, "Chiave inserita, non valida");
	}
	
	/**
	 * Stampa il messaggio passato come parametro esplicito attraverso una JOptionPane
	 */
	public eccezioneChiaveNonValida(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
}
