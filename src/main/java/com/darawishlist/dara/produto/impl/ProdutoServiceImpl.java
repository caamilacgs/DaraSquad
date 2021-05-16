package com.darawishlist.dara.produto.impl;

import com.darawishlist.dara.produto.Produto;
import com.darawishlist.dara.produto.ProdutoRepository;
import com.darawishlist.dara.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

   @Autowired
   private ProdutoRepository produtoRepository;

   @Override
   public List<Produto> listarProdutos() {
      return ProdutoRepository.listarTodosOsProdutos;
   }

   @Override
   public Produto buscarId(Integer id) {
      return produtoRepository.BuscarProdutoPorId(id).orElse(new Produto());
   }

   @Override
   public Produto cadastrar(Produto produto) {
      return this.produtoRepository.save(produto);
   }

   @Override
   public void remover(Integer id) {
      List<Produto> produto = produtoRepository.listarTodosOsProdutos(id);
      produtoRepository.delete(produto.get(id));
   }

   @Override
   public Produto atualizar(Produto produto, Integer id) {
      Optional<Produto> produtoCampo = this.produtoRepository.BuscarProdutoPorId(id);
      Produto atualizarProduto = produtoCampo.get();

      if (produtoCampo.isPresent()) {

         atualizarProduto.setNome(produto.getNome());
         atualizarProduto.setDescricao(produto.getDescricao());
         atualizarProduto.setValor(produto.getValor());

         atualizarProduto = this.produtoRepository.save(atualizarProduto);
      }
      return atualizarProduto;
   }

}
