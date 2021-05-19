package com.luizacode.API.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class WishlistException extends RuntimeException{
    public WishlistException(String message){
        super(message);
    }
}
