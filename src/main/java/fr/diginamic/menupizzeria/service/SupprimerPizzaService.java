package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;

/**
 * Classe représentant le service de suppression d'une pizza
 * 
 * @author Kevin.s
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		System.out.println("Veuillez choiser le code de la pizza à supprimer");
		String code = scanner.next();

		if (dao.pizzaExists(code)) {
			dao.deletePizza(code);
		}
	}

}
