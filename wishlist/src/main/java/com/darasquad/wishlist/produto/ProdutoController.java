package com.darasquad.wishlist.produto;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/produtos")
public class ProdutoController {
	
	public List<Produto> getProduto(){
		
		Produto produto1 = new Produto(001L, "Geladeira", 1.500);
		Produto produto2 = new Produto(002L, "Sofa", 2.500);
		Produto produto3 = new Produto(003L, "Celular", 8.150);
		
		return Arrays.asList(produto1, produto2, produto3);
		
	}
}
