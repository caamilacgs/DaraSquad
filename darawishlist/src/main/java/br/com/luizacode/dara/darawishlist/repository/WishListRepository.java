package br.com.luizacode.dara.darawishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luizacode.dara.darawishlist.entity.WishList;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Long>{
	
	
	

}
