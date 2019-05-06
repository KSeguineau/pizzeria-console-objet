package fr.diginamic.menupizzeria.exception;

/**
 * Exception déclenchée si le code de la pizza à modifier n'est pas celui d'une
 * pizza existante
 * 
 * @author Kevin.s
 *
 */
public class UpdatePizzaException extends StockageExcepion {

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public UpdatePizzaException(String arg0) {
		super(arg0);
	}

}
