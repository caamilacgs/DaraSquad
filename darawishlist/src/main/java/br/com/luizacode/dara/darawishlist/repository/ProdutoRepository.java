package br.com.luizacode.dara.darawishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luizacode.dara.darawishlist.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
