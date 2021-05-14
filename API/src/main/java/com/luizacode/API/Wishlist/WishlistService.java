package com.luizacode.API.Wishlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class WishlistService {
    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private WishlistService wishlistService;
    @Autowired
    EntityManager entityManager;

    public Wishlist cadastraProdutoWishlist(Wishlist wishlist){
        return wishlistRepository.save(wishlist);
    }

    public void deletaProdutoWishlis(Long idCliente, Long idProduto){
       Wishlist wishlistApagada = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
        wishlistRepository.deleteById(wishlistApagada.getIdWishlist());
    }

    public List <Wishlist> listaWishlist(Long id){
        return wishlistRepository.findByidCliente(id);
    }

    public ResponseEntity consultaProdutoWishlist(Long idCliente, Long idProduto){
        Wishlist produtoExiste = wishlistService.getByIdClienteIdProduto(idCliente, idProduto);
        if (produtoExiste == null ) {                                                       //se a consulta retorna null, o produto não está na lista
            return ResponseEntity.status(HttpStatus.CONFLICT).body("O produto não consta nessa wishlist!");
        } else {                                                                            //se a consulta retorna algum registro do produto na lista é pq ele consta na lista desse usuário
            return ResponseEntity.status(HttpStatus.OK).body("O produto consta nessa wishlist!");
        }
    }

    public Wishlist getByIdClienteIdProduto(Long idCliente, Long idProduto) {
        List <Predicate> predicates = new ArrayList<>();   //cria lista para inserir condições de pesquisa para a query
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Wishlist> criteria = builder.createQuery(Wishlist.class);
        Root<Wishlist> root = criteria.from(Wishlist.class);
        criteria.select(root);
        predicates.add(builder.equal(root.get("idCliente"), idCliente));           //cria condição com id do cliente e passa para a lista
        predicates.add(builder.equal(root.get("idProduto"), idProduto));           //cria condição com id do produto e passa para a lista
        criteria.where(predicates.toArray(predicates.toArray(new Predicate[0]))); //passa o array como parametro de condições pro where/query
        List <Wishlist> wishlistConsultada = entityManager.createQuery(criteria).getResultList(); //coloca o resultado numa lista chamada whislistConsultada
        if (wishlistConsultada  == null || wishlistConsultada .isEmpty()){         //if para retornar valor comparável com null, por causa da consulta
            return null;                                                          // se null ou se vazia, retorna null
        } return wishlistConsultada .get(0);                                      // se não estiver vazia, retorna o primeiro registro da lista, que é o resultado da query de consulta
    }


}
