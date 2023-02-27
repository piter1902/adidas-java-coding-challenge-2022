package com.adidas.backend.publicservice.config;

import com.adidas.backend.publicservice.exception.BadRequestException;
import com.adidas.backend.publicservice.exception.ConflictException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String methodKey, Response response) {
        final int STATUS_OK = 200;
        final int STATUS_CONFLICT = 409;

        switch (response.status()) {
            case STATUS_OK:
                return new BadRequestException("Bad Request");
            case STATUS_CONFLICT:
                return new ConflictException("Conflict");
            default:
                return errorDecoder.decode(methodKey, response);
        }
    }
}
