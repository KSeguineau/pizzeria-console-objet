package fr.diginamic.menupizzeria.exception;

/**
 * Exception déclenchée lorsque qu'aucune Categoriepizza n'a été trouvé
 * 
 * @author Kevin.s
 *
 */
public class CategoriePizzaInconnueException extends Exception {

	/**
	 * Constructeur
	 * 
	 * @param message
	 */
	public CategoriePizzaInconnueException(String message) {
		super(message);
	}

}
