package com.luizacode.API.Repository;

import com.luizacode.API.Entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository //Informa que se trata de um repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    public Optional<Wishlist> findByClienteIdCliente(Long idCliente);

    @Override
    Optional<Wishlist> findById(Long idWishlist);
}
