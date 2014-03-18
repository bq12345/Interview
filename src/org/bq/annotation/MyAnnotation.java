package org.bq.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String hello() default "BaiQiang";
	Color color() default Color.BLANK;
	String world();
}
