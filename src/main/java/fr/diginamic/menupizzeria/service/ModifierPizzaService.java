package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;

/**
 * Classe représentant le service de modification d'une pizza
 * 
 * @author Kevin.s
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao dao) {
		dao.findAllPizzas().forEach(p -> System.out.println(p));
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		String code = scanner.next();
		if (dao.pizzaExists(code)) {
			dao.updatePizza(code, creationPizza(scanner));
		}
	}

}
