package com.criticalweb.ksp.mod.explorer.forms.validation;

/**
 * @author: Francois Levesque <francois@critical-web.com>
 * @since 1.0
 */

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = MustMatchValidator.class)
@Documented
public @interface MustMatch {

	String message() default "{com.critical_web.blog.form.validation.mustmatch}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String first();

	String second();

}