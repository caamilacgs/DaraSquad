package br.com.luizacode.dara.darawishlist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizacode.dara.darawishlist.entity.Produto;
import br.com.luizacode.dara.darawishlist.entity.WishList;
import br.com.luizacode.dara.darawishlist.service.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/wishList")
@Api(value = "API REST WishList")
@CrossOrigin(origins = "*")
public class WishListController {

	@Autowired
	private WishListService wishListService;

	@GetMapping()
	@ApiOperation(value = "Retorna uma Lista de WishList")
	public List<WishList> listarTodos() {
		return wishListService.listarTodos();
	}

	@PostMapping()
	@ApiOperation(value = "Salva um produto na WishList")
	public WishList adicionar(@RequestParam("idWishList") Long idWishList, @RequestParam("idProduto") Long idProduto) {
		return this.wishListService.adicionarProdutoWishList(idWishList, idProduto);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value = "Retorna um WishList unico ")
	public WishList listarPorId(@PathVariable Long id) {
		return this.wishListService.buscaPorId(id);

	}
	@DeleteMapping()
	@ApiOperation(value = "Deleta um WishList")
	public void removerProduto(@RequestParam("idWishList") Long idWishList, @RequestParam("idProduto") Long idProduto) {
		this.wishListService.removerProdutoDaWishList(idWishList, idProduto);
	}
	@GetMapping("/{idWishList}/{idProduto}")
	@ApiOperation(value ="Consultar se um produto estar na WishList do Cliente")
	public ResponseEntity<Boolean> buscaProdutoWishList(@PathVariable("idWishList") Long idWishList, @PathVariable("idProduto") Long idProduto) {
		Optional<Produto> produto = wishListService.consultarProdutoWishList(idWishList, idProduto);
		return produto.isPresent()? ResponseEntity.ok(true): ResponseEntity.notFound().build();
	}



}
