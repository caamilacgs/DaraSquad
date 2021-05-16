package com.darawishlist.dara.produto;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProdutoService {

    List<Produto> listarProdutos();

    Produto buscarId(Integer id);

    Produto cadastrar(Produto produto);

    void remover(Integer id);

    Produto atualizar(Produto produto, Integer id);

}
