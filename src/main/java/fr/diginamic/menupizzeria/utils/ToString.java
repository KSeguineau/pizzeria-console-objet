package fr.diginamic.menupizzeria.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Cette annotation permet de generer les toString des attributs, s'utilise avec
 * StringUtils
 * 
 * @author Kevin.s
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
public @interface ToString {

	/**
	 * ce qui doit etre affiché avant l'attribut
	 * 
	 * @return
	 */
	String before() default "";

	/**
	 * ce qui doit etre affiché apres l'attribut
	 * 
	 * @return
	 */
	String after() default "";

	/**
	 * détermine si l'attribut doit être affiché en majuscule
	 * 
	 * @return
	 */
	boolean upperCase() default false;

}
