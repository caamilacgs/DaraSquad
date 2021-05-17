package com.luizacode.API.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public ResponseEntity cadastraProduto(Produto produto){
        produtoRepository.save(produto);
        return ResponseEntity.status(HttpStatus.OK).body("Produto cadastrado!");
    }

    public List<Produto> buscaProdutos() {
        return produtoRepository.findAll();
    }

    public Produto atualizaProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public ResponseEntity<String> deletaProduto(Long id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado!");
    }

    public Optional buscaUmProduto(Long id) {
        return produtoRepository.findById(id);
    }
}
