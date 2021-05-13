package com.dara.wishListDara.services;

import com.dara.wishListDara.entities.Cliente;
import com.dara.wishListDara.entities.Produto;
import com.dara.wishListDara.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<Cliente> findAll() {
        return repository.findAll();
    }

    public Cliente insert(Cliente obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    @Override
    public Cliente findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Cliente delete(Integer id) {
        Cliente cliente = null;
        Optional optional = repository.findById(id);
        if(optional.isPresent()) {
            cliente = repository.findById(id).get();
            repository.deleteById(id);
        }
        return cliente;
    }
}
