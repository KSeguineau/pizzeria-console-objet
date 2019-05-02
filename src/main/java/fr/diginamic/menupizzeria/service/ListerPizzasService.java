package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;

/**
 * Classe représentant le service d'affichage des pizzas
 * 
 * @author Kevin.s
 *
 */
public class ListerPizzasService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) {
		dao.findAllPizzas().forEach(p -> System.out.println(p));
	}

}
