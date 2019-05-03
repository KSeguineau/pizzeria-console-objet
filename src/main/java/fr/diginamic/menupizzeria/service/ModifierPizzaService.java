package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.CategoriePizzaInconnueException;
import fr.diginamic.menupizzeria.exception.PrixException;
import fr.diginamic.menupizzeria.exception.StockageExcepion;
import fr.diginamic.menupizzeria.exception.UpdatePizzaException;

/**
 * Classe représentant le service de modification d'une pizza
 * 
 * @author Kevin.s
 *
 */
public class ModifierPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws StockageExcepion {
		dao.findAllPizzas().forEach(p -> System.out.println(p));
		System.out.println("Veuillez choisir le code de la pizza à modifier");
		String code = scanner.next();
		if (dao.pizzaExists(code)) {
			try {
				dao.updatePizza(code, creationPizza(scanner));
			} catch (PrixException | CategoriePizzaInconnueException e) {
				System.out.println(e.getMessage());
			}
		} else {
			throw new UpdatePizzaException("Aucune pizza avec ce code n'à été trouvée");
		}
	}

}
