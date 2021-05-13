package com.dara.wishListDara.resources;

import com.dara.wishListDara.entities.Cliente;
import com.dara.wishListDara.entities.Produto;
import com.dara.wishListDara.services.ProdutoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
        List<Produto> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping("/create")
    public ResponseEntity<Produto> insert(@RequestBody Produto obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Integer id) {
        Produto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
