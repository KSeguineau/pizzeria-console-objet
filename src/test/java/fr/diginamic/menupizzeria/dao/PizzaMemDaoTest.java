package fr.diginamic.menupizzeria.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fr.diginamic.menupizzeria.model.CategoriePizza;
import fr.diginamic.menupizzeria.model.Pizza;

public class PizzaMemDaoTest {

	@Test
	public void testSaveNewPizza() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		Pizza p = new Pizza("TEST", "test", 12, CategoriePizza.VIANDE);
		dao.saveNewPizza(p);
		assertTrue(dao.findAllPizzas().indexOf(p) != -1);
	}

	@Test
	public void testUpdatePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePizza() {
		fail("Not yet implemented");
	}

	@Test
	public void testPizzaExists() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		dao.saveNewPizza(new Pizza("TEST", "test", 12, CategoriePizza.VIANDE));
		assertTrue(dao.pizzaExists("TEST"));
	}

}
