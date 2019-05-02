package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.PrixException;
import fr.diginamic.menupizzeria.model.Pizza;

/**
 * Classe représentant le service d'ajout de pizza
 * 
 * @author Kevin.s
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {

		try {
			Pizza pizza = creationPizza(scanner);
			if (dao.pizzaExists(pizza.getCode()) == false) {
				dao.saveNewPizza(pizza);
			}
		} catch (PrixException e) {
			System.out.println(e.getMessage());
		}
	}

}
