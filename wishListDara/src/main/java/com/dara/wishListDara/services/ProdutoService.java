package com.dara.wishListDara.services;

import com.dara.wishListDara.entities.Produto;

import java.util.List;

public interface ProdutoService {

    List<Produto> findAll();

    Produto insert(Produto obj);

    Produto findById(Integer id);

    Produto delete(Integer id);
}
