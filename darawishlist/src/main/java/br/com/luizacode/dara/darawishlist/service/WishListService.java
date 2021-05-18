package br.com.luizacode.dara.darawishlist.service;

import java.util.List;
import java.util.Optional;

import br.com.luizacode.dara.darawishlist.entity.Produto;
import br.com.luizacode.dara.darawishlist.entity.WishList;



public interface WishListService {
	
	List<WishList> listarTodos();

	public WishList buscaPorId(Long id);

	public WishList adicionarProdutoWishList(Long idWishListe, Long idProduto);

	//void remover(Long id);
	void removerProdutoDaWishList(Long idWishList, Long idProduto);
	
	public WishList salvar(WishList wishList);
	
	public Optional<Produto> consultarProdutoWishList(Long idWishList, Long idProduto);
	
	
	
}
