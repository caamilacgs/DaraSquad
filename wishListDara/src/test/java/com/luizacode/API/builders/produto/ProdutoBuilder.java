package com.luizacode.API.builders.produto;

import com.luizacode.API.Entity.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProdutoBuilder {

    private static final Long DEFAULT_ID_1 = (1L);
    private static final String DEFAULT_NOME_1 = "Bolsa Vermelha";
    private static final BigDecimal DEFAULT_VALOR_1 = new BigDecimal(499.99);

    private static final Long DEFAULT_ID_2 = (2L);
    private static final String DEFAULT_NOME_2 = "Bolsa Preta";
    private static final BigDecimal DEFAULT_VALOR_2 = new BigDecimal(599.99);


    public Produto criarProdutoEntityComId() {
        Produto produto1 = new Produto();

        produto1.setIdProduto(DEFAULT_ID_1);
        produto1.setNome(DEFAULT_NOME_1);
        produto1.setValor(DEFAULT_VALOR_1);

        return produto1;
    }

    public List<Produto> criarListaProdutoEntityComId() {

        List<Produto> listaProdutos = new ArrayList<>();

        Produto produto1 = new Produto();

        produto1.setIdProduto(DEFAULT_ID_1);
        produto1.setNome(DEFAULT_NOME_1);
        produto1.setValor(DEFAULT_VALOR_1);

        Produto produto2 = new Produto();

        produto2.setIdProduto(DEFAULT_ID_2);
        produto2.setNome(DEFAULT_NOME_2);
        produto2.setValor(DEFAULT_VALOR_2);

        listaProdutos.add(produto1);
        listaProdutos.add(produto2);

        return listaProdutos;
    }
}
