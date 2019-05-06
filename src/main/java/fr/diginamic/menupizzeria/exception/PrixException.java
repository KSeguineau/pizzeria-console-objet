package fr.diginamic.menupizzeria.exception;

/**
 * Exception déclenchée lorsque le prix entré par l'utilisateur n'est pas un
 * nombre
 * 
 * @author Kevin.s
 *
 */
public class PrixException extends Exception {

	/**
	 * Constructeur
	 * 
	 */
	public PrixException() {
		super("une erreur est survenue lors de la récupération du prix");
	}

}
