package com.luizacode.API.controllers.produto;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizacode.API.Controller.ProdutoController;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Service.ProdutoService;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ProdutoController.class})
@ExtendWith(SpringExtension.class)
public class ProdutoControllerTest {

    @Autowired
    private ProdutoController produtoController;

    @MockBean
    private ProdutoService produtoService;


    @Test
    public void cadastraProdutoSuccess() throws Exception {
        when(this.produtoService.buscaProdutos()).thenReturn(new ArrayList<Produto>());

        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        String content = (new ObjectMapper()).writeValueAsString(produto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void deletaProdutoSuccess() throws Exception {
        when(this.produtoService.deletaProduto((Long) any())).thenReturn(new ResponseEntity<String>(HttpStatus.CONTINUE));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/produto/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.produtoController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().is(100));
    }

    @Test
    public void atualizaProdutoSuccess() throws Exception {
        when(this.produtoService.buscaProdutos()).thenReturn(new ArrayList<Produto>());

        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        String content = (new ObjectMapper()).writeValueAsString(produto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/produto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void listaProdutoSuccess() throws Exception {
        when(this.produtoService.buscaProdutos()).thenReturn(new ArrayList<Produto>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/produto");
        MockMvcBuilders.standaloneSetup(this.produtoController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void listaProdutoUnicoSuccess() throws Exception {
        when(this.produtoService.buscaProdutos()).thenReturn(new ArrayList<Produto>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/produto");
        getResult.contentType("...");
        MockMvcBuilders.standaloneSetup(this.produtoController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

}

