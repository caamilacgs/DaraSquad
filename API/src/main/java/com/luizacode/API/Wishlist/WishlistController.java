package com.luizacode.API.Wishlist;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //Informa que é um controller
@RequestMapping(value = "api/wishlist") //Define nome para chamada
@CrossOrigin(origins = "*") //Define que qualquer origem pode acessar essa API
public class WishlistController {
    @Autowired
    WishlistRepository wishlistRepository; //Declara variável para uso nos endpointers

    @GetMapping("/{id}") //Define caminho para chamada
    @ApiOperation(value = "Lista os produtos da lista de desejos do cliente.") //Informa para Swagger a descrição do endpoint
    public List<Wishlist> listaWhislist(@PathVariable(value = "id") long id) {
        return this.wishlistRepository.findByidCliente(id);
    }

    @PostMapping("/add") //Define caminho para chamada
    @ApiOperation(value = "Adiciona produto na lista de desejos.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity<Wishlist> addProdutoWhislist(@RequestBody Wishlist wishlist) {
        return new ResponseEntity<Wishlist>(wishlistRepository.save(wishlist), HttpStatus.OK);
    }

    @DeleteMapping("/delete") //Define caminho para chamada
    @ApiOperation(value = "Remove um produto da lista de desejos do cliente.") //Informa para Swagger a descrição do endpoint
    public void deletaCliente(@RequestBody Wishlist wishlist) {
        wishlistRepository.delete(wishlist);
    }


}