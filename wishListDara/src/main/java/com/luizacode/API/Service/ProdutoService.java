package com.luizacode.API.Service;

import com.luizacode.API.Entity.Produto;
import com.luizacode.API.Exceptions.ResourcesNotFoundException;
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
        verificaProdutoExiste(produto.getIdProduto());
        return produtoRepository.save(produto);
    }

    public ResponseEntity<String> deletaProduto(Long id) {
        verificaProdutoExiste(id);
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado!");
    }

    public Produto buscaUmProduto(Long id) {
        verificaProdutoExiste(id);
        return produtoRepository.findById(id).get();
    }

    public void verificaProdutoExiste(Long id) {
        if (produtoRepository.findById(id).isEmpty())
            throw new ResourcesNotFoundException("Produto não encontrado para o ID:" + id);
    }
}


