package fr.diginamic.menupizzeria.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.diginamic.menupizzeria.model.CategoriePizza;
import fr.diginamic.menupizzeria.model.Pizza;

public class PizzaMemDaoTest {

	@Before
	public void reset() {
		PizzaMemDao.resetInstance();
	}

	@Test
	public void testSaveNewPizza1() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		Pizza p = new Pizza("TEST", "test", 12, CategoriePizza.VIANDE);
		dao.saveNewPizza(p);
		assertTrue(dao.findAllPizzas().indexOf(p) != -1);
	}

	@Test
	public void testSaveNewPizza2() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		dao.saveNewPizza(null);
		assertTrue(dao.findPizzaByCode("test") == null);
	}

	@Test
	public void testUpdatePizza1() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		Pizza p = new Pizza("TEST", "test", 12, CategoriePizza.VIANDE);
		dao.updatePizza("PEP", p);
		assertEquals(p, dao.findPizzaByCode("TEST"));
		assertFalse(dao.pizzaExists("PEP"));
	}

	@Test
	public void testUpdatePizza2() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		Pizza p = new Pizza("TEST", "test", 12, CategoriePizza.VIANDE);
		dao.updatePizza("dddddd", p);
		assertFalse(dao.pizzaExists("TEST"));
	}

	@Test
	public void testUpdatePizza3() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		Pizza p = null;
		dao.updatePizza("PEP", p);
		assertEquals(null, dao.findPizzaByCode("TEST"));
	}

	@Test
	public void testDeletePizza1() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		dao.deletePizza("PEP");
		assertFalse(dao.pizzaExists("PEP"));
	}

	@Test
	public void testDeletePizza2() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		int longueurTab = dao.findAllPizzas().size();
		dao.deletePizza("bépo");
		assertTrue(dao.findAllPizzas().size() == longueurTab);
	}

	@Test
	public void testPizzaExists1() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		dao.saveNewPizza(new Pizza("TEST", "test", 12, CategoriePizza.VIANDE));
		assertTrue(dao.pizzaExists("TEST"));
	}

	@Test
	public void testPizzaExists2() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		assertFalse(dao.pizzaExists("n'éxiste pas"));
	}

	@Test
	public void testPizzaExists3() {
		PizzaMemDao dao = PizzaMemDao.getInstance();
		assertFalse(dao.pizzaExists(null));
	}

}
