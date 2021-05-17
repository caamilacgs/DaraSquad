package com.luizacode.API.Cliente;

import com.luizacode.API.Wishlist.Wishlist;
import com.luizacode.API.Wishlist.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private WishlistRepository wishlistRepository;

    public Optional<Cliente> cadastraCliente(Cliente cliente) {
        Optional<Cliente> cpfExistente = clienteRepository.findByCpf(cliente.getCpf());
        if (cpfExistente.isPresent()) {
            return Optional.empty();
        }
        return Optional.ofNullable(clienteRepository.save(cliente));
    }

    public List<Cliente> buscaClientes() {
        return clienteRepository.findAll();
    }

    public Cliente atualizaCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public ResponseEntity<String> deletaCliente(Long id) {
        clienteRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado!");
    }

    public Optional buscaUmCliente(Long id) {
        return clienteRepository.findById(id);
    }
}
