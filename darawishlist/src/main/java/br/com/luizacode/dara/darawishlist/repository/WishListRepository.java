package br.com.luizacode.dara.darawishlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.luizacode.dara.darawishlist.entity.WishList;

public interface WishListRepository extends JpaRepository<WishList, Long>{

}
