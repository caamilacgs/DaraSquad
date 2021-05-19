package com.luizacode.API.Service;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Repository.ProdutoRepository;
import com.luizacode.API.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity consultaProdutoWishlist(Long idCliente, Long idProduto) {
        Produto produtoExists = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
        if (produtoExists == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto NÃO esta nessa wishlist!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("O produto esta nessa wishlist!");
    }

    public ResponseEntity deletaProdutoWishlist(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlistCliente = wishlistRepository.findByClienteIdCliente(idCliente);
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        produto.get().getListaWishlist().remove(wishlistCliente.get());
        return new ResponseEntity<>(wishlistCliente.get(), HttpStatus.OK);
    }

    public Wishlist cadastraProdutoWishlist(Wishlist wishlist, Long idProduto) {
        Optional<Produto> produto = produtoRepository.findById(idProduto);
        produto.get().getListaWishlist().add(wishlist);
        wishlist.getListaProdutos().add(produto.get());
        return wishlist;
    }

    public ResponseEntity verificaWishlist(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlistCliente = wishlistRepository.findByClienteIdCliente(idCliente);
        if (wishlistCliente.isPresent()) {
            if (produtoService.produtoExiste(idProduto)) {
                if (wishlistCliente.get().getListaProdutos().size() < 20) {
                    if (wishlistService.getByIdClienteIdProduto(idCliente, idProduto) == null) {
                        return new ResponseEntity<>((cadastraProdutoWishlist(wishlistCliente.get(), idProduto)), HttpStatus.OK);
                    }
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto já foi adicionado anteriormente.");
                }
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existem 20 itens nessa lista!");
            }
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Esse produto não existe!");
        } else {
            if (clienteService.clienteExiste(idCliente)) {
                return new ResponseEntity<>(cadastraProdutoWishlist(criaWishlistByCliente(idCliente), idProduto), HttpStatus.OK);
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não existe.");
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





