package com.darawishlist.dara.produto;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("v1/api/produtos")
public class ProdutoController {

    @GetMapping()
    public List<Produto> getProduto() {

        Produto produto1 = new Produto("Geladeira", 1.500, 12376L);
        Produto produto2 = new Produto("Sofa", 2.500, 1232L);
        Produto produto3 = new Produto("Celular", 8.500, 12345L);

        return Arrays.asList(produto1, produto2, produto3);
    }

}
