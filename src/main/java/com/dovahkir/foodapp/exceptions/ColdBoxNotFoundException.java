package com.dovahkir.foodapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ColdBoxNotFoundException extends RuntimeException {
    public ColdBoxNotFoundException(String message) {
        super(message);
    }
}
