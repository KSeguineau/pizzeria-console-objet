package fr.diginamic.menupizzeria.model;

/**
 * Énumeration representant les différentes catégories de pizza
 * 
 * @author Kevin.s
 *
 */
public enum CategoriePizza {

	/** VIANDE : CategoriePizza */
	VIANDE("Viande"),
	/** POISSON : CategoriePizza */
	POISSON("Poisson"),
	/** SANS_VIANDE : CategoriePizza */
	SANS_VIANDE("Sans Viande");

	/** nom : String */
	private String nom;

	/**
	 * Constructeur
	 * 
	 * @param s
	 *            nom de la Categorie de Pizza
	 */
	private CategoriePizza(String s) {
		nom = s;
	}

	/**
	 * Getter
	 * 
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

}
