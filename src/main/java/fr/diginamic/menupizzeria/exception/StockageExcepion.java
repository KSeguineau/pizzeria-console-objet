package fr.diginamic.menupizzeria.exception;

/**
 * Exception pouvant être déclenchée par la manipulation de la liste de pizza
 * 
 * @author Kevin.s
 *
 */
public abstract class StockageExcepion extends Exception {

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public StockageExcepion(String arg0) {
		super(arg0);
	}

}
