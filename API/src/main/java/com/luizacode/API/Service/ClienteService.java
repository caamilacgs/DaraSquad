package com.luizacode.API.Service;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private WishlistRepository wishlistRepository;

    public Object cadastraCliente(Cliente cliente) {
        Optional<Cliente> cpfExistente = clienteRepository.findByCpf(cliente.getCpf());
        if (cpfExistente.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CPF já cadastrado!");
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> buscaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Object deletaCliente(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado!");
    }

    public Object buscaUmCliente(Long id) {
        if (clienteExiste(id)) {
            return clienteRepository.findById(id);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não existe.");
    }

    public boolean clienteExiste(Long id) {
        return clienteRepository.findById(id).isPresent();
    }
}
