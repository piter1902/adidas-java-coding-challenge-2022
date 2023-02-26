package com.adidas.backend.publicservice.validator;

import java.util.regex.Pattern;

public class EmailValidator {
    private final static String EMAIL_VALIDATION_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    public static boolean isValidEmail(String email) {
        return Pattern
                .compile(EMAIL_VALIDATION_REGEX)
                .matcher(email)
                .matches();
    }
}
