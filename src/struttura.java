
/**
 * Questa classe rappresenta un oggetto struttura
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class struttura {

	/**
	 * Costruttore, crea un oggetto struttura
	 * @param codStruttura - una stringa che rappresenta il codice di una struttura
	 * @param nome - una stringa che rappresenta il nome di una struttura
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public struttura(String codStruttura, String nome, int idParco) {
		
		this.CodStruttura = codStruttura;
		this.nome = nome;
		this.IdParco = idParco;
	}
	
	/**
	 * Restituisce il parametro CodStruttura di un oggetto struttura
	 * @return CodStruttura - una stringa che rappresenta il codice di una struttura 
	 */
	public String getCodStruttura() {
		return CodStruttura;
	}
	
	/**
	 * Modifica il parametro CodStruttura di un oggetto struttura 
	 * @param codStruttura - una stringa che rappresenta il codice di una struttura 
	 */
	public void setCodStruttura(String codStruttura) {
		CodStruttura = codStruttura;
	}
	
	/**
	 * Restituisce il parametro nome di un oggetto di tipo struttura
	 * @return nome - una stringa che rappresenta il nome di una struttura
	 */
	public String getNome() {
		return nome;
	}
	
	
	/**
	 * Modifica il parametro nome di un oggetto di tipo struttura
	 * @param nome - una stringa che rappresenta il nome di una struttura
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Restituisce il parametro idParco di un oggetto di tipo struttura
	 * @return idParco - un intero che rappresenta il codice identificativo di un parco
	 */
	public int getIdParco() {
		return IdParco;
	}
	
	/**
	 * Modifica il parametro idParco di un oggetto di tipo struttura 
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
		return "struttura [CodStruttura=" + CodStruttura + ", nome=" + nome + ", IdParco=" + IdParco + "]";
	}

	private String CodStruttura;
	private String nome;
	private int IdParco; 
	
}
