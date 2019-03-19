
/**
 * Questa classe rappresenta un oggetto attivita
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class attivita {

	/**
	 * Costruttore, crea un oggetto attivita dato un codAttivita, nome, costo, orario, disponibilita, idParco, codStruttura
	 * @param codAttivita - una stringa che rappresenta il codice di un attività
	 * @param nome - una stringa che rappresenta il nome di un'attività
	 * @param costo - un float che rappresenta il costo di un attività
	 * @param orario - una stringa che rappresenta l'orario di svolgimento dell'attività
	 * @param disponibilita - un boolean che indica la disponibilità(true) o meno(flase) di un attività
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 * @param codStruttura - una stringa che rappresenta il codice di una struttura
	 */
	public attivita(String codAttivita, String nome, float costo, String orario, boolean disponibilita, int idParco,
			String codStruttura) {
		this.CodAttivita = codAttivita;
		this.nome = nome;
		this.costo = costo;
		this.orario = orario;
		this.disponibilita = disponibilita;
		this.IdParco = idParco;
		this.CodStruttura = codStruttura;
	}
	
	/**
	 * Restituisce il parametro CodAttivita di un oggetto attività	
	 * @return CodAttivita - una stringa che rappresenta il codice di un attività
	 */
	public String getCodAttivita() {
		return CodAttivita;
	}
	
	/**
	 * Modifica il parametro CodAttivita di un oggetto attività	
	 * @param codAttivita - una stringa che rappresenta il codice di un attività
	 */
	public void setCodAttivita(String codAttivita) {
		CodAttivita = codAttivita;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto attività	
	 * @return nome - una stringa che rappresenta il nome di un attività
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto attività	
	 * @param nome - una stringa che rappresenta il nome di un attività
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro costo di un oggetto attività	
	 * @return costo - un float che rappresenta il costo di un attività
	 */
	public float getCosto() {
		return costo;
	}
	
	/**
	 *  Modifica il parametro costo di un oggetto attività	
	 * @param costo - un float che rappresenta il costo di un attività
	 */
	public void setCosto(float costo) {
		this.costo = costo;
	}
	
	/**
	 * Restituisce il parametro orario di un oggetto attività	
	 * @return orario - una stringa che rappresenta l'orario di svolgimento dell'attività
	 */
	public String getOrario() {
		return orario;
	}
	
	/**
	 * Modifica il parametro orario di un oggetto attività	
	 * @param orario - una stringa che rappresenta l'orario di svolgimento dell'attività
	 */
	public void setOrario(String orario) {
		this.orario = orario;
	}
	
	/**
	 * Restituisce il parametro disponibilita di un oggetto attività	
	 * @return disponibilita - un boolean che indica la disponibilità(true) o meno(flase) di un attività
	 */
	public boolean isDisponibilita() {
		return disponibilita;
	}
	
	/**
	 * Modifica il parametro disponibilita di un oggetto attività	
	 * @param disponibilita - un boolean che indica la disponibilità(true) o meno(flase) di un attività
	 */
	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}
	
	/**
	 * Restituisce il parametro IdParco di un oggetto attività	
	 * @return IdParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco di un oggetto attività	
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro CodStruttura di un oggetto attività	
	 * @return CodStruttura - una stringa che rappresenta il codice di una struttura
	 */
	public String getCodStruttura() {
		return CodStruttura;
	}
	
	/**
	 * Modifica il parametro CodStruttura di un oggetto attività	
	 * @param codStruttura - una stringa che rappresenta il codice di una struttura
	 */
	public void setCodStruttura(String codStruttura) {
		CodStruttura = codStruttura;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "attivita [CodAttivita=" + CodAttivita + ", nome=" + nome + ", costo=" + costo + ", orario=" + orario
				+ ", disponibilita=" + disponibilita + ", IdParco=" + IdParco + ", CodStruttura=" + CodStruttura + "]";
	}

	private String CodAttivita;
	private String nome;
	private float costo;
	private String orario;
	private boolean disponibilita;
	private int IdParco;
	private String CodStruttura;
}
