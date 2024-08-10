package com.sarvika.menagerie.model.validation;

import com.sarvika.menagerie.model.Sex;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SexValidator implements ConstraintValidator<ValidSex, Sex> {

    @Override
    public void initialize(ValidSex constraintAnnotation) {

        System.out.println("chla");
    }

    @Override
    public boolean isValid(Sex value, ConstraintValidatorContext context) {
        return value != null && (value == Sex.m || value == Sex.f);
    }
}

