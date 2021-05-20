package com.luizacode.API.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourcesNotFoundException extends RuntimeException{

    public ResourcesNotFoundException(String message) {
        super(message);
    }

}
