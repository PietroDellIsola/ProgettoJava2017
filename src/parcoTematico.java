
/**
 * Questa classe rappresenta un oggetto di tipo parcoTematico
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class parcoTematico extends parco
{
	/**
	 * Costruttore, crea un oggetto di tipo parcoTematico dati idParco, nome, sede, email, telefono, 
	 * numBigliettiVendita e tema
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco acquatico
	 * @param nome - una stringa che rappresenta il nome di un parco acquatico
	 * @param sede - una stringa che rappresenta la sede di un parco acquatico
	 * @param email - una stringa che rappresenta l'email di un parco acquatico
	 * @param telefono - una stringa che rappresenta il telefono di un parco acquatico
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 * @param tema - una stringa che rappresenta il tema di un parco
	 */
	public parcoTematico(int idParco, String nome, String sede, String email, String telefono, 
			int numBigliettiVendita, String tema) {
		super(idParco, nome, sede, email, telefono, numBigliettiVendita);
		this.tema = tema;
	}
	
	
	/**
	 * Restituisce il parametro tema di un oggetto parcoTematico
	 * @return tema - una stringa che rappresenta il tema di un parco tematico 
	 */
	public String getTema() {
		return tema;
	}

	/**
	 * Modifica il parametro tema di un oggetto parcoTematico
	 * @param tema - una stringa che rappresenta il tema di un parco tematico
	 */
	public void setTema(String tema) {
		this.tema = tema;
	}

	/**
	 * Restituisce il parametro numBigliettiVendita di un oggetto parcoTematico
	 * @return numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco tematico
	 */
	public int getNumBigliettiV() {
		return super.getNumBigliettiVendita();
	}
	
	/**
	 * Modifica il parametro numBigliettiVendita di un oggetto parcoTematico
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco tematico
	 */
	public void setNumBigliettiV(int numBigliettiVendita){
		super.setNumBigliettiVendita(numBigliettiVendita);
	}
	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return super.toString()+"[tema=" + tema + "]";
	}
		
	private String tema;
	
}
