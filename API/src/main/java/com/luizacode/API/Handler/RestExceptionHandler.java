package com.luizacode.API.Handler;

import com.luizacode.API.Exceptions.ResourcesNotFoundDetails;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
import com.luizacode.API.Exceptions.WishlistDetails;
import com.luizacode.API.Exceptions.WishlistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourcesNotFoundException.class)
    public ResponseEntity<?> handleResourcesNotFoundException(ResourcesNotFoundException rfnException){
        ResourcesNotFoundDetails rfnDetails =  ResourcesNotFoundDetails.Builder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.NOT_FOUND.value())
                .title("Resource not found")
                .detail(rfnException.getMessage())
                .developerMessage(rfnException.getClass().getName())
                .build();
        return new ResponseEntity<>(rfnDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(WishlistException.class)
    public ResponseEntity<?> handleWishlistException(WishlistException wishException){
        WishlistDetails wishDetails = WishlistDetails.WishlistBuilder
                .newBuilder()
                .timestamp(new Date().getTime())
                .status(HttpStatus.BAD_REQUEST.value())
                .title("Wishlist Exception")
                .detail(wishException.getMessage())
                .developerMessage(wishException.getClass().getName())
                .build();
        return new ResponseEntity<>(wishDetails, HttpStatus.BAD_REQUEST);

    }

}
