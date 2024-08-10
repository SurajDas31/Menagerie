package com.sarvika.menagerie.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = SexValidator.class)
public @interface ValidSex {
    String message() default "Invalid gender! Please choose \"M\" or \"F\"";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
