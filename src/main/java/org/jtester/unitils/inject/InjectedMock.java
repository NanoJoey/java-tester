package org.jtester.unitils.inject;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.unitils.inject.util.PropertyAccess;

/**
 * 
 * property == "" equals to @Mock + @InjectIntoByType <br>
 * property != "" equals to @Mock + @InjectInto
 * 
 * @return
 * 
 * @author davey.wu
 * 
 */
@Target(FIELD)
@Retention(RUNTIME)
public @interface InjectedMock {
	String target() default "";

	String property() default "";

	PropertyAccess propertyAccess() default PropertyAccess.DEFAULT;
}