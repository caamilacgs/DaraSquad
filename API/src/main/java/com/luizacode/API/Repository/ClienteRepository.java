package com.luizacode.API.Repository;

import com.luizacode.API.Entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository //Informa que se trata de um repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Cliente> findByCpf(String cpf);
}
//A JpaRepository já tem diversos métodos que você pode utilizar quando essa interface extende dela;