package fr.diginamic.menupizzeria.model;

public class Pizza {

	static int compteur = 0;
	private int id;
	private String code;
	private String libelle;
	private double prix;

	public Pizza(String code, String libelle, double prix) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		id = compteur;
		compteur++;
	}

	public Pizza(int id, String code, String libelle, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
	}

	@Override
	public String toString() {
		return code + " -> " + libelle + "(" + prix + "€)";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getId() {
		return id;
	}

}
