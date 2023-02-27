package com.adidas.backend.prioritysaleservice.exception;

import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
@StandardException
public class CanNotQueueUserException extends Exception{
}
