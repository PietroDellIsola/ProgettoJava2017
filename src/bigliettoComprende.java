
/**
 * Questa classe rappresenta un oggetto bigliettoComprende
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class bigliettoComprende {

	/**
	 * Costruttore, crea un oggetto bigliettoComprende dati codBiglietto, codAttivita
	 * @param codBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @param codAttivita - una stringa che rappresenta il codice di un attività
	 */
	public bigliettoComprende(String codBiglietto, String codAttivita) {
		this.CodBiglietto = codBiglietto;
		this.CodAttivita = codAttivita;
	}
	
	/**
	 * Restituisce il parametro CodBiglietto di un oggetto bigliettoComprende
	 * @return CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 */
	public String getCodBiglietto() {
		return CodBiglietto;
	}
	
	/**
	 * Modifica il parametro CodBiglietto di un oggetto bigliettoComprende
	 * @param codBiglietto - una stringa che rappresenta il codice di un biglietto
	 */
	public void setCodBiglietto(String codBiglietto) {
		CodBiglietto = codBiglietto;
	}
	
	/**
	 *  Restituisce il parametro CodAttivita di un oggetto bigliettoComprende
	 * @return CodAttivita - una stringa che rappresenta il codice di un attività
	 */
	public String getCodAttivita() {
		return CodAttivita;
	}
	
	/**
	 * Modifica il parametro CodAttivita di un oggetto bigliettoComprende
	 * @param codAttivita -  una stringa che rappresenta il codice di un attività
	 */
	public void setCodAttivita(String codAttivita) {
		CodAttivita = codAttivita;
	}


	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "bigliettoComprende [CodBiglietto=" + CodBiglietto + ", CodAttivita=" + CodAttivita + "]";
	}

	private String CodBiglietto;
	private String CodAttivita;
	
}


