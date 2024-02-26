package com.management.system.demo.service.validations;

import org.hibernate.annotations.Target;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

//@Documented
//@Constraint(validatedBy = ValidPasswordValidator.class)
//@Target({FIELD, ANNOTATION_TYPE})
//@Retention(RUNTIME)
public @interface ValidPassword {
}
