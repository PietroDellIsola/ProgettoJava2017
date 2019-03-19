
/**
 * Questa classe rappresenta un oggetto di tipo parcoAvventura
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class parcoAvventura extends parco
{
	/**
	 * Costruttore, crea un oggetto di tipo parcoAcquatico dati idParco, nome, sede, email, telefono, 
	 * numBigliettiVendita e percorso
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco acquatico
	 * @param nome - una stringa che rappresenta il nome di un parco acquatico
	 * @param sede - una stringa che rappresenta la sede di un parco acquatico
	 * @param email - una stringa che rappresenta l'email di un parco acquatico
	 * @param telefono - una stringa che rappresenta il telefono di un parco acquatico
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 * @param percorso - una stringa che rappresenta il percorso di un parcoAvventura
	 */
	public parcoAvventura(int idParco, String nome, String sede, String email, 
			String telefono, int numBigliettiVendita, String percorso) {
		super(idParco, nome, sede, email, telefono, numBigliettiVendita);
		this.percorso = percorso;
	}
	
	/**
	 * Restituisce il parametro percorso di un oggetto di tipo parcoAvventura
	 * @return percorso - una stringa che rappresenta il percorso di un parcoAvventura
	 */
	public String getPercorso() {
		return percorso;
	}

	/**
	 * Modifica il parametro percorso di un oggetto di tipo parcoAvventura
	 * @param percorso - una stringa che rappresenta il percorso di un parcoAvventura
	 */
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}

	/**
	 * Restituisce il parametro numBigliettiVendita di un oggetto parcoAvventura
	 * @return numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 */
	public int getNumBigliettiV() {
		return super.getNumBigliettiVendita();
	}
	
	/**
	 * Modifica il parametro numBigliettiVendita di un oggetto parcoAvventura
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 */
	public void setNumBigliettiV(int numBigliettiVendita){
		super.setNumBigliettiVendita(numBigliettiVendita);
	}
	
	/**
	 * Ritorna una stringa che rappresenta l'oggetto
	 * @param String
	 */
	public String toString() {
		return super.toString()+"[percorso=" + percorso + "]";
	}
		
	private String percorso;
	
}
