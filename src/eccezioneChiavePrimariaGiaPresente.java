import javax.swing.JOptionPane;


/**
 * Questa calsse, estende RuntimeException, e pu� essere lanciata per scrivere un messaggio
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class eccezioneChiavePrimariaGiaPresente extends RuntimeException {
	//ECCEZIONE GENERICA LANCIATA QUANDO UNA CHIAVE PRIMARIA � GIA' PRESENTE NEL DATABASE
	
	/**
	 * Stampa il messaggio attraverso una JOptionPane
	 */
	public eccezioneChiavePrimariaGiaPresente(){
		JOptionPane.showMessageDialog(null, "Attenzione, la chiave primaria inserita � gi� presente nel database");
	}
	
	/**
	 * Stampa il messaggio attraverso una JOptionPane
	 */
	public eccezioneChiavePrimariaGiaPresente(String msg){
		JOptionPane.showMessageDialog(null, msg);
	}
}
