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

}
