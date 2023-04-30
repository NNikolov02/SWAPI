package com.swapi.swapi.Web.validation;

import jakarta.validation.Payload;

public @interface ValidGender {
    String message() default "Character should be male or female";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
