package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.CategoriePizzaInconnueException;
import fr.diginamic.menupizzeria.exception.PrixException;
import fr.diginamic.menupizzeria.exception.SavePizzaException;
import fr.diginamic.menupizzeria.exception.StockageException;
import fr.diginamic.menupizzeria.model.Pizza;

/**
 * Classe représentant le service d'ajout de pizza
 * 
 * @author Kevin.s
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws StockageException {

		try {
			Pizza pizza = creationPizza(scanner);
			if (dao.pizzaExists(pizza.getCode()) == false) {
				// TODO ValidatorPizzaUtils.validate(pizza);
				dao.saveNewPizza(pizza);
				SERVICE_LOG.info("ajout de la pizza " + pizza.toString());
			} else {
				throw new SavePizzaException("Une pizza avec ce code existe déja");
			}
		} catch (PrixException | CategoriePizzaInconnueException e) {
			System.out.println(e.getMessage());
			SERVICE_LOG.error(e.getMessage());
		}
	}

}
