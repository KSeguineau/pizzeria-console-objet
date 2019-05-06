package fr.diginamic.menupizzeria.service;

import java.util.Scanner;

import fr.diginamic.menupizzeria.dao.IPizzaDao;
import fr.diginamic.menupizzeria.exception.CategoriePizzaInconnueException;
import fr.diginamic.menupizzeria.exception.PrixException;
import fr.diginamic.menupizzeria.exception.SavePizzaException;
import fr.diginamic.menupizzeria.exception.StockageExcepion;
import fr.diginamic.menupizzeria.model.Pizza;
import fr.diginamic.menupizzeria.utils.ValidatorPizzaUtils;

/**
 * Classe représentant le service d'ajout de pizza
 * 
 * @author Kevin.s
 *
 */
public class AjouterPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws StockageExcepion {

		try {
			Pizza pizza = creationPizza(scanner);
			if (dao.pizzaExists(pizza.getCode()) == false) {
				ValidatorPizzaUtils.validate(pizza);
				dao.saveNewPizza(pizza);
			} else {
				throw new SavePizzaException("Une pizza avec ce code existe déja");
			}
		} catch (PrixException | CategoriePizzaInconnueException e) {
			System.out.println(e.getMessage());
		}
	}

}
