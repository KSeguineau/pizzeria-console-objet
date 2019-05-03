package fr.diginamic.menupizzeria.utils;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(FIELD)
public @interface RulePrix {

	double min() default 0.0d;

	double max() default 1.0d;
}
