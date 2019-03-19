
/**
 * Questa classe rappresenta un oggetto agenzia
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class agenzia {
	
	/**
	 * Costruttore, crea un oggetto agenzia dati p_IVA, nome, telefono, email, via, citta, cAP 
	 * @param P_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 * @param nome - una stringa che rappresenta il nome dell'agenzia
	 * @param telefono - una stringa che rappresenta il telefono dell'agenzia
	 * @param email - una stringa che rappresenta l'email dell'agenzia
	 * @param via - una stringa che rappresenta la via dell'agenzia
	 * @param citta - una stringa che rappresenta la città dell'agenzia
	 * @param cAP - una stringa che rappresenta il CAP dell'agenzia
	 */
	public agenzia(String p_IVA, String nome, String telefono, String email, String via, String citta, String cAP) {
		this.P_IVA = p_IVA;
		this.nome = nome;
		this.telefono = telefono;
		this.email = email;
		this.via = via;
		this.citta = citta;
		this.CAP = cAP;
	}
	
	/**
	 * Ritorna il parametro P_IVA di un oggetto agenzia
	 * @return P_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 */
	public String getP_IVA() {
		return P_IVA;
	}
	
	/**
	 * Modifica il parametro P_IVA di un oggetto agenzia
	 * @param P_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 */
	public void setP_IVA(String p_IVA) {
		P_IVA = p_IVA;
	}
	
	/**
	 * Ritorna il parametro nome di un oggetto agenzia
	 * @return nome - una stringa che rappresenta il nome dell'agenzia
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto agenzia
	 * @param nome - una stringa che rappresenta il nome dell'agenzia
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro telefono di un oggetto agenzia
	 * @return telefono - una stringa che rappresenta il telefono dell'agenzia
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Modifica il parametro telefono di un oggetto agenzia
	 * @param telefono - una stringa che rappresenta il telefono dell'agenzia
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Restituisce il parametro email di un oggetto agenzia
	 * @return email - una stringa che rappresenta l'email dell'agenzia
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Modifica il parametro email di un oggetto agenzia
	 * @param email - una stringa che rappresenta l'email dell'agenzia
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Restituisce il parametro via di un oggetto agenzia
	 * @return via - una stringa che rappresenta la via dell'agenzia
	 */
	public String getVia() {
		return via;
	}
	
	/**
	 * Modifica il parametro via di un oggetto agenzia
	 * @param via - una stringa che rappresenta la via dell'agenzia
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Restituisce il parametro citta di un oggetto agenzia 
	 * @return citta - una stringa che rappresenta la città dell'agenzia
	 */
	public String getCitta() {
		return citta;
	}
	
	/**
	 * Modifica il parametro citta di un oggetto agenzia 
	 * @param citta - stringa che rappresenta la città dell'agenzia
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	/**
	 * Restituisce il parametro CAP di un oggetto agenzia 
	 * @return CAP - una stringa che rappresenta il CAP dell'agenzia
	 */
	public String getCAP() {
		return CAP;
	}
	
	/**
	 * Modifica il parametro citta di un oggetto agenzia 
	 * @param cAP - una stringa che rappresenta il CAP dell'agenzia
	 */
	public void setCAP(String cAP) {
		CAP = cAP;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "agenzia [P_IVA=" + P_IVA + ", nome=" + nome + ", telefono=" + telefono + 
				", email=" + email + ", via="+ via + ", citta=" + citta + ", CAP=" + CAP + "]";
	}

	private String P_IVA;
	private String nome;
	private String telefono;
	private String email;
	private String via;
	private String citta;
	private String CAP;

}
