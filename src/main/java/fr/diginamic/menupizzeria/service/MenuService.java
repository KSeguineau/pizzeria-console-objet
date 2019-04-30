package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.model.Pizza;

/**
 * classe abstraite représentant les services disponible à l'utilisateur
 * 
 * @author Kevin.s
 *
 */
public abstract class MenuService {

	/**
	 * méthode executant un service
	 * 
	 * @param scanner
	 *            permet de récuperer les entrées de l'utilisateur
	 * @param dao
	 *            objet stockant et manipulant des pizzas
	 */
	public abstract void executeUC(Scanner scanner, PizzaMemDao dao);

	/**
	 * retourne une classe qui correspond au service demandé
	 * 
	 * @param choix
	 *            correspond au choix de service de l'utilisateur
	 * @return retourne une classe MenuService
	 */
	public static MenuService factory(int choix) {

		switch (choix) {
		case 1:
			return new ListerPizzasService();
		case 2:
			return new AjouterPizzaService();
		case 3:
			return new ModifierPizzaService();
		case 4:
			return new SupprimerPizzaService();
		default:
			return null;
		}

	}

	/**
	 * méthode permettant de créer une pizza
	 * 
	 * @param scan
	 *            Scanner qui récupere les entrées de l'utilisateur
	 * @return une pizza
	 */
	public Pizza creationPizza(Scanner scan) {

		System.out.println("Veuillez saisir le code:");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = scan.next();
		System.out.println("Veuillez saisir le prix:");
		double prix = Double.parseDouble(scan.next());
		return new Pizza(code, nom, prix);

	}

}
