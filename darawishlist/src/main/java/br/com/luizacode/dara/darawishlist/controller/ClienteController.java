package br.com.luizacode.dara.darawishlist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.luizacode.dara.darawishlist.entity.Cliente;
import br.com.luizacode.dara.darawishlist.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/cliente")
@Api(value="API REST Cliente")
@CrossOrigin(origins= "*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/all")
	@ApiOperation(value= "Retorna uma Lista de Cliente")
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}

	@PostMapping(value = "/add")
	@ApiOperation(value= "Salva um Cliente")
	public ResponseEntity<Cliente> create(@RequestBody Cliente cliente) {
		try {
			return new ResponseEntity<>((Cliente) clienteService.cadastrar(cliente), HttpStatus.CREATED);
		}catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}

	@GetMapping(value = "/{id}")
	@ApiOperation(value= "Retorna um Cliente unico ")
	public ResponseEntity<Cliente> listarPorId(@PathVariable Long id) {
		try {
			return new ResponseEntity<>((Cliente) clienteService.buscaPorId(id), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		

	}

	@DeleteMapping(value = "/remove/{id}")
	@ApiOperation(value= "Deleta um Cliente")
	public void delete(@PathVariable Long id) {
		this.clienteService.remover(id);
	}

	@PutMapping(value = "/update/{id}")
	@ApiOperation(value= "Atualiza a informacoes do Cliente")
	public Cliente atualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
		return this.clienteService.atualizar(cliente, id);
	}

}
