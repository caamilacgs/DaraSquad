package com.dara.wishListDara.services;

import com.dara.wishListDara.entities.Cliente;
import com.dara.wishListDara.repositories.ClienteRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@RunWith(MockitoJUnitRunner.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteServiceImpl clienteService; // oque vai ser testado

    @Mock
    private ClienteRepository clienteRepository; // oque vai ser mockado

    @Test
    @DisplayName("getAll - Clientes")
    public void getAllClientesSucesso() {
        // preparação
        Mockito.when(clienteRepository.findAll()).thenReturn(Arrays.asList(
                new Cliente(1, "Taiane", "taiane@gmail.com", "Cabula VI", "11111111111"),
                new Cliente(2, "Matheus", "matheus@gmail.com", "Cabula VI", "22222222222")
        ));

        // ação
        List<Cliente> clienteList = clienteService.findAll();

        Assertions.assertEquals(1, clienteList.get(0).getId());
        Assertions.assertEquals("Taiane", clienteList.get(0).getNome());
        Assertions.assertEquals("taiane@gmail.com", clienteList.get(0).getEmail());
        Assertions.assertEquals("Cabula VI", clienteList.get(0).getEndereco());
        Assertions.assertEquals("11111111111", clienteList.get(0).getCpf());

        Assertions.assertEquals(2, clienteList.get(1).getId());
        Assertions.assertEquals("Matheus", clienteList.get(1).getNome());
        Assertions.assertEquals("matheus@gmail.com", clienteList.get(1).getEmail());
        Assertions.assertEquals("Cabula VI", clienteList.get(1).getEndereco());
        Assertions.assertEquals("22222222222", clienteList.get(1).getCpf());

    }

    @Test
    @DisplayName("getAllTamanhoLista - Clientes")
    public void getAllClientesTamanhoListaSucesso() {
        // preparação
        Mockito.when(clienteRepository.findAll()).thenReturn(Arrays.asList(
                new Cliente(1, "Taiane", "taiane@gmail.com", "Cabula VI", "11111111111"),
                new Cliente(2, "Matheus", "matheus@gmail.com", "Cabula VI", "22222222222")
        ));

        // ação
        List<Cliente> clienteList = clienteService.findAll();

        Assertions.assertEquals(2, clienteList.size());
    }

    @Test
    @DisplayName("findById - Clientes")
    public void findClienteByIdSucesso() {
        // preparação
        Mockito.when(clienteRepository.findById(1)).thenReturn(
                Optional.of(new Cliente(1, "Taiane", "taiane@gmail.com", "Cabula VI", "11111111111"))
        );

        // ação
        Cliente cliente = clienteService.findById(1);

        Assertions.assertEquals(1, cliente.getId());
    }

    @Test
    @DisplayName("findById - Clientes - Não encontrado")
    public void findClienteByIdErro() {
        // ação
        Optional<Cliente> cliente = clienteRepository.findById(10);

        Assertions.assertFalse(cliente.isPresent());
    }

}
