package com.luizacode.API.services.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
import com.luizacode.API.Repository.ProdutoRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.luizacode.API.Service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ProdutoService.class})
@ExtendWith(SpringExtension.class)
public class ProdutoServiceTest {

    @MockBean
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;


    @Test
    public void cadastraProdutoSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        when(this.produtoRepository.save((Produto) any())).thenReturn(produto);
        Produto actualCadastraProdutoResult = this.produtoService.cadastraProduto(new Produto());
        assertSame(produto, actualCadastraProdutoResult);
        assertEquals(new BigDecimal(42), actualCadastraProdutoResult.getValor());
        verify(this.produtoRepository).save((Produto) any());
    }

    @Test
    public void buscaProdutosSuccess() {
        ArrayList<Produto> produtoList = new ArrayList<Produto>();
        when(this.produtoRepository.findAll()).thenReturn(produtoList);
        List<Produto> actualBuscaProdutosResult = this.produtoService.buscaProdutos();
        assertSame(produtoList, actualBuscaProdutosResult);
        assertTrue(actualBuscaProdutosResult.isEmpty());
        verify(this.produtoRepository).findAll();
    }

    @Test
    public void atualizaProdutoSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult = Optional.<Produto>of(produto);

        Produto produto1 = new Produto();
        produto1.setValor(BigDecimal.valueOf(42L));
        produto1.setNome("Cliente");
        produto1.setIdProduto(1L);
        produto1.setListaWishlist(new ArrayList<Wishlist>());
        when(this.produtoRepository.save((Produto) any())).thenReturn(produto1);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult);
        Produto actualAtualizaProdutoResult = this.produtoService.atualizaProduto(new Produto());
        assertSame(produto1, actualAtualizaProdutoResult);
        assertEquals(new BigDecimal(42), actualAtualizaProdutoResult.getValor());
    }

    @Test
    public void deletaProdutoSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult = Optional.<Produto>of(produto);
        doNothing().when(this.produtoRepository).deleteById((Long) any());
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult);
        ResponseEntity<String> actualDeletaProdutoResult = this.produtoService.deletaProduto(123L);
        assertEquals(HttpStatus.OK, actualDeletaProdutoResult.getStatusCode());
        verify(this.produtoRepository).deleteById((Long) any());
        verify(this.produtoRepository).findById((Long) any());
    }

    @Test
    public void buscaUmProdutoSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult = Optional.<Produto>of(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult);
        Produto actualBuscaUmProdutoResult = this.produtoService.buscaUmProduto(123L);
        assertSame(produto, actualBuscaUmProdutoResult);
        assertEquals(new BigDecimal(42), actualBuscaUmProdutoResult.getValor());
    }

    @Test
    public void verificaProdutoExisteSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult = Optional.<Produto>of(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult);
        this.produtoService.verificaProdutoExiste(123L);
    }

    @Test
    public void verificaProdutoExisteException() {
        when(this.produtoRepository.findById((Long) any())).thenReturn(Optional.<Produto>empty());
        assertThrows(ResourcesNotFoundException.class, () -> this.produtoService.verificaProdutoExiste(123L));
        verify(this.produtoRepository).findById((Long) any());
    }
}

