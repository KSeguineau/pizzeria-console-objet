package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;

/**
 * Classe représentant le service d'affichage des pizzas
 * 
 * @author Kevin.s
 *
 */
public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, PizzaMemDao dao) {
		dao.findAllPizzas().forEach(p -> System.out.println(p));
	}

}
