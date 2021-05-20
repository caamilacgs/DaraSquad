package com.luizacode.API.services.cliente;

import com.luizacode.API.Entity.Cliente;
import com.luizacode.API.Repository.ClienteRepository;
import com.luizacode.API.Service.ClienteService;
import com.luizacode.API.builders.cliente.ClienteBuilder;
import com.luizacode.API.builders.produto.ProdutoBuilder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceUnitTesting {

    @InjectMocks
    private ClienteService clienteService; // oque será testado

    @Mock
    private ClienteRepository clienteRepository; // oque será mockado

    ClienteBuilder clienteBuilder = new ClienteBuilder();


//    @Test
//    @DisplayName("cadastraCliente - Sucesso")
//    public void cadastraClienteSuccess() {
//        Cliente cliente1 = clienteBuilder.criarClienteEntityComId();
//
//        Mockito.when(clienteRepository.save(cliente1)).thenReturn(cliente1);
//
//        Optional<Cliente> cliente = clienteService.cadastraCliente(cliente1);
//
//        Assertions.assertTrue(cliente.isPresent());
//    }

    @Test
    @DisplayName("cadastraCliente - Exception")
    public void cadastraClienteException() {
        Cliente cliente1 = clienteBuilder.criarClienteEntityComId();

        Mockito.when(clienteRepository.findByCpf("12345678912")).thenReturn(Optional.of(cliente1));
        Mockito.when(clienteRepository.save(Mockito.any())).thenThrow(RuntimeException.class);
    }

    @Test
    @DisplayName("buscaClientes - Sucesso")
    public void findAllClientesSuccess() {
        List<Cliente> clientes = clienteBuilder.criarListaClienteEntityComId();

        Mockito.when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> clienteList = clienteService.buscaClientes();

        Assertions.assertEquals(clienteList.size(), clientes.size());

        Assertions.assertEquals(clientes.get(0).getIdCliente(), clienteList.get(0).getIdCliente());
        Assertions.assertEquals(clientes.get(0).getNome(), clienteList.get(0).getNome());
        Assertions.assertEquals(clientes.get(0).getCpf(), clienteList.get(0).getCpf());
        Assertions.assertEquals(clientes.get(0).getEmail(), clienteList.get(0).getEmail());

        Assertions.assertEquals(clientes.get(1).getIdCliente(), clienteList.get(1).getIdCliente());
        Assertions.assertEquals(clientes.get(1).getNome(), clienteList.get(1).getNome());
        Assertions.assertEquals(clientes.get(1).getCpf(), clienteList.get(1).getCpf());
        Assertions.assertEquals(clientes.get(1).getEmail(), clienteList.get(1).getEmail());
    }

//    @Test
//    @DisplayName("atualizaCliente - Sucesso")
//    public void atualizaClienteSuccess() {
//        List<Cliente> clientes = clienteBuilder.criarListaClienteEntityComId();
//
//        Cliente cliente1 = clientes.get(0);
//        Cliente cliente2 = clientes.get(1);
//
//        Mockito.when(clienteRepository.save(cliente1)).thenReturn(cliente2);
//
//        Optional<Cliente> cliente = Optional.ofNullable(clienteService.atualizaCliente(cliente1));
//
//        Assertions.assertEquals(2L, cliente.get().getIdCliente());
//        Assertions.assertEquals("Cliente2", cliente.get().getNome());
//        Assertions.assertEquals("12345678989", cliente.get().getCpf());
//        Assertions.assertEquals("cliente2@gmail.com", cliente.get().getEmail());
//    }

//    @Test
//    @DisplayName("deletaCliente - Sucesso")
//    public void deletaClienteSuccess() {
//        Cliente cliente1 = clienteBuilder.criarClienteEntityComId();
//
//        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));
//
//        ResponseEntity<String> clienteResult = clienteService.deletaCliente(1L);
//
//        Mockito.verify(clienteRepository, Mockito.times(1)).deleteById(cliente1.getIdCliente());
//    }

//    @Test
//    @DisplayName("buscaUmCliente - Sucesso")
//    public void findClienteByIdSuccess() {
//        Cliente cliente1 = clienteBuilder.criarClienteEntityComId();
//
//        Mockito.when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente1));
//        Mockito.when(clienteService.buscaUmCliente(1L)).thenReturn(Optional.of(cliente1));
//
//        Optional<Cliente> clienteResult = clienteService.buscaUmCliente(1L);
//
//        Assertions.assertEquals(1L, clienteResult.get().getIdCliente());
//    }

}
