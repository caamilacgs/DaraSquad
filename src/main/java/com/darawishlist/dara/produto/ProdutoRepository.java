package com.darawishlist.dara.produto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

   List<Produto> listarTodosOsProdutos = null;

   Object buscarId(Integer id);

   List<Produto> listarTodosOsProdutos(Integer id);

   Optional<Produto> BuscarProdutoPorId(Integer id);

}
