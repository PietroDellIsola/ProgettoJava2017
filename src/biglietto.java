
import java.util.GregorianCalendar;


/**
 * Questa classe rappresenta un oggetto biglietto
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class biglietto {

	/**
	 * Costruttore, crea un oggetto di tipo biglietto, dati codBiglietto, tipo, cF, codPromozione, idParco, dataAcquisto,
	 * prezzoTotale, CodPacchetto
	 * @param codBiglietto - una stringa che rappresenta il codice di un biglietto
	 * @param tipo - una stringa che rappresenta il tipo di un biglietto
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente che ha acquistato il biglietto
	 * @param codPromozione - una stringa che rappresenta il codPromozione del biglietto
	 * @param idParco - un intero che rappresenta il codice identificativo del parco che ha rilasciato il biglietto
	 * @param dataAcquisto - un oggetto GregorianCalendar che rappresenta la data d'acquisto del biglietto
	 * @param prezzoTotale - un float che rappresenta il prezzo totale del biglietto
	 * @param CodPacchetto - una stringa che rappresenta il codice di un pacchetto che fa riferimento al biglietto
	 */
	public biglietto(String codBiglietto, String tipo, String cF, String codPromozione, int idParco,
			GregorianCalendar dataAcquisto,float prezzoTotale,String CodPacchetto) {
		this.CodBiglietto = codBiglietto;
		this.tipo = tipo;
		this.CF = cF;
		this.CodPromozione = codPromozione;
		this.IdParco = idParco;
		this.dataAcquisto = dataAcquisto;
		this.prezzoTotale = prezzoTotale; 	//BISOGNA CALCOLARLO UNA VOLTA INSERITE LE ATTIVITA
										//OPPURE ASSEGNARE IL PREZZO DELLA PROMOZIONE SCELTA
		this.CodPacchetto = CodPacchetto;	//BISOGNA ASSEGNARE UN VALORE, SOLTANTO SE IL CLIENTE 
										//SCEGLIE IL PACCHETTO DA UN AGENZIA
	}
	
	/**
	 * Restituisce il parametro CodBiglietto di un oggetto biglietto
	 * @return CodBiglietto - una stringa che rappresenta il codice di un biglietto
	 */
	public String getCodBiglietto() {
		return CodBiglietto;
	}
	
	/**
	 * Modifica il parametro CodBiglietto di un oggetto biglietto
	 * @param codBiglietto - una stringa che rappresenta il codice di un biglietto
	 */
	public void setCodBiglietto(String codBiglietto) {
		CodBiglietto = codBiglietto;
	}
	
	/**
	 * Restituisce il parametro tipo di un oggetto biglietto
	 * @return tipo - una stringa che rappresenta il tipo di un biglietto
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Modifica il parametro tipo di un oggetto biglietto
	 * @param tipo - una stringa che rappresenta il tipo di un biglietto
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Restituisce il parametro CF di un oggetto biglietto
	 * @return CF - una stringa che rappresenta il codice fiscale del cliente che ha acquistato il biglietto
	 */
	public String getCF() {
		return CF;
	}
	
	/**
	 * Modifica il parametro CF di un oggetto biglietto
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente che ha acquistato il biglietto
	 */
	public void setCF(String cF) {
		CF = cF;
	}
	
	/**
	 * Restituisce il parametro CodPromozione di un oggetto biglietto
	 * @return CodPromozione - una stringa che rappresenta il codPromozione del biglietto
	 */
	public String getCodPromozione() {
		return CodPromozione;
	}
	
	/**
	 * Modifica il parametro CodPromozione di un oggetto biglietto
	 * @param codPromozione - una stringa che rappresenta il codPromozione del biglietto
	 */
	public void setCodPromozione(String codPromozione) {
		CodPromozione = codPromozione;
	}
	
	/**
	 * Restituisce il parametro IdParco di un oggetto biglietto
	 * @return IdParco - un intero che rappresenta il codice identificativo del parco che ha rilasciato il biglietto
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco di un oggetto biglietto
	 * @param idParco - un intero che rappresenta il codice identificativo del parco che ha rilasciato il biglietto
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro dataAcquisto di un oggetto biglietto
	 * @return dataAcquisto - un oggetto GregorianCalendar che rappresenta la data d'acquisto del biglietto
	 */
	public GregorianCalendar getDataAcquisto() {
		return dataAcquisto;
	}
	
	/**
	 * Modifica il parametro dataAcquisto di un oggetto biglietto
	 * @param dataAcquisto - un oggetto GregorianCalendar che rappresenta la data d'acquisto del biglietto
	 */
	public void setDataAcquisto(GregorianCalendar dataAcquisto) {
		this.dataAcquisto = dataAcquisto;
	}
	
	/**
	 * Restituisce il parametro prezzoTotale di un oggetto biglietto
	 * @return prezzoTotale - un float che rappresenta il prezzo totale del biglietto
	 */
	public float getPrezzoTotale() {
		return prezzoTotale;
	}
	
	/**
	 * Modifica il parametro prezzoTotale di un oggetto biglietto
	 * @param prezzoTotale - un float che rappresenta il prezzo totale del biglietto
	 */
	public void setPrezzoTotale(float prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}
	
	/**
	 * Restituisce il parametro CodPacchetto di un oggetto biglietto
	 * @return CodPacchetto - una stringa che rappresenta il codice di un pacchetto che fa riferimento al biglietto
	 */
	public String getCodPacchetto() {
		return CodPacchetto;
	}
	
	/**
	 * Modifica il parametro CodPacchetto di un oggetto biglietto
	 * @param codPacchetto - una stringa che rappresenta il codice di un pacchetto che fa riferimento al biglietto
	 */
	public void setCodPacchetto(String codPacchetto) {
		CodPacchetto = codPacchetto;
	}

	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "biglietto [CodBiglietto=" + CodBiglietto + ", tipo=" + tipo + ", CF=" + CF + ", CodPromozione="
				+ CodPromozione + ", IdParco=" + IdParco + ", dataAcquisto=" + (dataAcquisto.get(GregorianCalendar.YEAR)+"/"+dataAcquisto.get(GregorianCalendar.MONTH)+"/"+dataAcquisto.get(GregorianCalendar.DAY_OF_MONTH)) + ", prezzoTotale="
				+ prezzoTotale + ", CodPacchetto=" + CodPacchetto + "]";
	}

	private String CodBiglietto;
	private String tipo;
	private String CF;
	private String CodPromozione;
	private int IdParco;
	private GregorianCalendar dataAcquisto;
	private float prezzoTotale; //BISOGNA CALCOLARLO UNA VOLTA INSERITE LE ATTIVITA
								//OPPURE ASSEGNARE IL PREZZO DELLA PROMOZIONE SCELTA
	private String CodPacchetto; //BISOGNA ASSEGNARE UN VALORE, SOLTANTO SE IL CLIENTE 
								  //SCEGLIE IL PACCHETTO DA UN AGENZIA
	
}
