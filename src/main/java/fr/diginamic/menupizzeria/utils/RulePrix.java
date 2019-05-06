package fr.diginamic.menupizzeria.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * à utiliser sur un attribut de type double pour vérifier si cette valeur est
 * compris entre min et max, à utiliser avec ValidatorPizzaUtils.java
 * 
 * @author Kevin.s
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface RulePrix {

	/**
	 * determine la limite basse *
	 * 
	 * @return
	 */
	double min() default 0.0d;

	/**
	 * determine la limite haute
	 * 
	 * @return
	 */
	double max() default 1.0d;
}
