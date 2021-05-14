package com.luizacode.API.Cliente;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //Informa que é um controller
@RequestMapping(value = "api/cliente") //Define nome para chamada
@CrossOrigin(origins = "*") //Define que qualquer origem pode acessar essa API
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @PostMapping("/add") //Define caminho para chamada
    @ApiOperation(value = "Cadastra um cliente.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity cadastraCliente(@RequestBody Cliente cliente) {
        Optional<Cliente> existente = clienteService.cadastraCliente(cliente);
        if (existente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(existente.get());
    }

    @DeleteMapping("/delete/{id}") //Define caminho para chamada
    @ApiOperation(value = "Deleta um cliente cadastrado.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Cliente deletado!")
    public void deletaCliente(@PathVariable(value = "id") Long id) {
        clienteService.deletaCliente(id);
    }

    @PutMapping("/att") //Define caminho para chamada
    @ApiOperation(value = "Atualiza informações de um cliente.") //Informa para Swagger a descrição do endpoint
    @ApiResponse(code = 200, message = "Cliente atualizado!")
    public ResponseEntity<Cliente> atualizaCliente(@RequestBody Cliente cliente) {
        return new ResponseEntity<Cliente>(clienteService.atualizaCliente(cliente), HttpStatus.OK);
    }

    @GetMapping("/listar") //Define caminho para chamada
    @ApiOperation(value = "Retorna lista de clientes cadastrados.") //Informa para Swagger a descrição do endpoint
    public ResponseEntity<List<Cliente>> listaCliente() {
        return ResponseEntity.ok(clienteService.buscaClientes());
    }

    @GetMapping("/{id}") //Define caminho para chamada
    @ApiOperation(value = "Retorna um produto específico através do id.") //Informa para Swagger a descrição do endpoint
    public Optional listaClienteUnico(@PathVariable(value = "id") long id) {
        return clienteService.buscaUmCliente(id);
    }

}
