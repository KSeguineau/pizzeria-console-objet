package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.CategoriePizzaInconnueException;
import fr.diginamic.menupizzeria.exception.PrixException;
import fr.diginamic.menupizzeria.exception.StockageExcepion;
import fr.diginamic.menupizzeria.model.CategoriePizza;
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
	 * @throws StockageExcepion
	 */
	public abstract void executeUC(Scanner scanner, IPizzaDao dao) throws StockageExcepion;

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
	 * @throws PrixException
	 *             si l'utilisateur entre un prix qui ne peut pas être parser en
	 *             double
	 * @throws CategoriePizzaInconnueException
	 *             si l'utilisateur indique une categorie de pizza qui n'éxiste
	 *             pas
	 */
	public Pizza creationPizza(Scanner scan) throws PrixException, CategoriePizzaInconnueException {

		System.out.println("Veuillez saisir le code:");
		String code = scan.next();
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = scan.next();
		System.out.println("Veuillez saisir le prix:");
		try {
			double prix = Double.parseDouble(scan.next());
			System.out.println("Veuillez saisir la categorie de la pizza en majuscule");
			CategoriePizza categorie = CategoriePizza.valueOf(scan.next());
			return new Pizza(code, nom, prix, categorie);
		} catch (NumberFormatException e) {
			throw new PrixException();
		} catch (IllegalArgumentException e) {
			throw new CategoriePizzaInconnueException("Aucune Pizza de cette categorie n'a été trouvée");
		}

	}

}
