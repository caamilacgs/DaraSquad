package com.luizacode.API.Service;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
import com.luizacode.API.Exceptions.WishlistException;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Repository.ProdutoRepository;
import com.luizacode.API.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;


@SuppressWarnings("rawtypes")
@Service
@Transactional
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    EntityManager entityManager;


    public Optional<Wishlist> listaWishlist(Long idCliente) {
        return wishlistRepository.findByClienteIdCliente(idCliente);
    }

    public Produto consultaProdutoWishlist(Long idCliente, Long idProduto) {
        Produto produtoExists = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
        if (produtoExists != null) {
            return produtoExists;
        }
        throw new ResourcesNotFoundException("Produto não encontrado!");
    }

    public Wishlist removeProdutoWishlist(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlistCliente = wishlistRepository.findByClienteIdCliente(idCliente);
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        produto.get().getListaWishlist().remove(wishlistCliente.get());
        return wishlistCliente.get();
    }

    public Wishlist cadastraProdutoWishlist(Wishlist wishlist, Long idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        produto.get().getListaWishlist().add(wishlist);
        wishlist.getListaProdutos().add(produto.get());
        return wishlist;
    }

    public Wishlist verificaWishlist(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlistCliente = wishlistRepository.findByClienteIdCliente(idCliente);
        if (wishlistCliente.isPresent()) {
            produtoService.verificaProdutoExiste(idProduto);
            if (wishlistCliente.get().getListaProdutos().size() < 20) {
                if (wishlistService.getByIdClienteIdProduto(idCliente, idProduto) == null) {
                    return (cadastraProdutoWishlist(wishlistCliente.get(), idProduto));
                }
                throw new WishlistException("O produto já foi adicionado anteriormente.");
            }
            throw new WishlistException("Já existem 20 itens nessa lista!");
        } else {
            clienteService.verificaClienteExiste(idCliente);
            return cadastraProdutoWishlist(criaWishlistByCliente(idCliente), idProduto);
        }
    }

    public Wishlist criaWishlistByCliente(Long idCliente) {
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);
        Wishlist wishlist = new Wishlist(cliente.get());
        return wishlistRepository.save(wishlist);
    }

    public Produto getByIdClienteIdProduto(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlist = wishlistRepository.findByClienteIdCliente(idCliente);
        return wishlist.get().getListaProdutos().stream().filter(Produto -> idProduto.equals(Produto.getIdProduto())).findAny().orElse(null);
    }
}





