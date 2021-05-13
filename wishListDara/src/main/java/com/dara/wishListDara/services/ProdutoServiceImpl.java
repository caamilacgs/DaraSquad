package com.dara.wishListDara.services;

import com.dara.wishListDara.entities.Produto;
import com.dara.wishListDara.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> findAll() {
        return repository.findAll();
    }

    public Produto insert(Produto obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    @Override
    public Produto findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Produto delete(Integer id) {
        Produto produto = null;
        Optional optional = repository.findById(id);
        if(optional.isPresent()) {
            produto = repository.findById(id).get();
            repository.deleteById(id);
        }
        return produto;
    }

}
