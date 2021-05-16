package com.darawishlist.dara.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/api/produtos")

public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping(value = "v1/api/")
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping(value = "v1/api/{id}")
    public Produto buscarId(@PathVariable Integer id) {
        return this.produtoService.buscarId(id);
    }

    @PostMapping(value = "v1/api/")
    public Produto create(@RequestBody Produto produto) {
        return this.produtoService.cadastrar(produto);
    }

    @DeleteMapping(value = "v1/api/{id}")
    public void delete(@PathVariable Integer id) {
        this.produtoService.remover(id);
    }

    @PutMapping(value = "v1/api/{id}")
    public Produto atualizar(@RequestBody Produto produto, @PathVariable Integer id) {
        return this.produtoService.atualizar(produto, id);
    }

}
