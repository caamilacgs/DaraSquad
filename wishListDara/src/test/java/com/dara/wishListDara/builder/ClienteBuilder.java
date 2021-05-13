package com.dara.wishListDara.builder;

import com.dara.wishListDara.dto.ClienteDTO;
import com.dara.wishListDara.entities.Cliente;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClienteBuilder {

    private static final Integer DEFAULT_ID_1 = (1);
    private static final String DEFAULT_NOME_1 = "Teste1'";
    private static final String DEFAULT_EMAIL_1 = "teste1@gmail.com";
    private static final String DEFAULT_ENDERECO_1 = "endereco1";
    private static final String DEFAULT_CPF_1 = "12345678912";

    private static final Integer DEFAULT_ID_2 = (22);
    private static final String DEFAULT_NOME_2 = "Teste2'";
    private static final String DEFAULT_EMAIL_2 = "teste2@gmail.com";
    private static final String DEFAULT_ENDERECO_2 = "endereco2";
    private static final String DEFAULT_CPF_2 = "12345678934";

    public Cliente criarClienteEntityComId() {
        Cliente cliente1 = new Cliente();

        cliente1.setId(DEFAULT_ID_1);
        cliente1.setNome(DEFAULT_NOME_1);
        cliente1.setEmail(DEFAULT_EMAIL_1);
        cliente1.setEndereco(DEFAULT_ENDERECO_1);
        cliente1.setCpf(DEFAULT_CPF_1);

        return cliente1;
    }

    public List<Cliente> criarListaClienteEntityComId() {

        List<Cliente> listaClientes = new ArrayList<>();

        Cliente cliente1 = new Cliente();

        cliente1.setId(DEFAULT_ID_1);
        cliente1.setNome(DEFAULT_NOME_1);
        cliente1.setEmail(DEFAULT_EMAIL_1);
        cliente1.setEndereco(DEFAULT_ENDERECO_1);
        cliente1.setCpf(DEFAULT_CPF_1);

        Cliente cliente2 = new Cliente();

        cliente2.setId(DEFAULT_ID_2);
        cliente2.setNome(DEFAULT_NOME_2);
        cliente2.setEmail(DEFAULT_EMAIL_2);
        cliente2.setEndereco(DEFAULT_ENDERECO_2);
        cliente2.setCpf(DEFAULT_CPF_2);

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        return listaClientes;
    }

}
