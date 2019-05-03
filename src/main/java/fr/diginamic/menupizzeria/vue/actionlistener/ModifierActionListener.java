package fr.diginamic.menupizzeria.vue.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.model.CategoriePizza;
import fr.diginamic.menupizzeria.model.Pizza;
import fr.diginamic.menupizzeria.utils.OptionPaneUtils;

/**
 * ActionListener correspondant au bouton modifier
 * 
 * @author Kevin.s
 *
 */
public class ModifierActionListener implements ActionListener {

	/** dao : PizzaMemDao */
	private PizzaMemDao dao;
	/** model : DefaultListModel<Pizza> */
	private DefaultListModel<Pizza> model;
	/** myList : JList<Pizza> */
	private JList<Pizza> myList;

	/**
	 * Constructeur
	 * 
	 * @param dao
	 *            Classe contenant la liste de pizza
	 * @param model
	 *            DefaultListModel contenant les pizza
	 * @param myList
	 *            Composant JList de l'ihm
	 */
	public ModifierActionListener(PizzaMemDao dao, DefaultListModel<Pizza> model, JList<Pizza> myList) {
		super();
		this.dao = dao;
		this.model = model;
		this.myList = myList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ListSelectionModel selModel = myList.getSelectionModel();
		int index = selModel.getMinSelectionIndex();

		if (index == -1) {
			return;
		}

		Pizza item = model.getElementAt(index);
		String code = JOptionPane.showInputDialog("code");
		String nom = JOptionPane.showInputDialog("nom");
		Double prix = OptionPaneUtils.getPrix();
		// TODO faire un menu liste pour récupérer l'énum
		String categorie = JOptionPane.showInputDialog("catégorie en majuscule");
		try {
			if (code != null && nom != null && prix != null) {
				Pizza pizza = new Pizza(code, nom, prix, CategoriePizza.valueOf(categorie));
				dao.updatePizza(item.getCode(), pizza);
				model.remove(index);
				model.add(index, pizza);
			}
		} catch (IllegalArgumentException ex) {
			System.out.println("catégorie inconnu");
		}
	}

}
