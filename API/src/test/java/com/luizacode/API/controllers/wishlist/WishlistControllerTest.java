package com.luizacode.API.controllers.wishlist;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.luizacode.API.Controller.WishlistController;
import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Service.WishlistService;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {WishlistController.class})
@ExtendWith(SpringExtension.class)
public class WishlistControllerTest {
    @Autowired
    private WishlistController wishlistController;

    @MockBean
    private WishlistService wishlistService;

    @Test
    public void testAdicionaProdutoWhislist() throws Exception {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente1");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente1");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setCliente(cliente1);
        wishlist2.setListaProdutos(new ArrayList<Produto>());
        wishlist2.setIdWishlist(1L);
        when(this.wishlistService.verificaWishlist((Long) any(), (Long) any())).thenReturn(wishlist2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/wishlist/{idCliente}/{idProduto}",
                1L, 1L);
        MockMvcBuilders.standaloneSetup(this.wishlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"idWishlist\":1,\"cliente\":{\"idCliente\":1,\"nome\":\"Cliente1\",\"cpf\":\"12345678912\",\"email\":\"cliente1@gmail.com\"},"
                                        + "\"listaProdutos\":[]}")));
    }

    @Test
    public void testRemoveProdutoWishlist() throws Exception {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente1");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente1");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setCliente(cliente1);
        wishlist2.setListaProdutos(new ArrayList<Produto>());
        wishlist2.setIdWishlist(1L);
        when(this.wishlistService.removeProdutoWishlist((Long) any(), (Long) any())).thenReturn(wishlist2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .delete("/api/wishlist/delete/{idCliente}/{idProduto}", 1L, 1L);
        MockMvcBuilders.standaloneSetup(this.wishlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"idWishlist\":1,\"cliente\":{\"idCliente\":1,\"nome\":\"Cliente1\",\"cpf\":\"12345678912\",\"email\":\"cliente1@gmail.com\"},"
                                        + "\"listaProdutos\":[]}")));
    }

    @Test
    public void testConsultaProduto() throws Exception {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Cliente1");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        when(this.wishlistService.consultaProdutoWishlist((Long) any(), (Long) any())).thenReturn(produto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/wishlist/{idCliente}/{idProduto}",
                1L, 1L);
        MockMvcBuilders.standaloneSetup(this.wishlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("{\"idProduto\":1,\"nome\":\"Cliente1\",\"valor\":42}")));
    }

    @Test
    public void testListaWhislist() throws Exception {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente1");
        cliente.setCpf("12345678912");
        cliente.setWishlist(new Wishlist());

        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(cliente);
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente1");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente1);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);
        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
        when(this.wishlistService.listaWishlist((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/wishlist/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.wishlistController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString(
                                "{\"idWishlist\":1,\"cliente\":{\"idCliente\":1,\"nome\":\"Cliente1\",\"cpf\":\"12345678912\",\"email\":\"cliente1@gmail.com\"},"
                                        + "\"listaProdutos\":[]}")));
    }
}

