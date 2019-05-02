package fr.diginamic.menupizzeria.vue.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.model.Pizza;
import fr.diginamic.menupizzeria.vue.utils.OptionPaneUtils;

/**
 * ActionListener correspondant au bouton ajouter
 * 
 * @author Kevin.s
 *
 */
public class AjouterActionListener implements ActionListener {

	/** dao : PizzaMemDao */
	PizzaMemDao dao;
	/** model : DefaultListModel<Pizza> */
	DefaultListModel<Pizza> model;

	/**
	 * Constructeur
	 * 
	 * @param dao
	 *            Classe contenant la liste de pizza
	 * @param model
	 *            DefaultListModel contenant les pizza
	 */
	public AjouterActionListener(PizzaMemDao dao, DefaultListModel<Pizza> model) {
		super();
		this.dao = dao;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String code = JOptionPane.showInputDialog("code");
		String nom = JOptionPane.showInputDialog("nom");
		Double prix = OptionPaneUtils.getPrix();

		if (code != null && nom != null && prix != null) {
			Pizza pizza = new Pizza(code, nom, prix);
			if (dao.pizzaExists(pizza.getCode()) == false) {
				dao.saveNewPizza(pizza);
				model.addElement(pizza);
			}
		}
	}

}
