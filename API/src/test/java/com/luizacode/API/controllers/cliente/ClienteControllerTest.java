package com.luizacode.API.controllers.cliente;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luizacode.API.Controller.ClienteController;
import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Service.ClienteService;

import java.util.ArrayList;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {ClienteController.class})
@ExtendWith(SpringExtension.class)
public class ClienteControllerTest {

    @Autowired
    private ClienteController clienteController;

    @MockBean
    private ClienteService clienteService;


    @Test
    public void cadastraClienteSuccess() throws Exception {
        when(this.clienteService.buscaClientes()).thenReturn(new ArrayList<Cliente>());

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(new Wishlist());

        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(cliente);
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente1);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(1L);
        cliente2.setEmail("cliente1@gmail.com");
        cliente2.setNome("Cliente");
        cliente2.setCpf("12345678912");
        cliente2.setWishlist(wishlist1);
        String content = (new ObjectMapper()).writeValueAsString(cliente2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void deletaClienteSuccess() throws Exception {
        when(this.clienteService.deletaCliente((Long) any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/api/cliente/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }

    @Test
    public void atualizaClienteSuccess() throws Exception {
        when(this.clienteService.buscaClientes()).thenReturn(new ArrayList<Cliente>());

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(new Wishlist());

        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(cliente);
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente1);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(1L);
        cliente2.setEmail("cliente1@gmail.com");
        cliente2.setNome("Cliente");
        cliente2.setCpf("12345678912");
        cliente2.setWishlist(wishlist1);
        String content = (new ObjectMapper()).writeValueAsString(cliente2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cliente")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void listaClienteSuccess() throws Exception {
        when(this.clienteService.buscaClientes()).thenReturn(new ArrayList<Cliente>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cliente");
        MockMvcBuilders.standaloneSetup(this.clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("[]")));
    }

    @Test
    public void listaClienteUnicoSuccess() throws Exception {
        when(this.clienteService.buscaUmCliente((Long) any())).thenReturn("42");
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/cliente/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.clienteController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("42")));
    }
}

