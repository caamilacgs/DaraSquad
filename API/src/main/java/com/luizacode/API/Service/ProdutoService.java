package com.luizacode.API.Service;

import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public Produto cadastraProduto(Produto produto) {
        return produtoRepository.save(produto);
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

    public Object buscaUmProduto(Long id) {
        if (produtoExiste(id)) {
            return produtoRepository.findById(id);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não existe.");
    }

    public boolean produtoExiste(Long id) {
        return produtoRepository.findById(id).isPresent();
    }
}
