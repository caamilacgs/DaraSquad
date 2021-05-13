package com.dara.wishListDara.repositories;

import com.dara.wishListDara.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
