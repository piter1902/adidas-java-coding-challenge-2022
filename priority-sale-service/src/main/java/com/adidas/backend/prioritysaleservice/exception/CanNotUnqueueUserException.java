package com.adidas.backend.prioritysaleservice.exception;

import java.io.Serializable;

public class CanNotUnqueueUserException extends Exception implements Serializable {
    public CanNotUnqueueUserException(String message) {
        super(message);
    }
}
