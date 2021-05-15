package br.com.luizacode.dara.darawishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.luizacode.dara.darawishlist.entity.WishList;

import br.com.luizacode.dara.darawishlist.service.WishListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/wishList")
@Api(value="API REST WishList")
@CrossOrigin(origins= "*")
public class WishListController {
	
	@Autowired
	WishListService wishListService;

	@GetMapping(value = "/all")
	@ApiOperation(value= "Retorna uma Lista de WishList")
	public List<WishList> listarTodos() {
		return wishListService.listarTodos();
	}

	@PostMapping(value = "/add")
	@ApiOperation(value= "Salva um produto na WishList")
	public WishList create(@RequestBody WishList wishList) {
		return this.wishListService.cadastrar(wishList);
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value= "Retorna um WishList unico ")
	public WishList listarPorId(@PathVariable Long id) {
		return this.wishListService.buscaPorId(id);

	}

	@DeleteMapping(value = "/remove/{id}")
	@ApiOperation(value= "Deleta um WishList")
	public void delete(@PathVariable Long id) {
		this.wishListService.remover(id);
	}

	

}
