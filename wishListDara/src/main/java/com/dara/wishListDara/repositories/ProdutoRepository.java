package com.dara.wishListDara.repositories;

import com.dara.wishListDara.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
