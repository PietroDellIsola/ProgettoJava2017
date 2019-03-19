
import java.util.GregorianCalendar;

/**
 * Questa classe rappresenta un oggetto promozione
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class promozione {
	
	/**
	 * Costruttore, crea un oggetto di tipo promozione dati codPromozione, dataI, dataF, nome,
			descrizione, prezzo, idParco
	 * @param codPromozione - una stringa che rappresenta il codice di una promozione
	 * @param dataI - un oggetto GregorianCalendar che rappresenta la data iniziale di una promozione
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data finale di una promozione
	 * @param nome - una stringa che rappresenta il nome di una promozione
	 * @param descrizione - una stringa che rappresenta la descrizione di una promozione
	 * @param prezzo - un float che rappresenta il prezzo di una promozione
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public promozione(String codPromozione, GregorianCalendar dataI, GregorianCalendar dataF, String nome,
			String descrizione, float prezzo, int idParco) {
		
		this.CodPromozione = codPromozione;
		this.dataI = dataI;
		this.dataF = dataF;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
		this.IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro codPromozione di un oggetto promozione 
	 * @return codPromozione - una stringa che rappresenta il codice di una promozione
	 */
	public String getCodPromozione() {
		return CodPromozione;
	}
	
	/**
	 * Modifica il parametro codPromozione di un oggetto promozione 
	 * @param codPromozione - una stringa che rappresenta il codice di una promozione
	 */
	public void setCodPromozione(String codPromozione) {
		CodPromozione = codPromozione;
	}
	
	/**
	 * Restituisce il parametro dataI di un oggetto promozione 
	 * @return dataI - un oggetto GregorianCalendar che rappresenta la data iniziale di una promozione
	 */
	public GregorianCalendar getDataI() {
		return dataI;
	}
	
	/**
	 * Modifica il parametro dataI di un oggetto promozione 
	 * @param dataI -  un oggetto GregorianCalendar che rappresenta la data iniziale di una promozione
	 */
	public void setDataI(GregorianCalendar dataI) {
		this.dataI = dataI;
	}
	
	/**
	 * Restituisce il parametro dataF di un oggetto promozione 
	 * @return dataF -  un oggetto GregorianCalendar che rappresenta la data finale di una promozione
	 */
	public GregorianCalendar getDataF() {
		return dataF;
	}
	
	/**
	 * Modifica il parametro dataF di un oggetto promozione 
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data finale di una promozione
	 */
	public void setDataF(GregorianCalendar dataF) {
		this.dataF = dataF;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto promozione
	 * @return nome - una stringa che rappresenta il nome di una promozione
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto promozione
	 * @param nome - una stringa che rappresenta il nome di una promozione
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro descrizione  di un oggetto promozione
	 * @return descrizione - una stringa che rappresenta la descrizione di una promozione
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Modifica il parametro descrizione  di un oggetto promozione
	 * @param descrizione - una stringa che rappresenta la descrizione di una promozione
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Restituisce il parametro prezzo  di un oggetto promozione
	 * @return prezzo - un float che rappresenta il prezzo di una promozione
	 */
	public float getPrezzo() {
		return prezzo;
	}
	
	/**
	 * Modifica il parametro prezzo  di un oggetto promozione
	 * @param prezzo - un float che rappresenta il prezzo di una promozione
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * Restituisce  il parametro IdParco  di un oggetto promozione
	 * @return IdParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco  di un oggetto promozione
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "promozione [CodPromozione=" + CodPromozione + ", dataI=" + (dataI.get(GregorianCalendar.YEAR)+"/"+dataI.get(GregorianCalendar.MONTH)+"/"+dataI.get(GregorianCalendar.DAY_OF_MONTH)) 
				+ ", dataF=" + (dataF.get(GregorianCalendar.YEAR)+"/"+dataF.get(GregorianCalendar.MONTH)+"/"+dataF.get(GregorianCalendar.DAY_OF_MONTH)) + ", nome=" + nome
				+ ", descrizione=" + descrizione + ", prezzo=" + prezzo + ", IdParco=" + IdParco + "]";
	}

	private String CodPromozione;
	private GregorianCalendar dataI;
	private GregorianCalendar dataF;
	private String nome;
	private String descrizione;
	private float prezzo;
	private int IdParco;
}
