package com.luizacode.API.services.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Repository.WishlistRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.luizacode.API.Service.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ClienteService.class})
@ExtendWith(SpringExtension.class)
public class ClienteServiceTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteService clienteService;

    @MockBean
    private WishlistRepository wishlistRepository;


    @Test
    public void cadastraClienteSucess() {
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
        when(this.clienteRepository.save((Cliente) any())).thenReturn(cliente2);
        when(this.clienteRepository.findByCpf(anyString())).thenReturn(Optional.<Cliente>empty());
        assertSame(cliente2, this.clienteService.cadastraCliente(new Cliente()));
    }

    @Test
    public void buscaClientesSuccess() {
        ArrayList<Cliente> clienteList = new ArrayList<Cliente>();
        when(this.clienteRepository.findAll()).thenReturn(clienteList);
        List<Cliente> actualBuscaClientesResult = this.clienteService.buscaClientes();
        assertSame(clienteList, actualBuscaClientesResult);
        assertTrue(actualBuscaClientesResult.isEmpty());
    }

    @Test
    public void atualizaClienteSuccess() {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);
        Optional<Cliente> ofResult = Optional.<Cliente>of(cliente1);

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(1L);
        cliente2.setEmail("cliente1@gmail.com");
        cliente2.setNome("Cliente");
        cliente2.setCpf("12345678912");
        cliente2.setWishlist(new Wishlist());

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setCliente(cliente2);
        wishlist2.setListaProdutos(new ArrayList<Produto>());
        wishlist2.setIdWishlist(1L);

        Cliente cliente3 = new Cliente();
        cliente3.setIdCliente(1L);
        cliente3.setEmail("cliente1@gmail.com");
        cliente3.setNome("Cliente");
        cliente3.setCpf("12345678912");
        cliente3.setWishlist(wishlist2);

        Wishlist wishlist3 = new Wishlist();
        wishlist3.setCliente(cliente3);
        wishlist3.setListaProdutos(new ArrayList<Produto>());
        wishlist3.setIdWishlist(1L);

        Cliente cliente4 = new Cliente();
        cliente4.setIdCliente(1L);
        cliente4.setEmail("cliente1@gmail.com");
        cliente4.setNome("Cliente");
        cliente4.setCpf("12345678912");
        cliente4.setWishlist(wishlist3);
        when(this.clienteRepository.save((Cliente) any())).thenReturn(cliente4);
        when(this.clienteRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(cliente4, this.clienteService.atualizaCliente(new Cliente()));
    }

    @Test
    public void deletaClienteSuccess() {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);
        Optional<Cliente> ofResult = Optional.<Cliente>of(cliente1);
        doNothing().when(this.clienteRepository).deleteById((Long) any());
        when(this.clienteRepository.findById((Long) any())).thenReturn(ofResult);
        Object actualDeletaClienteResult = this.clienteService.deletaCliente(123L);
        assertEquals(HttpStatus.OK, ((ResponseEntity) actualDeletaClienteResult).getStatusCode());
    }

    @Test
    public void deletaClienteException() {
        doNothing().when(this.clienteRepository).deleteById((Long) any());
        when(this.clienteRepository.findById((Long) any())).thenReturn(Optional.<Cliente>empty());
        assertThrows(ResourcesNotFoundException.class, () -> this.clienteService.deletaCliente(123L));
        verify(this.clienteRepository).findById((Long) any());
    }

    @Test
    public void buscaUmClienteSuccess() {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);
        Optional<Cliente> ofResult = Optional.<Cliente>of(cliente1);
        when(this.clienteRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(ofResult, this.clienteService.buscaUmCliente(123L));
    }

    @Test
    public void verificaClienteExiste() {
        Wishlist wishlist = new Wishlist();
        wishlist.setCliente(new Cliente());
        wishlist.setListaProdutos(new ArrayList<Produto>());
        wishlist.setIdWishlist(1L);

        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cliente.setEmail("cliente1@gmail.com");
        cliente.setNome("Cliente");
        cliente.setCpf("12345678912");
        cliente.setWishlist(wishlist);

        Wishlist wishlist1 = new Wishlist();
        wishlist1.setCliente(cliente);
        wishlist1.setListaProdutos(new ArrayList<Produto>());
        wishlist1.setIdWishlist(1L);

        Cliente cliente1 = new Cliente();
        cliente1.setIdCliente(1L);
        cliente1.setEmail("cliente1@gmail.com");
        cliente1.setNome("Cliente");
        cliente1.setCpf("12345678912");
        cliente1.setWishlist(wishlist1);
        Optional<Cliente> ofResult = Optional.<Cliente>of(cliente1);
        when(this.clienteRepository.findById((Long) any())).thenReturn(ofResult);
        this.clienteService.verificaClienteExiste(123L);
        verify(this.clienteRepository).findById((Long) any());
    }

    @Test
    public void verificaClienteExisteException() {
        when(this.clienteRepository.findById((Long) any())).thenReturn(Optional.<Cliente>empty());
        assertThrows(ResourcesNotFoundException.class, () -> this.clienteService.verificaClienteExiste(123L));
        verify(this.clienteRepository).findById((Long) any());
    }
}

