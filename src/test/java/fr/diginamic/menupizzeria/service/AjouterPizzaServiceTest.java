package fr.diginamic.menupizzeria.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.exception.StockageException;

public class AjouterPizzaServiceTest {

	private PizzaMemDao dao = PizzaMemDao.getInstance();
	/**
	 * Création d'une "Rule" qui va permettre de substituer le System.in utilisé
	 * par le Scanner par un mock: systemInMock
	 */
	@Rule
	public TextFromStandardInputStream systemInMock = emptyStandardInputStream();

	@Before
	public void resetInstance() {
		PizzaMemDao.resetInstance();
	}

	@Test
	public void testExecuteUC1() {
		systemInMock.provideLines("TEST", "test", "12", "VIANDE");

		AjouterPizzaService service = new AjouterPizzaService();
		try {
			service.executeUC(new Scanner(System.in), dao);
			assertTrue(dao.pizzaExists("TEST"));
		} catch (StockageException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	public void testExecuteUC2() {
		systemInMock.provideLines("TEST", "test", "12", "blabla");

		AjouterPizzaService service = new AjouterPizzaService();
		try {
			service.executeUC(new Scanner(System.in), dao);
			assertFalse(dao.pizzaExists("TEST"));
		} catch (StockageException e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testExecuteUC3() {
		systemInMock.provideLines("TEST", "test", "abc", "VIANDE");
		AjouterPizzaService service = new AjouterPizzaService();
		try {
			service.executeUC(new Scanner(System.in), dao);
			assertFalse(dao.pizzaExists("TEST"));
		} catch (StockageException e) {
			fail(e.getMessage());
		}
	}

	@Test(expected = StockageException.class)
	public void testExecuteUC4() throws StockageException {
		systemInMock.provideLines("PEP", "test", "12", "VIANDE");

		AjouterPizzaService service = new AjouterPizzaService();
		service.executeUC(new Scanner(System.in), dao);

	}
}
