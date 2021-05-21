package com.luizacode.API.services.wishlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Repository.ProdutoRepository;
import com.luizacode.API.Repository.WishlistRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;
import javax.persistence.EntityManager;

import com.luizacode.API.Service.ClienteService;
import com.luizacode.API.Service.ProdutoService;
import com.luizacode.API.Service.WishlistService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {WishlistService.class})
@ExtendWith(SpringExtension.class)
public class WishlistServiceTest {

    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private ClienteService clienteService;

    @MockBean
    private EntityManager entityManager;

    @MockBean
    private ProdutoRepository produtoRepository;

    @MockBean
    private ProdutoService produtoService;

    @MockBean
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistService wishlistService;


//    @Test
//    public void listaWishlistSuccess() {
//        Cliente cliente = new Cliente();
//        cliente.setIdCliente(1L);
//        cliente.setEmail("cliente1@gmail.com");
//        cliente.setNome("Cliente");
//        cliente.setCpf("12345678912");
//        cliente.setWishlist(new Wishlist());
//
//        Wishlist wishlist = new Wishlist();
//        wishlist.setCliente(cliente);
//        wishlist.setListaProdutos(new ArrayList<Produto>());
//        wishlist.setIdWishlist(1L);
//
//        Cliente cliente1 = new Cliente();
//        cliente1.setIdCliente(1L);
//        cliente1.setEmail("cliente1@gmail.com");
//        cliente1.setNome("Cliente");
//        cliente1.setCpf("12345678912");
//        cliente1.setWishlist(wishlist);
//
//        Wishlist wishlist1 = new Wishlist();
//        wishlist1.setCliente(cliente1);
//        wishlist1.setListaProdutos(new ArrayList<Produto>());
//        wishlist1.setIdWishlist(1L);
//        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
//        when(this.wishlistRepository.findByClienteIdCliente((Long) any())).thenReturn(ofResult);
//        Optional<Wishlist> actualListaWishlistResult = this.wishlistService.listaWishlist(1L);
//        assertSame(ofResult, actualListaWishlistResult);
//        assertTrue(actualListaWishlistResult.isPresent());
//        verify(this.wishlistRepository).findByClienteIdCliente((Long) any());
//    }

    @Test
    public void consultaProdutoWishlistException() {
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
        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
        when(this.wishlistRepository.findByClienteIdCliente((Long) any())).thenReturn(ofResult);
        assertThrows(ResourcesNotFoundException.class, () -> this.wishlistService.consultaProdutoWishlist(1L, 1L));
        verify(this.wishlistRepository).findByClienteIdCliente((Long) any());
    }


    @Test
    public void removeProdutoWishlistSuccess() {
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
        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
        when(this.wishlistRepository.findByClienteIdCliente((Long) any())).thenReturn(ofResult);

        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Nome");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult1 = Optional.<Produto>of(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult1);
        assertSame(wishlist1, this.wishlistService.removeProdutoWishlist(1L, 1L));
        verify(this.produtoRepository).findById((Long) any());
    }

    @Test
    public void cadastraProdutoWishlistSuccess() {
        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Nome");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult = Optional.<Produto>of(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult);
        Wishlist wishlist = new Wishlist();
        Wishlist actualCadastraProdutoWishlistResult = this.wishlistService.cadastraProdutoWishlist(wishlist, 1L);
        assertSame(wishlist, actualCadastraProdutoWishlistResult);
        assertEquals("42", actualCadastraProdutoWishlistResult.getListaProdutos().get(0).getValor().toString());
        verify(this.produtoRepository).findById((Long) any());
    }

    @Test
    public void verificaWishlistSuccess() {
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
        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
        when(this.wishlistRepository.findByClienteIdCliente((Long) any())).thenReturn(ofResult);
        doNothing().when(this.produtoService).verificaProdutoExiste((Long) any());

        Produto produto = new Produto();
        produto.setValor(BigDecimal.valueOf(42L));
        produto.setNome("Nome");
        produto.setIdProduto(1L);
        produto.setListaWishlist(new ArrayList<Wishlist>());
        Optional<Produto> ofResult1 = Optional.<Produto>of(produto);
        when(this.produtoRepository.findById((Long) any())).thenReturn(ofResult1);
        Wishlist actualVerificaWishlistResult = this.wishlistService.verificaWishlist(1L, 1L);
        assertSame(wishlist1, actualVerificaWishlistResult);
        assertEquals("42", actualVerificaWishlistResult.getListaProdutos().get(0).getValor().toString());
        verify(this.produtoRepository).findById((Long) any());
        verify(this.produtoService).verificaProdutoExiste((Long) any());
    }

    @Test
    public void criaWishlistByClienteSuccess() {
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

        Wishlist wishlist2 = new Wishlist();
        wishlist2.setCliente(cliente1);
        wishlist2.setListaProdutos(new ArrayList<Produto>());
        wishlist2.setIdWishlist(1L);
        when(this.wishlistRepository.save((Wishlist) any())).thenReturn(wishlist2);

        Wishlist wishlist3 = new Wishlist();
        wishlist3.setCliente(new Cliente());
        wishlist3.setListaProdutos(new ArrayList<Produto>());
        wishlist3.setIdWishlist(1L);

        Cliente cliente2 = new Cliente();
        cliente2.setIdCliente(1L);
        cliente2.setEmail("cliente1@gmail.com");
        cliente2.setNome("Cliente");
        cliente2.setCpf("12345678912");
        cliente2.setWishlist(wishlist3);

        Wishlist wishlist4 = new Wishlist();
        wishlist4.setCliente(cliente2);
        wishlist4.setListaProdutos(new ArrayList<Produto>());
        wishlist4.setIdWishlist(1L);

        Cliente cliente3 = new Cliente();
        cliente3.setIdCliente(1L);
        cliente3.setEmail("cliente1@gmail.com");
        cliente3.setNome("Cliente");
        cliente3.setCpf("12345678912");
        cliente3.setWishlist(wishlist4);
        Optional<Cliente> ofResult = Optional.<Cliente>of(cliente3);
        when(this.clienteRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(wishlist2, this.wishlistService.criaWishlistByCliente(1L));
        verify(this.clienteRepository).findById((Long) any());
        verify(this.wishlistRepository).save((Wishlist) any());
    }

    @Test
    public void getByIdClienteIdProdutoSuccess() {
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
        Optional<Wishlist> ofResult = Optional.<Wishlist>of(wishlist1);
        when(this.wishlistRepository.findByClienteIdCliente((Long) any())).thenReturn(ofResult);
        assertNull(this.wishlistService.getByIdClienteIdProduto(1L, 1L));
        verify(this.wishlistRepository).findByClienteIdCliente((Long) any());
    }

}

