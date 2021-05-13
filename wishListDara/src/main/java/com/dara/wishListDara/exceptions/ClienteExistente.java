package com.dara.wishListDara.exceptions;

public class ClienteExistente extends Exception {

    private String mensagem;

    public ClienteExistente() {

    }

    public ClienteExistente(String mensagem) {
        super();
        this.mensagem = mensagem;
    }
}
