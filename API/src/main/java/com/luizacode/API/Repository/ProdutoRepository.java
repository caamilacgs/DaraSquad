package com.luizacode.API.Repository;

import com.luizacode.API.Entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Informa que se trata de um repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findById(long id); //Cria novo método que não existe na JpaRepository para encontrar Produto através do ID;
}

//A JpaRepository já tem diversos métodos que você pode utilizar quando essa interface extende dela;
