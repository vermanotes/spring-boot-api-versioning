package com.reallybigindex.spring.boot.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

/**
 * ApiVersion annotation
 *
 * @author sushil@vermanotes.com
 * @version 1.0
 * @since Sept 21st, 2017
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiVersion {

	@AliasFor("supported")
	String[] value() default {};

	@AliasFor("value")
	String[] supported() default {};

	String atLeast() default "";

	String atMost() default "";

	String lessThan() default "";

	String greaterThan() default "";
}