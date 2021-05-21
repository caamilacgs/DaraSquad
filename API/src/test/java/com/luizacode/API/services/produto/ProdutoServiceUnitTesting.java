package com.luizacode.API.services.produto;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Repository.ProdutoRepository;
import com.luizacode.API.Service.ProdutoService;
import com.luizacode.API.builders.produto.ProdutoBuilder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProdutoServiceUnitTesting {

    @InjectMocks
    private ProdutoService produtoService; // oque será testado

    @Mock
    private ProdutoRepository produtoRepository; // oque será mockado

    ProdutoBuilder produtoBuilder = new ProdutoBuilder();


    @Test
    @DisplayName("cadastraProduto - Sucesso")
    public void cadastraProdutoSuccess() {
        Produto produto1 = produtoBuilder.criarProdutoEntityComId();

        Mockito.when(produtoRepository.save(produto1)).thenReturn(produto1);

        Optional<Produto> produto = Optional.ofNullable(produtoService.cadastraProduto(produto1));

        Assertions.assertTrue(produto.isPresent());
    }

    @Test
    @DisplayName("buscaProdutos - Sucesso")
    public void findAllProdutosSuccess() {
        List<Produto> produtos = produtoBuilder.criarListaProdutoEntityComId();

        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        List<Produto> produtoList = produtoService.buscaProdutos();

        Assertions.assertEquals(produtoList.size(), produtos.size());

        Assertions.assertEquals(produtos.get(0).getIdProduto(), produtoList.get(0).getIdProduto());
        Assertions.assertEquals(produtos.get(0).getNome(), produtoList.get(0).getNome());
        Assertions.assertEquals(produtoList.get(0).getValor(), produtoList.get(0).getValor());

        Assertions.assertEquals(produtos.get(1).getIdProduto(), produtoList.get(1).getIdProduto());
        Assertions.assertEquals(produtos.get(1).getNome(), produtoList.get(1).getNome());
        Assertions.assertEquals(produtoList.get(1).getValor(), produtoList.get(1).getValor());
    }

//    @Test
//    @DisplayName("atualizaProduto - Sucesso")
//    public void atualizaProdutoSuccess() {
//        Produto produto = produtoBuilder.criarProdutoEntityComId();
//
//
//        when(produtoRepository.findById(1L)).thenReturn(produto);
//        when(produtoRepository.save(any())).thenReturn(produto);
//
//        Produto response = produtoService.atualizaProduto(produto);
//
//        Assertions.assertEquals(produto.getIdProduto(), response.getIdProduto());
//        Assertions.assertEquals(produto.getNome(), response.getNome());
//        Assertions.assertEquals(produto.getValor(), response.getValor());
//    }

//    @Test
//    @DisplayName("atualizaProduto - Sucesso")
//    public void atualizaProdutoSuccess() {
//        List<Produto> produtos = produtoBuilder.criarListaProdutoEntityComId();
//
//        Produto produto1 = produtos.get(0);
//        Produto produto2 = produtos.get(1);
//
//        Mockito.when(produtoRepository.save(produto1)).thenReturn(produto2);
//        Mockito.when(produtoService.atualizaProduto(produto1)).thenReturn(produto2);
//
//        Produto produto = produtoService.atualizaProduto(produto1);
//
//        Assertions.assertEquals(2L, produto.getIdProduto());
//    }

//    @Test
//    @DisplayName("deletaProduto - Sucesso")
//    public void deletaProdutoSuccess() {
//        Produto produto1 = produtoBuilder.criarProdutoEntityComId();
//
//        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1).get());
//
//        ResponseEntity<String> produtoResult = produtoService.deletaProduto(1L);
//
//        Mockito.verify(produtoRepository, Mockito.times(1)).deleteById(produto1.getIdProduto());
//    }

    @Test
    @DisplayName("buscaUmProduto - Sucesso")
    public void buscaUmProdutoByIdSuccess() {
        Produto produto1 = produtoBuilder.criarProdutoEntityComId();

        Mockito.when(produtoRepository.findById(1L)).thenReturn(produto1);
        Mockito.when(produtoService.buscaUmProduto(1L)).thenReturn(produto1);

        Produto produtoResult = produtoService.buscaUmProduto(1L);

        Assertions.assertEquals(produtoResult.getIdProduto(), produto1.getIdProduto());
    }

//    @Test
//    @DisplayName("buscaUmProduto - Sucesso")
//    public void findProdutosByIdSuccess() {
//        Produto produto1 = produtoBuilder.criarProdutoEntityComId();
//
//        Mockito.when(produtoRepository.findById(1L)).thenReturn(Optional.of(produto1).get());
//        Mockito.when(produtoService.buscaUmProduto(1L)).thenReturn(Optional.of(produto1));
//
//        Optional<Produto> produtoResult = produtoService.buscaUmProduto(1L);
//
//        Assertions.assertEquals(1L, produtoResult.get().getIdProduto());
//    }

}

