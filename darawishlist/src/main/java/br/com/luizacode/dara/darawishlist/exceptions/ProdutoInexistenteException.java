package br.com.luizacode.dara.darawishlist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST)
public class ProdutoInexistenteException extends RuntimeException {

	private static final long serialVersionUID = 1L;


	public ProdutoInexistenteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public ProdutoInexistenteException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ProdutoInexistenteException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
