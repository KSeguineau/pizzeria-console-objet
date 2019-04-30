package fr.diginamic.menupizzeria.dao;

import java.util.List;

import fr.diginamic.menupizzeria.model.Pizza;

public interface IPizzaDao {

	/**
	 * retourne la liste de pizza
	 * 
	 * @return la liste de pizza
	 */
	List<Pizza> findAllPizzas();

	/**
	 * ajoute une pizza à la liste de pizza
	 * 
	 * @param pizza
	 *            pizza à ajouter
	 */
	void saveNewPizza(Pizza pizza);

	/**
	 * permet de mettre à jour une pizza
	 * 
	 * @param codePizza
	 *            code de la pizza à mettre à jour
	 * @param pizza
	 *            nouvelle pizza
	 */
	void updatePizza(String codePizza, Pizza pizza);

	/**
	 * supprime la pizza dont le code correspond
	 * 
	 * @param codePizza
	 *            code de la pizza à supprimer
	 * 
	 */
	void deletePizza(String codePizza);

	/**
	 * retourne la pizza dont le code est passé en paramètre
	 * 
	 * @param codePizza
	 *            code de la pizza à chercher
	 * @return retourne une pizza
	 */
	Pizza findPizzaByCode(String codePizza);

	/**
	 * retourne vrai si la pizza est dans la liste de pizza
	 * 
	 * @param codePizza
	 *            code de la pizza à chercher
	 * @return retourne un boolean
	 */
	boolean pizzaExists(String codePizza);

}
