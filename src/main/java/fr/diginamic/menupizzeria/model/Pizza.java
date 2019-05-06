package fr.diginamic.menupizzeria.model;

import fr.diginamic.menupizzeria.utils.RuleCode;
import fr.diginamic.menupizzeria.utils.RulePrix;
import fr.diginamic.menupizzeria.utils.StringUtils;
import fr.diginamic.menupizzeria.utils.ToString;

/**
 * Classe representant une pizza
 * 
 * @author Kevin.s
 *
 */
public class Pizza {

	/** compteur : int */
	private static int compteur = 0;
	/** id : int */
	private int id;
	/** code : String */
	@ToString(upperCase = true, after = " ->")
	@RuleCode(longueur = 3)
	private String code;
	/** libelle : String */
	@ToString(before = " ", after = " ")
	private String libelle;
	/** prix : double */
	@ToString(before = "(", after = "€)")
	@RulePrix(min = 0, max = 20)
	private double prix;

	/** categorie : CategoriePizza */
	@ToString(before = "(", after = ")")
	CategoriePizza categorie;

	/**
	 * Constructeur
	 * 
	 * @param code
	 *            code de la pizza
	 * @param libelle
	 *            nom de la pizza
	 * @param prix
	 *            prix de la pizza
	 */
	public Pizza(String code, String libelle, double prix, CategoriePizza categorie) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		id = compteur;
		compteur++;
	}

	/**
	 * Constructeur
	 * 
	 * @param id
	 *            identifiant de la pizza
	 * @param code
	 *            code de la pizza
	 * @param libelle
	 *            nom de la pizza
	 * @param prix
	 *            prix de la pizza
	 */
	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	@Override
	public String toString() {
		// return code + " -> " + libelle + "(" + prix + "€)";
		return StringUtils.getToString(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + id;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (id != other.id)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}

	/**
	 * Getter
	 * 
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setters
	 * 
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Getter
	 * 
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Setters
	 * 
	 * @param libelle
	 *            the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Getter
	 * 
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * Setters
	 * 
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * Getter
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

}
