package br.com.luizacode.dara.darawishlist.service;

import java.util.List;



import br.com.luizacode.dara.darawishlist.entity.WishList;



public interface WishListService {
	
	List<WishList> listarTodos();

	public WishList buscaPorId(Long id);

	WishList cadastrar(WishList wishlist);

	void remover(Long id);

	
	
	
}
