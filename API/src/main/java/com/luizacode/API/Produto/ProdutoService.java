package com.luizacode.API.Produto;

import com.luizacode.API.Cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto cadastraProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> buscaProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void deletaProduto(Long id) {
        produtoRepository.deleteById(id);
    }

    public Optional buscaUmProduto(Long id) {
        return produtoRepository.findById(id);

    }
}
