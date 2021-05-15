package br.com.luizacode.dara.darawishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.luizacode.dara.darawishlist.entity.Produto;
import br.com.luizacode.dara.darawishlist.service.ProdutoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/produto")
@Api(value="API REST Produto")
@CrossOrigin(origins= "*")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping(value = "/all")
	@ApiOperation(value= "Retorna uma Lista de Produto")
	public List<Produto> listarTodos() {
		return produtoService.listarTodos();
	}

	@PostMapping(value = "/add")
	@ApiOperation(value= "Salva um Produto")
	public Produto create(@RequestBody Produto produto) {
		return this.produtoService.cadastrar(produto);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value= "Retorna um Produto unico ")
	public Produto listarPorId(@PathVariable Long id) {
		return this.produtoService.buscaPorId(id);

	}

	@DeleteMapping(value = "/remove/{id}")
	@ApiOperation(value= "Deleta um Produto")
	public void delete(@PathVariable Long id) {
		this.produtoService.remover(id);
	}

	@PutMapping(value = "/update/{id}")
	@ApiOperation(value= "Atualiza a informacoes do Produto")
	public Produto atualizar(@RequestBody Produto produto, @PathVariable Long id) {
		return this.produtoService.atualizar(produto, id);
	}

}
