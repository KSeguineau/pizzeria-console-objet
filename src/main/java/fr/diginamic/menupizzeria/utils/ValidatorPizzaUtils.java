package fr.diginamic.menupizzeria.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * permet de valider si une pizza conforme au regle présent sur ses attributs
 * 
 * @author Kevin.s
 *
 */
public class ValidatorPizzaUtils {
	// TODO finir le validator

	public static void validate(Object obj) {
		List<Field> list = new ArrayList<>();
		list = Arrays.asList(obj.getClass().getDeclaredFields());

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAccessible(true);
			if (list.get(i).isAnnotationPresent(RulePrix.class)) {
				RulePrix annotation = list.get(i).getAnnotation(RulePrix.class);
				verifierPrix(annotation, list.get(i), obj);

			} else if (list.get(i).isAnnotationPresent(RuleCode.class)) {
				RuleCode annotation = list.get(i).getAnnotation(RuleCode.class);
			}
		}
	}

	private static void verifierPrix(RulePrix rule, Field field, Object obj) {
		if (field.getType().getName().equals("double")) {
			try {
				Double valeur = Double.parseDouble(field.get(obj).toString());
			} catch (Exception e) {
				System.out.println(e.getMessage());

			}

		}
	}
}
