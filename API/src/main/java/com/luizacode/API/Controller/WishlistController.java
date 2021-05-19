package com.luizacode.API.Controller;

import com.luizacode.API.Entity.Wishlist;
import com.luizacode.API.Service.WishlistService;
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
    public ResponseEntity adicionaProdutoWhislist(@PathVariable(value = "idCliente") Long idCliente, @PathVariable(value = "idProduto") Long idProduto) {
       return wishlistService.verificaWishlist(idCliente, idProduto);
    }

    @DeleteMapping("delete/{idCliente}/{idProduto}")
    @ApiOperation(value = "Remove produto na lista de desejos do cliente.")
    public ResponseEntity removeProdutoWishlist(@PathVariable(value = "idCliente") Long idCliente, @PathVariable(value = "idProduto") Long idProduto) {
        return wishlistService.deletaProdutoWishlist(idCliente, idProduto);
    }

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