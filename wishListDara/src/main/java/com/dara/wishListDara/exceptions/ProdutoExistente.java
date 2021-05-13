package com.dara.wishListDara.exceptions;

public class ProdutoExistente extends Exception {

    private String mensagem;

    public ProdutoExistente() {

    }

    public ProdutoExistente(String mensagem) {
        super();
        this.mensagem = mensagem;
    }
}
