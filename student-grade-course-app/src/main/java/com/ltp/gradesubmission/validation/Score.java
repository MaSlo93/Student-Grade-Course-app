package com.ltp.gradesubmission.validation;


import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ScoreValidator.class)

public @interface Score {

    String message() default "The score is not valid";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
    