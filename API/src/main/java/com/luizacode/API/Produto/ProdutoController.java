package com.luizacode.API.Produto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Informa que é um controller
@RequestMapping(value = "api/produto") //Define nome para chamada
@CrossOrigin(origins = "*") ///Define que qualquer origem pode acessar essa API
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository; //Declara variável para uso nos endpointers

    @GetMapping("/listar") //Define caminho para chamada
    @ApiOperation(value = "Retorna lista de produtos cadastrados.") //Informa para Swagger a descrição do endpoint
    public List<Produto> listaProduto() {
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}") //Define caminho para chamada
    @ApiOperation(value = "Retorna um produto específico através id.") //Informa para Swagger a descrição do endpoint
    public Produto listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoRepository.findById(id);
    }

    @PostMapping("/add") //Define caminho para chamada
    @ApiOperation(value = "Cadastra um produto.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity<Produto> cadastraProduto(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(produtoRepository.save(produto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete") //Define caminho para chamada
    @ApiOperation(value = "Deleta um produto cadastrado.") //Informa para Swagger a descrição do endpoint
    public void deletaProduto(@RequestBody Produto produto) {
        produtoRepository.delete(produto);
    }

    @PutMapping("/produto") //Define caminho para chamada
    @ApiOperation(value = "Atualiza informações de um produto.") //Informa para Swagger a descrição do endpoint
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}
