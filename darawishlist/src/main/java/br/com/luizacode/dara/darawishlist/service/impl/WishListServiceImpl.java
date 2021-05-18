package br.com.luizacode.dara.darawishlist.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizacode.dara.darawishlist.entity.Produto;
import br.com.luizacode.dara.darawishlist.entity.WishList;
import br.com.luizacode.dara.darawishlist.exceptions.ProdutoInexistenteException;
import br.com.luizacode.dara.darawishlist.exceptions.WishListInexistenteException;
import br.com.luizacode.dara.darawishlist.repository.WishListRepository;
import br.com.luizacode.dara.darawishlist.service.ProdutoService;
import br.com.luizacode.dara.darawishlist.service.WishListService;

@Service
public class WishListServiceImpl implements WishListService {

	@Autowired
	private WishListRepository wishListRepository;

	@Autowired
	private ProdutoService produtoService;

	@Override
	public List<WishList> listarTodos() {
		return this.wishListRepository.findAll();
	}

	@Override
	public WishList buscaPorId(Long id) {
		return wishListRepository.findById(id).orElse(null);
	}

	@Override
	public WishList adicionarProdutoWishList(Long idWishListe, Long idProduto) {

		WishList wishListCliente = this.buscaPorId(idWishListe);
		if (wishListCliente != null && wishListCliente.getProduto().size() <= 20) {
			Produto produto = produtoService.buscaPorId(idProduto);

			wishListCliente.getProduto().add(produto);
			return wishListRepository.save(wishListCliente);
		}
		return null;
	}

	@Override
	public WishList salvar(WishList wishList) {
		return wishListRepository.save(wishList);
	}

	@Override
	public void removerProdutoDaWishList(Long idWishList, Long idProduto) {

		WishList wishListExistente = this.buscaPorId(idWishList);
		Produto produtoExistente = produtoService.buscaPorId(idProduto);

		if (wishListExistente.getProduto().contains(produtoExistente)) {
			wishListExistente.getProduto().remove(produtoExistente);
			wishListRepository.save(wishListExistente);

		} else
			System.out.println("Produto nao cadastrado");

	}

	@Override
	public Optional<Produto> consultarProdutoWishList(Long idWishList, Long idProduto) {
		
		WishList wishListExistente = this.buscaPorId(idWishList);
		Produto produtoExistente = produtoService.buscaPorId(idProduto);
		if(produtoExistente == null) {
			throw new ProdutoInexistenteException("Produto Nao encontrado");
		}
		if(wishListExistente == null) {
			throw new WishListInexistenteException("WishList Nao encontrado");
		}
		List <Produto> produtos= wishListExistente.getProduto().stream().filter(item->item.getId() == idProduto).collect(Collectors.toList());
		if(produtos.size() == 0) {
			return Optional.empty();
		}
		
		return Optional.of(produtos.get(0));
		
		
		
		
	}

}
