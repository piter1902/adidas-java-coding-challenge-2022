package com.adidas.backend.prioritysaleservice.exception;

import java.io.Serializable;

public class CanNotDequeueUserException extends Exception implements Serializable {
    public CanNotDequeueUserException(String message) {
        super(message);
    }
}
