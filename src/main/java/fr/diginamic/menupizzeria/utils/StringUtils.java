package fr.diginamic.menupizzeria.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {

	public static String getToString(Object obj) {
		StringBuilder chaine = new StringBuilder();
		List<Field> list = new ArrayList<>();
		list = Arrays.asList(obj.getClass().getDeclaredFields());

		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAccessible(true);
			if (list.get(i).isAnnotationPresent(ToString.class)) {
				ToString annotation = list.get(i).getAnnotation(ToString.class);
				try {
					chaine.append(annotation.before())
							.append(getUpperCaseString(annotation.upperCase(), list.get(i), obj))
							.append(annotation.after());
				} catch (Exception e) {
					System.out.println(e.getMessage());
					return "";
				}
			}
		}
		return chaine.toString();

	}

	private static String getUpperCaseString(boolean b, Field f, Object obj)
			throws IllegalArgumentException, IllegalAccessException {
		if (b) {
			return f.get(obj).toString().toUpperCase();
		} else {
			return f.get(obj).toString();
		}

	}
}
