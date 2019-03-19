
/**
 * Questa classe rappresenta un oggetto accountAgenzia
 * @author Pietro Dell'Isola, Luca Lamberti
 */
public class accountAgenzia {

	/**
	 * Costruttore, crea un oggetto accountAgenzia dati un ID, una password ed una partita iva di un agenzia
	 * @param iD - una stringa che rappresenta l'ID dell'account
	 * @param password - una stringa che rappresenta la password dell'account
	 * @param p_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 */
	public accountAgenzia(String iD, String password, String p_IVA) {
		this.ID = iD;
		this.password = password;
		this.P_IVA = p_IVA;
	}
	
	/**
	 * Restituisce il parametro ID di un oggetto accountAgenzia
	 * @return ID - una stringa che rappresenta l'ID dell'account
	 */
	public String getID() {
		return ID;
	}
	
	/**
	 * Modifica il parametro ID di un oggetto accountAgenzia
	 * @param ID - una stringa che rappresenta l'ID dell'account
	 */
	public void setID(String iD) {
		ID = iD;
	}
	
	/**
	 * Restituisce il parametro password di un oggetto accountAgenzia
	 * @return password - una stringa che rappresenta la password dell'account
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * Modifica il parametro password di un oggetto accountAgenzia
	 * @param password - una stringa che rappresenta la password dell'account
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Restituisce il parametro P_IVA di un oggetto accountAgenzia
	 * @return P_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 */
	public String getP_IVA() {
		return P_IVA;
	}
	
	/**
	 * Modifica il parametro P_IVA di un oggetto accountAgenzia 
	 * @param p_IVA - una stringa che rappresenta la partita iva dell'agenzia
	 */
	public void setP_IVA(String p_IVA) {
		P_IVA = p_IVA;
	}

	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String 
	 */
	public String toString() {
		return "accountAgenzia [ID=" + ID + ", password=" + password + ", P_IVA=" + P_IVA + "]";
	}

	
	private String ID;
	private String password;
	private String P_IVA;
}
