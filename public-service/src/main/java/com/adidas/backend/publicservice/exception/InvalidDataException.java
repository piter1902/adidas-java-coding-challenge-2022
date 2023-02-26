package com.adidas.backend.publicservice.exception;

import org.springframework.cloud.commons.security.AccessTokenContextRelay;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serializable;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidDataException extends Exception implements Serializable {
    public InvalidDataException(String message) {
        super(message);
    }
}
