package fr.diginamic.menupizzeria.exception;

/**
 * Exception déclenchée si la pizza à supprimer n'a pas été trouvé
 * 
 * @author Kevin.s
 *
 */
public class DeletePizzaException extends StockageException {

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public DeletePizzaException(String arg0) {
		super(arg0);
	}

}
