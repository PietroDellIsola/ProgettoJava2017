
/**
 * Questa classe rappresenta un oggetto cliente
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class cliente {
	
	/**
	 * Costruttore, crea un oggetto cliente dati cF, nome, cognome, eta, telefono, email
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente
	 * @param nome - una stringa che rappresenta il nome del cliente
	 * @param cognome - una stringa che rappresenta il cognome del cliente
	 * @param eta - una intero che rappresenta l'età del cliente
	 * @param telefono - una stringa che rappresenta il telefono del cliente
	 * @param email - una stringa che rappresental'email del cliente
	 */
	public cliente(String cF, String nome, String cognome, int eta, String telefono, String email) {
		this.CF = cF;
		this.nome = nome;
		this.cognome = cognome;
		this.eta = eta;
		this.telefono = telefono;
		this.email = email;
	}
	
	/**
	 * Restituisce il parametro CF di un oggetto cliente
	 * @return CF - una stringa che rappresenta il codice fiscale del cliente
	 */
	public String getCF() {
		return CF;
	}
	
	/**
	 * Modifica il parametro CF di un oggetto cliente
	 * @param cF - una stringa che rappresenta il codice fiscale del cliente
	 */
	public void setCF(String cF) {
		CF = cF;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto cliente
	 * @return nome - una stringa che rappresenta il nome del cliente
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto cliente
	 * @param nome - una stringa che rappresenta il nome del cliente
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro cognome di un oggetto cliente
	 * @return cognome - una stringa che rappresenta il cognome del cliente
	 */
	public String getCognome() {
		return cognome;
	}
	
	/**
	 * Modifica il parametro cognome di un oggetto cliente
	 * @param cognome - una stringa che rappresenta il cognome del cliente
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	/**
	 * Restituisce il parametro eta di un oggetto cliente
	 * @return eta - un intero che rappresenta l'età del cliente
	 */
	public int getEta() {
		return eta;
	}
	
	/**
	 * Modifica il parametro eta di un oggetto cliente
	 * @param eta - un intero che rappresenta l'età del cliente
	 */
	public void setEta(int eta) {
		this.eta = eta;
	}
	
	/**
	 * Restituisce il parametro telefono di un oggetto cliente
	 * @return telefono - una stringa che rappresenta il telefono del cliente
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Modifica il parametro telefono di un oggetto cliente
	 * @param telefono - una stringa che rappresenta il telefono del cliente
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Restituisce il parametro email di un oggetto cliente
	 * @return email - una stringa che rappresental'email del cliente
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Modifica il parametro email di un oggetto cliente
	 * @param email - una stringa che rappresental'email del cliente
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "cliente [CF=" + CF + ", nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + ", telefono="
				+ telefono + ", email=" + email + "]";
	}
	
	private String CF; 
	private String nome;
	private String cognome;
	private int eta;
	private String telefono;
	private String email;
}
