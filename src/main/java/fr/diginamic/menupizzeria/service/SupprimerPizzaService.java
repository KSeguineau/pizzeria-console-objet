package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.DeletePizzaException;
import fr.diginamic.menupizzeria.exception.StockageException;

/**
 * Classe représentant le service de suppression d'une pizza
 * 
 * @author Kevin.s
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws StockageException {
		System.out.println("Veuillez choiser le code de la pizza à supprimer");
		String code = scanner.next();

		if (dao.pizzaExists(code)) {
			dao.deletePizza(code);
			SERVICE_LOG.info("supression de la pizza " + code);
		} else {
			throw new DeletePizzaException("Aucune pizza avec ce code n'à été trouvée");
		}
	}

}
