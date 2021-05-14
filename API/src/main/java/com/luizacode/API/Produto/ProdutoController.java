package com.luizacode.API.Produto;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Informa que é um controller
@RequestMapping(value = "api/produto") //Define nome para chamada
@CrossOrigin(origins = "*") ///Define que qualquer origem pode acessar essa API
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @PostMapping("/add") //Define caminho para chamada
    @ApiOperation(value = "Cadastra um produto.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Produto cadastrado!")
    public ResponseEntity<Produto> cadastraProduto(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(produtoService.cadastraProduto(produto), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}") //Define caminho para chamada
    @ApiOperation(value = "Deleta um produto cadastrado.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Produto deletado!")
    public void deletaProduto(@PathVariable(value = "id") Long id) {
        produtoService.deletaProduto(id);
    }

    @PutMapping("/att") //Define caminho para chamada
    @ApiOperation(value = "Atualiza informações de um produto.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Produto atualizado!")
    public Produto atualizaProduto(@RequestBody Produto produto) {
        return produtoService.atualizaProduto(produto);
    }

    @GetMapping("/listar") //Define caminho para chamada
    @ApiOperation(value = "Retorna lista de produtos cadastrados.") //Informa para Swagger a descrição do endpoint
    public List<Produto> listaProduto() {
        return produtoService.buscaProdutos();
    }

    @GetMapping("/{id}") //Define caminho para chamada
    @ApiOperation(value = "Retorna um produto específico através id.") //Informa para Swagger a descrição do endpoint
    public Optional listaProdutoUnico(@PathVariable(value = "id") long id) {
        return produtoService.buscaUmProduto(id);
    }

}
