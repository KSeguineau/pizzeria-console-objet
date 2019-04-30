package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;

/**
 * Classe représentant le service d'ajout de pizza
 * 
 * @author Kevin.s
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao dao) {

		dao.saveNewPizza(creationPizza(scanner));
	}

}
