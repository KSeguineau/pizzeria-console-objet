package fr.diginamic.menupizzeria.exception;

/**
 * Exception declenchée si l'utilisateur essaye d'ajouter une pizza avec un code
 * qui existe déja
 * 
 * @author Kevin.s
 *
 */
public class SavePizzaException extends StockageExcepion {

	/**
	 * Constructeur
	 * 
	 * @param arg0
	 */
	public SavePizzaException(String arg0) {
		super(arg0);
	}

}
