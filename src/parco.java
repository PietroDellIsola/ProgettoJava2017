
/**
 * Questa classe rappresenta un oggetto di tipo parco
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class parco {
	
	/**
	 * Costruttore, crea un oggetto parco dati idParco, nome, sede, email, telefono, numBigliettiVendita
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco 
	 * @param nome - una stringa che rappresenta il nome di un parco
	 * @param sede - una stringa che rappresenta la sede di un parco
	 * @param email - una stringa che rappresenta l'email di un parco
	 * @param telefono - una stringa che rappresenta il telefono di un parco
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco
	 */
	public parco(int idParco, String nome, String sede, String email, String telefono,
			int numBigliettiVendita) {
		
		this.IdParco = idParco;
		this.nome = nome;
		this.sede = sede;
		this.email = email;
		this.telefono = telefono;
		this.numBigliettiVendita= numBigliettiVendita;
	}
	
	/**
	 * Restituisce il parametro IdParco di un oggetto parco
	 * @return IdParco - un intero che rappresenta il codice identificativo di un parco 
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro IdParco di un oggetto parco
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco 
	 */
	public void setIdParco(int idParco) {
		IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto parco
	 * @return nome - una stringa che rappresenta il nome di un parco
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto parco
	 * @param nome - una stringa che rappresenta il nome di un parco
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce i parametro sede di un oggetto parco
	 * @return sede - una stringa che rappresenta la sede di un parco
	 */
	public String getSede() {
		return sede;
	}
	
	/**
	 * Modifica il parametro sede di un oggetto parco
	 * @param sede - una stringa che rappresenta la sede di un parco
	 */
	public void setSede(String sede) {
		this.sede = sede;
	}
	
	/**
	 * Restituisce il parametro email di un oggetto parco
	 * @return email - una stringa che rappresenta l'email di un parco
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Modifica  il parametro email di un oggetto parco
	 * @param email - una stringa che rappresenta l'email di un parco
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Restituisce  il parametro telefono di un oggetto parco
	 * @return telefono - una stringa che rappresenta il telefono di un parco
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Modifica il parametro telefono di un oggetto parco
	 * @param telefono - una stringa che rappresenta il telefono di un parco
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	/**
	 * Restituisce il parametro numBigliettiVendita di un oggetto parco
	 * @return numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco
	 */
	public int getNumBigliettiVendita() {
		return numBigliettiVendita;
	}
	
	/**
	 * Modifica il parametro numBigliettiVendita di un oggetto parco
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco
	 */
	public void setNumBigliettiVendita(int numBigliettiVendita) {
		this.numBigliettiVendita = numBigliettiVendita;
	}
	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return this.getClass().getName()+"[numBigliettiVendita=" + numBigliettiVendita + ", IdParco=" + IdParco + ", nome=" + nome
				+ ", sede=" + sede + ", email=" + email + ", telefono=" + telefono + "]";
	}

	private int numBigliettiVendita;
	private int IdParco;
	private String nome;
	private String sede;
	private String email;
	private String telefono;
	
}
