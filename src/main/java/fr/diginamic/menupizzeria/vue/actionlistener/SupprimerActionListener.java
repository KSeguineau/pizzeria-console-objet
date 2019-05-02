package fr.diginamic.menupizzeria.vue.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.model.Pizza;

/**
 * ActionListener correspondant au bouton supprimer
 * 
 * @author Kevin.s
 *
 */
public class SupprimerActionListener implements ActionListener {

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
	public SupprimerActionListener(PizzaMemDao dao, DefaultListModel<Pizza> model, JList<Pizza> myList) {
		super();
		this.dao = dao;
		this.model = model;
		this.myList = myList;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ListSelectionModel selModel = myList.getSelectionModel();

		int index = selModel.getMinSelectionIndex();

		if (index >= 0) {
			dao.deletePizza(model.getElementAt(index).getCode());
			model.remove(index);

		}

	}
}