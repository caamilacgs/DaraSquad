package com.luizacode.API.Cliente;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Informa que é um controller
@RequestMapping(value = "api/cliente") //Define nome para chamada
@CrossOrigin (origins = "*") //Define que qualquer origem pode acessar essa API
public class ClienteController {
    @Autowired
    ClienteRepository clienteRepository; //Declara variável para uso nos endpointers

    @GetMapping("/listar") //Define caminho para chamada
    @ApiOperation(value = "Retorna lista de clientes cadastrados.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity <List<Cliente>> listaCliente(){
        return ResponseEntity.ok(clienteRepository.findAll());
    }

    @GetMapping("/{id}") //Define caminho para chamada
    @ApiOperation(value = "Retorna um produto específico através do id.") //Informa para Swagger a descrição do endpoint
    public Cliente listaClienteUnico(@PathVariable(value = "id") long id) {
        return clienteRepository.findById(id);
    }

    @PostMapping("/add") //Define caminho para chamada
    @ApiOperation(value = "Cadastra um cliente.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity <Cliente> cadastraCliente(@RequestBody Cliente cliente ){
            return new ResponseEntity<Cliente> (clienteRepository.save(cliente),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete") //Define caminho para chamada
    @ApiOperation(value = "Deleta um cliente cadastrado.") //Informa para Swagger a descrição do endpoint
    public void deletaCliente(@RequestBody Cliente cliente){
        clienteRepository.delete(cliente);
    }

    @PutMapping("/att") //Define caminho para chamada
    @ApiOperation(value = "Atualiza informações de um cliente.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Cliente> (clienteRepository.save(cliente),HttpStatus.OK);
    }
}
