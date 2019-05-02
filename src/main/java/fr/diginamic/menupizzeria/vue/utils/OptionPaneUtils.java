package fr.diginamic.menupizzeria.vue.utils;

import javax.swing.JOptionPane;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * classe contenant des méthodes concernant les boites de dialogue
 * 
 * @author Kevin.s
 *
 */
public class OptionPaneUtils {

	/**
	 * redemande un prix tant que l'utilisateur n'en n'a pas saisi de correct
	 * 
	 * @return double
	 */
	public static double getPrix() {
		String chainePrix = null;
		while (!NumberUtils.isCreatable(chainePrix)) {
			chainePrix = (JOptionPane.showInputDialog("prix"));
		}
		return Double.parseDouble(chainePrix);

	}

}
