package com.luizacode.API.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;


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

    public void deletaCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    public Optional buscaUmCliente(Long id) {
        return clienteRepository.findById(id);
    }
}
