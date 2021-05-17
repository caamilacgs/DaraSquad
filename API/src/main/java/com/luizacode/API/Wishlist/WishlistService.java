package com.luizacode.API.Wishlist;

import com.luizacode.API.Cliente.Cliente;
import com.luizacode.API.Cliente.ClienteRepository;
import com.luizacode.API.Produto.Produto;
import com.luizacode.API.Produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Optional;


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
    private ProdutoRepository produtoRepository;
    @Autowired
    EntityManager entityManager;


    public Optional<Wishlist> listaWishlist(Long idCliente) {
        return wishlistRepository.findByClienteIdCliente(idCliente);   //acha id wishlist
    }

    public ResponseEntity consultaProdutoWishlist(Long idCliente, Long idProduto) {
        Produto produtoExists = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
        if (produtoExists == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto NÃO esta nessa wishlist!");
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("O produto esta nessa wishlist!");
        }
    }

    public Produto getByIdClienteIdProduto(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlist = wishlistRepository.findByClienteIdCliente(idCliente);
        Produto produtoExists = wishlist.get().getListaProdutos().stream().filter(Produto -> idProduto.equals(Produto.getIdProduto())).findAny().orElse(null);
        return produtoExists;
    }

    public ResponseEntity cadastraProdutoWishlist(Long idCliente, Long idProduto) {
        Optional<Wishlist> wishlistCliente = wishlistRepository.findByClienteIdCliente(idCliente);
        if (wishlistCliente.isPresent()) {
            if (wishlistCliente.get().getListaProdutos().size() < 20) {
                Produto produtoExists = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
                if (produtoExists == null) {
                    Optional<Produto> produto = produtoRepository.findById(idProduto);
                    produto.get().getListaWishlist().add(wishlistCliente.get());
                    wishlistCliente.get().getListaProdutos().add(produto.get());
                    return new ResponseEntity<Wishlist>(wishlistCliente.get(), HttpStatus.OK);
                } else {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto já foi adicionado anteriormente.");
                }
            } else {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existem 20 itens nessa lista!");
            }
        } else {
            Optional<Cliente> cliente = clienteRepository.findById(idCliente);
            if (cliente.isPresent()) {
                Wishlist wishlist = new Wishlist(cliente.get());
                Wishlist wishlistNova = wishlistRepository.save(wishlist);
                Produto produto = entityManager.find(Produto.class, idProduto);
                produto.getListaWishlist().add(wishlistNova);
                wishlistNova.getListaProdutos().add(produto);
                return new ResponseEntity<Wishlist>(wishlistNova, HttpStatus.OK);
            } else
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente não existe.");
        }
    }

}




