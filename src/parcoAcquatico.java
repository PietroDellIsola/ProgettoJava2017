
/**
 * Questa classe rappresenta un oggetto di tipo parcoAcquatico
 * @author Pietro Dell'Isola, Luca Lamberti
 *
 */
public class parcoAcquatico extends parco
{	
	
	/**
	 * Costruttore, crea un oggetto di tipo parcoAcquatico dati idParco, nome, sede, email, telefono, 
	 * numBigliettiVendita e numPiscine
	 * @param idParco - un intero che rappresenta il codice identificativo di un parco acquatico
	 * @param nome - una stringa che rappresenta il nome di un parco acquatico
	 * @param sede - una stringa che rappresenta la sede di un parco acquatico
	 * @param email - una stringa che rappresenta l'email di un parco acquatico
	 * @param telefono - una stringa che rappresenta il telefono di un parco acquatico
	 * @param numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 * @param numPiscine - un intero che rappresenta il numero di piscine di un parco acquatico
	 */
	public parcoAcquatico(int idParco, String nome, String sede, String email,
			String telefono,int numBigliettiVendita, int numPiscine) {
		
		super(idParco, nome, sede, email, telefono, numBigliettiVendita);
		this.numPiscine = numPiscine;
	}

	/**
	 * Ritorna il parametro numPiscine di un oggetto parcoAcquatico
	 * @return numPiscine - un intero che rappresenta il numero di piscine di un parco acquatico
	 */
	public int getNumPiscine() {
		return numPiscine;
	}

	/**
	 * Modifica il parametro numPiscine di un oggetto parcoAcquatico
	 * @param numPiscine - un intero che rappresenta il numero di piscine di un parco acquatico
	 */
	public void setNumPiscine(int numPiscine) {
		this.numPiscine = numPiscine;
	}

	/**
	 * Restituisce il parametro numBigliettiVendita di un oggetto parcoAcquatico
	 * @return numBigliettiVendita - un intero che rapresenta il numero di biglietti in vendita di un parco acquatico
	 */
	public int getNumBigliettiV() {
		return super.getNumBigliettiVendita();
	}
	
	/**
	 * Modifica il parametro numBigliettiVendita di un oggetto parcoAcquatico
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
		return super.toString()+"[numPiscine=" + numPiscine + "]";
	}
	
	private int numPiscine;
}
