
/**
 * Questa classe rappresenta un oggetto ristoroAlloggio
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class ristoroAlloggio {
	
	/**
	 * Costruttore, crea un oggeto ristoroAlloggio dati idRA, nome, tipo, via, citta, cAP, telefono
	 * @param idRA - un intero che rappresenta il codice identificativo di oggetto di tipo ristoroAlloggio
	 * @param nome - una stringa che rappresenta il nome di un oggetto di tipo ristoroAlloggio
	 * @param tipo - una stringa che rappresenta il tipo di un oggetto di tipo ristoroAlloggio
	 * @param via - una stringa che rappresenta la via di un oggetto di tipo ristoroAlloggio
	 * @param citta - una stringa che rappresenta la città di un oggetto di tipo ristoroAlloggio
	 * @param cAP - una stringa che rappresenta il CAP di un oggetto di tipo ristoroAlloggio
	 * @param telefono - una stringa che rappresenta il telefono di un oggetto di tipo ristoroAlloggio
	 */
	public ristoroAlloggio(int idRA, String nome, String tipo, String via, String citta, 
			String cAP, String telefono) {
		
		this.IdRA = idRA;
		this.nome = nome;
		this.tipo = tipo;
		this.via = via;
		this.citta = citta;
		this.CAP = cAP;
		this.telefono = telefono;
	}
	
	/**
	 * Restituisce il parametro IdRA di un oggetto ristoroAlloggio
	 * @return idRA - un intero che rappresenta il codice identificativo di oggetto di tipo ristoroAlloggio
	 */
	public int getIdRA() {
		return IdRA;
	}
	
	/**
	 * Modifica il parametro IdRA di un oggetto ristoroAlloggio
	 * @param idRA - un intero che rappresenta il codice identificativo di oggetto di tipo ristoroAlloggio
	 */
	public void setIdRA(int idRA) {
		IdRA = idRA;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto ristoroAlloggio
	 * @return nome - una stringa che rappresenta il nome di un oggetto di tipo ristoroAlloggio
	 */
	public String getNome() {
		return nome;
	}
	
	/**
	 * Modifica il parametro nome di un oggetto ristoroAlloggio
	 * @param nome - una stringa che rappresenta il nome di un oggetto di tipo ristoroAlloggio
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro tipo di un oggetto ristoroAlloggio
	 * @return tipo - una stringa che rappresenta il tipo di un oggetto di tipo ristoroAlloggio
	 */
	public String getTipo() {
		return tipo;
	}
	
	/**
	 * Modifica il parametro tipo di un oggetto ristoroAlloggio
	 * @param tipo - una stringa che rappresenta il tipo di un oggetto di tipo ristoroAlloggio
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	/**
	 * Restituisce il parametro via di un oggetto ristoroAlloggio
	 * @return via - una stringa che rappresenta la via di un oggetto di tipo ristoroAlloggio
	 */
	public String getVia() {
		return via;
	}
	
	/**
	 * Modifica il parametro via di un oggetto ristoroAlloggio
	 * @param via - una stringa che rappresenta la via di un oggetto di tipo ristoroAlloggio
	 */
	public void setVia(String via) {
		this.via = via;
	}
	
	/**
	 * Restituisce il parametro citta di un oggetto ristoroAlloggio
	 * @return citta - una stringa che rappresenta la città di un oggetto di tipo ristoroAlloggio
	 */
	public String getCitta() {
		return citta;
	}
	
	/**
	 * Modifica  il parametro citta di un oggetto ristoroAlloggio
	 * @param citta - una stringa che rappresenta la città di un oggetto di tipo ristoroAlloggio
	 */
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	/**
	 * Restituisce il parametro CAP di un oggetto ristoroAlloggio
	 * @return CAP - una stringa che rappresenta il CAP di un oggetto di tipo ristoroAlloggio
	 */
	public String getCAP() {
		return CAP;
	}
	
	/**
	 * Modifica il parametro CAP di un oggetto ristoroAlloggio
	 * @param cAP - una stringa che rappresenta il CAP di un oggetto di tipo ristoroAlloggio
	 */
	public void setCAP(String cAP) {
		CAP = cAP;
	}
	
	/**
	 * Restituisce  il parametro telefono di un oggetto ristoroAlloggio
	 * @return telefono - una stringa che rappresenta il telefono di un oggetto di tipo ristoroAlloggio
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Modifica  il parametro telefono di un oggetto ristoroAlloggio
	 * @param telefono - una stringa che rappresenta il telefono di un oggetto di tipo ristoroAlloggio
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return "ristoroAlloggio [IdRA=" + IdRA + ", nome=" + nome + ", tipo=" + tipo + ", via=" + via + ", citta="
				+ citta + ", CAP=" + CAP + ", telefono=" + telefono + "]";
	}

	private int IdRA;
	private String nome;
	private String tipo;
	private String via;
	private String citta;
	private String CAP;
	private String telefono;
	
}
