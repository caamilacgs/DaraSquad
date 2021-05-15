package br.com.luizacode.dara.darawishlist.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizacode.dara.darawishlist.entity.Produto;
import br.com.luizacode.dara.darawishlist.entity.WishList;
import br.com.luizacode.dara.darawishlist.repository.WishListRepository;
import br.com.luizacode.dara.darawishlist.service.WishListService;

@Service
public class WishListServiceImpl implements WishListService  {

	@Autowired
	private WishListRepository wishListRepository;
	
	@Override
	public List<WishList> listarTodos() {
		return this.wishListRepository.findAll();
	}

	@Override
	public WishList buscaPorId(Long id) {
		return wishListRepository.findById(id).orElse(new WishList());	
	}
	
//	@Override
//	public WishList cadastrar(WishList wishList){
//		List<Produto> listprodutos= new ArrayList<Produto>();
//		listprodutos = 
//		
//	}
		


	@Override
	public WishList cadastrar(WishList wishList) {
		
		return this.wishListRepository.save(wishList);

	}

	@Override
	public void remover(Long id) {
		this.wishListRepository.deleteById(id);
	}

	
}
