package com.luizacode.API.Wishlist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository //Informa que se trata de um repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    List<Wishlist> findByidCliente(Long idCliente); //Cria novo método que não existe na JpaRepository para criar lista de Wishlist a partir do ID do Cliente;
}

//A JpaRepository já tem diversos métodos que você pode utilizar quando essa interface extende dela;