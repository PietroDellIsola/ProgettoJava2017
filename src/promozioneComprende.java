
/**
 * Questa classe rappresenta un oggetto promozioneComprende
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class promozioneComprende {
	
	/**
	 * Costruttore, crea un oggetto promozioneComprende dati codPromozione e codAttivita
	 * @param codPromozione - una stringa che rappresenta un codice di una promozione
	 * @param codAttivita - una stringa che rappresenta il codice di un attività
	 */
	public promozioneComprende(String codPromozione, String codAttivita) {
		this.CodPromozione = codPromozione;
		this.CodAttivita = codAttivita;
	}
	
	/**
	 * Restituisce il parametro CodPromozione di un oggetto di tipo promozioneComprende
	 * @return CodPromozione - una stringa che rappresenta un codice di una promozione
	 */
	public String getCodPromozione() {
		return CodPromozione;
	}
	
	/**
	 * Modifica il parametro CodPromozione di un oggetto di tipo promozioneComprende
	 * @param codPromozione - una stringa che rappresenta un codice di una promozione
	 */
	public void setCodPromozione(String codPromozione) {
		CodPromozione = codPromozione;
	}
	
	/**
	 * Restituisce il parametro CodAttivita di un oggetto di tipo promozioneComprende
	 * @return CodAttivita - una stringa che rappresenta il codice di un attività
	 */
	public String getCodAttivita() {
		return CodAttivita;
	}
	
	/**
	 * Modifica il parametro CodAttivita di un oggetto di tipo promozioneComprende
	 * @param codAttivita - una stringa che rappresenta il codice di un attività
	 */
	public void setCodAttivita(String codAttivita) {
		CodAttivita = codAttivita;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "promozioneComprende [CodPromozione=" + CodPromozione + ", CodAttivita=" + CodAttivita + "]";
	}

	private String CodPromozione;
	private String CodAttivita;
	
}
