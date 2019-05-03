package fr.diginamic.menupizzeria.model;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");

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

	/**
	 * Setters
	 * 
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
