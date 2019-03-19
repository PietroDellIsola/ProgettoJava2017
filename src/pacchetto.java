
import java.util.GregorianCalendar;


/**
 * Questa classe rappresenta un oggetto pacchetto
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class pacchetto {
	
	/**
	 * Costruttore, crea un oggetto pacchetto
	 * @param codPacchetto - una stringa che rappresenta il codice di un pacchetto
	 * @param nome - una stringa che rappresenta il nome di un pacchetto
	 * @param descrizione - una stringa che rappresenta la descrizione di un pacchetto
	 * @param dataI - un oggetto GregorianCalendar che rappresenta la data di inizio di un pacchetto
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data di fine di un pacchetto
	 * @param prezzo - un float che rappresenta il prezzo del pacchetto
	 * @param idRA - un intero che rappresenta il codice identificativo del ritorante o hotel, afferente al pacchetto
	 * @param p_IVA - una stringa che rappresenta la partita iva di un agenzia
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente che l'ha acquistato  
	 * @param dataPrenotazione - un oggetto GregorianCalendar che rappresenta la data di prenotazione di un pacchetto
	 */
	public pacchetto(String codPacchetto, String nome, String descrizione, GregorianCalendar dataI,
			GregorianCalendar dataF, float prezzo, int idRA, String p_IVA, String cF,
			GregorianCalendar dataPrenotazione) {
		
		this.CodPAcchetto = codPacchetto;
		this.nome = nome;
		this.descrizione = descrizione;
		this.dataI = dataI;
		this.dataF = dataF;
		this.prezzo = prezzo;
		this.IdRA = idRA;
		this.P_IVA = p_IVA;
		this.CF = cF;
		this.dataPrenotazione = dataPrenotazione;
	}
		
	/**
	 * Restituisce il parametro CodPAcchetto di un oggetto pacchetto
	 * @return CodPAcchetto - una stringa che rappresenta il codice di un pacchetto
	 */
	public String getCodPAcchetto() {
		return CodPAcchetto;
	}
	
	/**
	 * Modifica il parametro CodPAcchetto di un oggetto pacchetto
	 * @param codPAcchetto - una stringa che rappresenta il codice di un pacchetto
	 */
	public void setCodPAcchetto(String codPAcchetto) {
		CodPAcchetto = codPAcchetto;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto pacchetto
	 * @return nome - una stringa che rappresenta il nome di un pacchetto
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica  il parametro nome di un oggetto pacchetto
	 * @param nome - una stringa che rappresenta il nome di un pacchetto
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro descrizione di un oggetto pacchetto
	 * @return descrizione - una stringa che rappresenta la descrizione di un pacchetto
	 */
	public String getDescrizione() {
		return descrizione;
	}
	
	/**
	 * Modifica il parametro descrizione di un oggetto pacchetto
	 * @param descrizione - una stringa che rappresenta la descrizione di un pacchetto
	 */
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Restituisce il parametro dataI di un oggetto pacchetto
	 * @return dataI - un oggetto GregorianCalendar che rappresenta la data di inizio di un pacchetto
	 */
	public GregorianCalendar getDataI() {
		return dataI;
	}
	
	/**
	 * Modifica il parametro dataI di un oggetto pacchetto
	 * @param dataI - un oggetto GregorianCalendar che rappresenta la data di inizio di un pacchetto
	 */
	public void setDataI(GregorianCalendar dataI) {
		this.dataI = dataI;
	}
	
	/**
	 * Restituisce il parametro dataF di un oggetto pacchetto
	 * @return dataF - un oggetto GregorianCalendar che rappresenta la data di fine di un pacchetto
	 */
	public GregorianCalendar getDataF() {
		return dataF;
	}
	
	/**
	 * Modifica il parametro dataF di un oggetto pacchetto
	 * @param dataF - un oggetto GregorianCalendar che rappresenta la data di fine di un pacchetto
	 */
	public void setDataF(GregorianCalendar dataF) {
		this.dataF = dataF;
	}
	
	/**
	 * Restituisce il parametro prezzo di un oggetto pacchetto
	 * @return prezzo - un float che rappresenta il prezzo del pacchetto
	 */
	public float getPrezzo() {
		return prezzo;
	}
	
	/**
	 * Modifica  il parametro prezzo di un oggetto pacchetto
	 * @param prezzo - un float che rappresenta il prezzo del pacchetto
	 */
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	/**
	 * Restituisce il parametro IdRA di un oggetto pacchetto
	 * @return IdRA - un intero che rappresenta il codice identificativo del ritorante o hotel, afferente al pacchetto
	 */
	public int getIdRA() {
		return IdRA;
	}
	
	/**
	 * Modifica il parametro IdRA di un oggetto pacchetto
	 * @param idRA - un intero che rappresenta il codice identificativo del ritorante o hotel, afferente al pacchetto
	 */
	public void setIdRA(int idRA) {
		IdRA = idRA;
	}
	
	/**
	 * Restituisce il parametro P_IVA di un oggetto pacchetto
	 * @return P_IVA - una stringa che rappresenta la partita iva di un agenzia
	 */
	public String getP_IVA() {
		return P_IVA;
	}
	
	/**
	 * Modifica il parametro P_IVA di un oggetto pacchetto
	 * @param p_IVA - una stringa che rappresenta la partita iva di un agenzia
	 */
	public void setP_IVA(String p_IVA) {
		P_IVA = p_IVA;
	}
	
	/**
	 * Restituisce il parametro CF di un oggetto pacchetto
	 * @return CF - una stringa che rappresenta il codice fiscale del cliente che l'ha acquistato 
	 */
	public String getCF() {
		return CF;
	}
	
	/**
	 * Modifica  il parametro CF di un oggetto pacchetto
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente che l'ha acquistato 
	 */
	public void setCF(String cF) {
		CF = cF;
	}
	
	/**
	 * Restituisce il parametro dataPrenotazione di un oggetto pacchetto
	 * @return dataPrenotazione  - un oggetto GregorianCalendar che rappresenta la data di prenotazione di un pacchetto
	 */
	public GregorianCalendar getDataPrenotazione() {
		return dataPrenotazione;
	}
	
	/**
	 * Modifica il parametro dataPrenotazione di un oggetto pacchetto
	 * @param dataPrenotazione - un oggetto GregorianCalendar che rappresenta la data di prenotazione di un pacchetto
	 */
	public void setDataPrenotazione(GregorianCalendar dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		if((CF==null)&&(dataPrenotazione==null)){
			return"pacchetto [CodPAcchetto=" + CodPAcchetto + ", nome=" + nome + ", descrizione=" + descrizione
					+ ", dataI=" +(dataI.get(GregorianCalendar.YEAR)+"/"+dataI.get(GregorianCalendar.MONTH)+"/"+dataI.get(GregorianCalendar.DAY_OF_MONTH))
					+ ", dataF=" + (dataF.get(GregorianCalendar.YEAR)+"/"+dataF.get(GregorianCalendar.MONTH)+"/"+dataF.get(GregorianCalendar.DAY_OF_MONTH)) 
					+ ", prezzo=" + prezzo + ", IdRA=" + IdRA + ", P_IVA=" + P_IVA+"]";
												}
		else{			
			return "pacchetto [CodPAcchetto=" + CodPAcchetto + ", nome=" + nome + ", descrizione=" + descrizione
				+ ", dataI=" +(dataI.get(GregorianCalendar.YEAR)+"/"+dataI.get(GregorianCalendar.MONTH)+"/"+dataI.get(GregorianCalendar.DAY_OF_MONTH))
				+ ", dataF=" + (dataF.get(GregorianCalendar.YEAR)+"/"+dataF.get(GregorianCalendar.MONTH)+"/"+dataF.get(GregorianCalendar.DAY_OF_MONTH)) 
				+ ", prezzo=" + prezzo + ", IdRA=" + IdRA + ", P_IVA=" + P_IVA
				+ ", CF=" + CF + ", dataPrenotazione=" + (dataPrenotazione.get(GregorianCalendar.YEAR)+"/"+dataPrenotazione.get(GregorianCalendar.MONTH)
				+"/"+dataPrenotazione.get(GregorianCalendar.DAY_OF_MONTH)) + "]";
			}
	}

	private String CodPAcchetto;
	private String nome;
	private String descrizione;
	private GregorianCalendar dataI;
	private GregorianCalendar dataF;
	private float prezzo;
	private int IdRA;
	private String P_IVA;
	private String CF;
	private GregorianCalendar dataPrenotazione;

}
