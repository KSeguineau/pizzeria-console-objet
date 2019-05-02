package fr.diginamic.menupizzeria.vue;

import static javax.swing.GroupLayout.Alignment.CENTER;

import java.awt.Container;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import fr.diginamic.menupizzeria.dao.PizzaMemDao;
import fr.diginamic.menupizzeria.model.Pizza;
import fr.diginamic.menupizzeria.vue.actionlistener.AjouterActionListener;
import fr.diginamic.menupizzeria.vue.actionlistener.ModifierActionListener;
import fr.diginamic.menupizzeria.vue.actionlistener.SupprimerActionListener;

/**
 * l'ihm du restaurant de pizza
 * 
 * @author Kevin.s
 *
 */
public class Vue extends JFrame {

	/** serialVersionUID : long */
	private static final long serialVersionUID = -8791022567087976945L;
	/** model : DefaultListModel<Pizza> */
	private DefaultListModel<Pizza> model;
	/** myList : JList<Pizza> */
	private JList<Pizza> myList;
	/** btnAjouter : JButton */
	private JButton btnAjouter;
	/** btnModifier : JButton */
	private JButton btnModifier;
	/** btnSupprimer : JButton */
	private JButton btnSupprimer;
	/** dao : PizzaMemDao */
	PizzaMemDao dao;

	/**
	 * Constructeur initialise le dao et l'interface
	 */
	public Vue() {
		dao = PizzaMemDao.getInstance();
		initUI();
	}

	/**
	 * creer la liste en ajoutant les pizzas du dao
	 */
	private void creerList() {

		model = new DefaultListModel<>();
		for (int i = 0; i < dao.findAllPizzas().size(); i++) {
			model.addElement(dao.findAllPizzas().get(i));
		}

		myList = new JList<>(model);
		myList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	/**
	 * creer les boutons ajouter, modifier,supprimer et creer les ActionListener
	 * correspondant
	 */
	private void creerBtn() {

		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");

		btnAjouter.addActionListener(new AjouterActionListener(dao, model));

		btnSupprimer.addActionListener(new SupprimerActionListener(dao, model, myList));

		btnModifier.addActionListener(new ModifierActionListener(dao, model, myList));

	}

	/**
	 * méthode qui creer et initialise l'interface
	 */
	private void initUI() {

		creerList();
		creerBtn();

		JScrollPane scrollPane = new JScrollPane(myList);
		createLayout(scrollPane, btnAjouter, btnModifier, btnSupprimer);
		setSize(350, 400);
		setTitle("Bienvenu chez Bobby");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * ajoute et organise les composant du JScrollPane
	 * 
	 * @param arg
	 *            composant du JScrollPane
	 */
	private void createLayout(JComponent... arg) {

		Container pane = getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		gl.setAutoCreateContainerGaps(true);
		gl.setAutoCreateGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(arg[0])
				.addGroup(gl.createParallelGroup().addComponent(arg[1]).addComponent(arg[2]).addComponent(arg[3])));

		gl.setVerticalGroup(gl.createParallelGroup(CENTER).addComponent(arg[0])
				.addGroup(gl.createSequentialGroup().addComponent(arg[1]).addComponent(arg[2]).addComponent(arg[3])));

		gl.linkSize(btnAjouter, btnModifier, btnSupprimer);

	}

}
