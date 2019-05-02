package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.exception.PrixException;

/**
 * Classe représentant le service d'ajout de pizza
 * 
 * @author Kevin.s
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao dao) {

		try {
			dao.saveNewPizza(creationPizza(scanner));
		} catch (PrixException e) {
			System.out.println(e.getMessage());
		}
	}

}
