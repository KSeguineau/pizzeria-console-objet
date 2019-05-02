package fr.diginamic.menupizzeria;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.exception.StockageExcepion;
import fr.diginamic.menupizzeria.service.MenuService;

/**
 * point d'entrée de notre application, gestion du menu de service
 * 
 * @author Kevin.s
 *
 */
public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		IPizzaDao dao = PizzaMemDao.getInstance();
		boolean sortir = false;

		while (!sortir) {
			afficherMenu();
			int choix = scanner.nextInt();

			if (choix == 1 || choix == 2 || choix == 3 || choix == 4) {
				try {
					MenuService.factory(choix).executeUC(scanner, dao);
				} catch (StockageExcepion e) {
					System.out.println(e.getMessage());
				}
			} else if (choix == 99) {
				System.out.println("Aurevoir :(");
				sortir = true;
			} else {
				System.out.println("commande non reconnue");
			}

		}
		scanner.close();
	}

	/**
	 * méthode permettant d'afficher le menu
	 */
	public static void afficherMenu() {
		System.out.println("***** Pizzeria Administration *****");
		System.out.println("1. Lister les Pizzas");
		System.out.println("2. Ajouter une nouvelle pizza");
		System.out.println("3. Mettre à jour une pizza");
		System.out.println("4. Supprimer une pizza");
		System.out.println("99. Sortir");
	}

}
