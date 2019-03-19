
import java.util.GregorianCalendar;

/**
 * Questa classe rappresenta un oggetto dipendenti
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class dipendenti {

	/**
	 * Costruttore, crea un oggetto dipendente dati cF, nome, cognome, eta, idParco, tipoContratto, dataI, dataF
	 * @param cF - una stringa che rappresenta il codice fiscale di un dipendente
	 * @param nome - una stringa che rappresenta il nome di un dipendente
	 * @param cognome - una stringa che rappresenta il cognome di un dipendente
	 * @param eta - un intero che rappresenta l'età di un dipendente
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 * @param tipoContratto - una stringa che rappresenta la tipologia del contratto del dipendente
	 * @param dataI - un oggetto GregorianCalendar che rappresenta la data iniziale del contratto
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data finale del contratto
	 */
	public dipendenti(String cF, String nome, String cognome, int eta, int idParco, String tipoContratto,
			GregorianCalendar dataI, GregorianCalendar dataF) {
		this.CF = cF;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.IdParco = idParco;
		this.tipoContratto = tipoContratto;
		this.dataI = dataI;
		this.dataF = dataF;
	}
	
	/**
	 * Restituisce il parametro CF di un oggetto dipendente
	 * @return CF - una stringa che rappresenta il codice fiscale di un dipendente
	 */
	public String getCF() {
		return CF;
	}
	
	/**
	 * Modifica il parametro CF di un oggetto dipendente
	 * @param cF - una stringa che rappresenta il codice fiscale di un dipendente
	 */
	public void setCF(String cF) {
		CF = cF;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto dipendente
	 * @return nome - una stringa che rappresenta il nome di un dipendente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto dipendente
	 * @param nome - una stringa che rappresenta il nome di un dipendente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro cognome di un oggetto dipendente
	 * @return cognome - una stringa che rappresenta il cognome di un dipendente
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Modifica il parametro cognome di un oggetto dipendente
	 * @param cognome - una stringa che rappresenta il cognome di un dipendente
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 *  Restituisce il parametro eta di un oggetto dipendente
	 * @return eta - un intero che rappresenta l'età di un dipendente
	 */
	public int getEta() {
		return eta;
	}
	
	/**
	 * Modifica il parametro eta di un oggetto dipendente
	 * @param eta - un intero che rappresenta l'età di un dipendente
	 */
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	/**
	 * Restituisce il parametro IdParco di un oggetto dipendente
	 * @return IdParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco di un oggetto dipendente
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro tipoContratto di un oggetto dipendente
	 * @return tipoContratto - una stringa che rappresenta la tipologia del contratto del dipendente
	 */
	public String getTipoContratto() {
		return tipoContratto;
	}
	
	/**
	 * Modifica il parametro tipoContratto di un oggetto dipendente
	 * @param tipoContratto - una stringa che rappresenta la tipologia del contratto del dipendente
	 */
	public void setTipoContratto(String tipoContratto) {
		this.tipoContratto = tipoContratto;
	}
	
	/**
	 * Restituisce il parametro dataI di un oggetto dipendente
	 * @return dataI - un oggetto GregorianCalendar che rappresenta la data iniziale del contratto
	 */
	public GregorianCalendar getDataI() {
		return dataI;
	}
	
	/**
	 * Modifica il parametro dataI di un oggetto dipendente
	 * @param dataI - un oggetto GregorianCalendar che rappresenta la data iniziale del contratto
	 */
	public void setDataI(GregorianCalendar dataI) {
		this.dataI = dataI;
	}
	
	/**
	 * Ritorna il parametro dataI di un oggetto dipendente
	 * @return dataF - un oggetto GregorianCalendar che rappresenta la data finale del contratto
	 */
	public GregorianCalendar getDataF() {
		return dataF;
	}
	
	/**
	 *Modifica il parametro dataI di un oggetto dipendente 
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data finale del contratto
	 */
	public void setDataF(GregorianCalendar dataF) {
		this.dataF = dataF;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "dipendenti [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", IdParco="
				+ IdParco + ", tipoContratto=" + tipoContratto + ", dataI=" + dataI + ", dataF=" + dataF + "]";
	}

	private String CF;
	private String nome;
	private String cognome;
	private int eta;
	private int IdParco;
	private String tipoContratto;
	private GregorianCalendar dataI;
	private GregorianCalendar dataF;
}
