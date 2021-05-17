package com.luizacode.API.Wishlist;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController //Informa que é um controller
@RequestMapping(value = "api/wishlist") //Define nome para chamada
@CrossOrigin(origins = "*") //Define que qualquer origem pode acessar essa API
public class WishlistController {
    @Autowired
    WishlistService wishlistService;

    @PostMapping("/{idCliente}/{idProduto}")
    @ApiOperation(value = "Adiciona produto na lista de desejos do cliente.")
    @ApiResponse(code = 200, message = "Produto adicionado a lista de desejos!")
    public ResponseEntity addProdutoWhislist(@PathVariable(value = "idCliente") Long idCliente, @PathVariable(value = "idProduto") Long idProduto) {
       return wishlistService.cadastraProdutoWishlist(idCliente, idProduto);
    }


//
//    @DeleteMapping("/{idCliente}/{idProduto}")
//    @ApiOperation(value = "Remove um produto da lista de desejos do cliente.")
//    @ApiResponse(code = 200, message = "Produto removido da lista de desejos!")
//    public ResponseEntity deletaCliente(@PathVariable(value = "idProduto") Long idProduto, @PathVariable(value = "idCliente") Long idCliente) {
//        return wishlistService.deletaProdutoWishlist(idCliente, Produto);
//    }
//
    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna a lista de desejos do cliente.")
    public Optional<Wishlist> listaWhislist(@PathVariable(value = "id") Long idCliente) {
        return wishlistService.listaWishlist(idCliente);
    }

    @GetMapping("/{idCliente}/{idProduto}")
    @ApiOperation(value = "Consulta se um produto está na lista de desejos do cliente.")
    public ResponseEntity consultaProduto(@PathVariable(value = "idProduto") Long idProduto, @PathVariable(value = "idCliente") Long idCliente) {
        return wishlistService.consultaProdutoWishlist(idCliente, idProduto);
    }
}