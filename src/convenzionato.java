
/**
 * Questa classe rappresenta un oggetto convenzionato
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class convenzionato {
	
	/**
	 * Costruttore, crea un oggetto di tipo convenzionato
	 * @param idParco - un intero che rappresenta il codice identificativo del parco
	 * @param p_IVA - una stringa che rappresenta la partita iva di un parco
	 */
	public convenzionato(int idParco, String p_IVA) {
		this.IdParco = idParco;
		this.P_IVA = p_IVA;
	}
	
	/**
	 * Ritorna il parametro IdParco di un oggetto convenzionato
	 * @return IdParco - un intero che rappresenta il codice identificativo del parco
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco di un oggetto convenzionato
	 * @param idParco - un intero che rappresenta il codice identificativo del parco
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Ritorna il parametro P_IVA di un oggetto convenzionato
	 * @return P_IVA - una stringa che rappresenta la partita iva di un parco
	 */
	public String getP_IVA() {
		return P_IVA;
	}
	
	/**
	 * Modifica il parametro P_IVA di un oggetto convenzionato
	 * @param p_IVA - una stringa che rappresenta la partita iva di un parco
	 */
	public void setP_IVA(String p_IVA) {
		P_IVA = p_IVA;
	}
	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "convenzionato [IdParco=" + IdParco + ", P_IVA=" + P_IVA + "]";
	}

	private int IdParco;
	private String P_IVA;
}
