package fr.diginamic.menupizzeria;

import java.awt.EventQueue;

import fr.diginamic.menupizzeria.vue.Vue;

/**
 * IHM de la pizzeria
 * 
 * @author Kevin.s
 *
 */
public class PizzeriaIhmAdminConsoleApp {

	/**
	 * point d'entrée pour l'éxecution de l'interface
	 * 
	 * @param args
	 *            non utilisé
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(() -> {

			Vue vue = new Vue();
			vue.setVisible(true);
		});
	}

}
