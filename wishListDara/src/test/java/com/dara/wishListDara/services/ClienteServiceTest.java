package com.dara.wishListDara.services;

import com.dara.wishListDara.builder.ClienteBuilder;
import com.dara.wishListDara.entities.Cliente;
import com.dara.wishListDara.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteServiceImpl clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    ClienteBuilder clienteBuilder = new ClienteBuilder();


    @Test
    @DisplayName("Criar cliente")
    public void criarClienteSucesso() {
        Cliente cliente = clienteBuilder.criarClienteEntityComId();

        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente clienteBanco = clienteService.insert(cliente);

        Assertions.assertEquals(cliente.getNome(), clienteBanco.getNome());
    }


}
