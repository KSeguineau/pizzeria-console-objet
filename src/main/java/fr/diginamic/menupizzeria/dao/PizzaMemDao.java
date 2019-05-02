package fr.diginamic.menupizzeria.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.diginamic.menupizzeria.model.Pizza;

/**
 * Classe qui permet de stocker des pizzas dans une liste et de les manipuler
 * 
 * @author Kevin.s
 *
 */
public class PizzaMemDao implements IPizzaDao {// TODO faire un singleton

	/** serialVersionUID : long */
	private static final long serialVersionUID = 2341274652240553005L;
	/** listePizza : List<Pizza> */
	List<Pizza> listePizza;

	private static PizzaMemDao instanceDao = null;

	/**
	 * Constructeur initialise une liste de pizza par défault
	 */
	private PizzaMemDao() {
		listePizza = new ArrayList<>();
		listePizza.addAll(Arrays.asList(new Pizza("PEP", "Pépéroni", 12.50), new Pizza("Mar", "Margherita", 14.00),
				new Pizza("REIN", "La Reine", 11.50), new Pizza("Fro", "La 4 fromages", 12.00),
				new Pizza("CAN", "La cannibale", 12.50), new Pizza("SAV", "La savoyarde", 13.00),
				new Pizza("ORI", "L'orientale", 13.50), new Pizza("IND", "L'indienne", 14.00)));
	}

	public static PizzaMemDao getInstance() {
		if (instanceDao == null) {
			instanceDao = new PizzaMemDao();
		}
		return instanceDao;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listePizza;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		listePizza.add(pizza);

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		if (pizzaExists(codePizza)) {
			for (int i = 0; i < listePizza.size(); i++) {
				if (listePizza.get(i).getCode().equals(codePizza)) {
					listePizza.set(i, pizza);
				}
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		if (pizzaExists(codePizza)) {
			listePizza.remove(findPizzaByCode(codePizza));
		}
	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		for (int i = 0; i < listePizza.size(); i++) {
			if (listePizza.get(i).getCode().equals(codePizza)) {
				return listePizza.get(i);
			}
		}
		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		return findPizzaByCode(codePizza) != null;
	}

	@Override
	public String toString() {
		return listePizza.toString();
	}

}
