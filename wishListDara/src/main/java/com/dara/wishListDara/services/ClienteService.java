package com.dara.wishListDara.services;

import com.dara.wishListDara.entities.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();

    Cliente insert(Cliente obj);

    Cliente findById(Integer id);

    Cliente delete(Integer id);
}
