package fr.diginamic.menupizzeria.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * à utiliser sur une chaine de caractère pour imposer une longueur, s'utilise
 * avec ValidatorPizzaUtils.java
 * 
 * @author Kevin.s
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface RuleCode {

	/**
	 * determine la longueur de la chaine
	 * 
	 * @return
	 */
	int longueur() default 3;

}
