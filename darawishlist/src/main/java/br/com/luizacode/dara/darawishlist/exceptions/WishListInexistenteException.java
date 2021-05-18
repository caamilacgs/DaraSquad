package br.com.luizacode.dara.darawishlist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class WishListInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public WishListInexistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public WishListInexistenteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public WishListInexistenteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
