package com.luizacode.API.builders.cliente;

import com.luizacode.API.Entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteBuilder {

    private static final Long DEFAULT_ID_1 = (1L);
    private static final String DEFAULT_NOME_1 = "Cliente1";
    private static final String DEFAULT_CPF_1 = "12345678912";
    private static final String DEFAULT_EMAIL_1 = "cliente1@gmail.com";

    private static final Long DEFAULT_ID_2 = (2L);
    private static final String DEFAULT_NOME_2 = "Cliente2";
    private static final String DEFAULT_CPF_2 = "12345678989";
    private static final String DEFAULT_EMAIL_2 = "cliente2@gmail.com";


    public Cliente criarClienteEntityComId() {
        Cliente cliente1 = new Cliente();

        cliente1.setIdCliente(DEFAULT_ID_1);
        cliente1.setNome(DEFAULT_NOME_1);
        cliente1.setCpf(DEFAULT_CPF_1);
        cliente1.setEmail(DEFAULT_EMAIL_1);

        return cliente1;
    }

    public List<Cliente> criarListaClienteEntityComId() {

        List<Cliente> listaClientes = new ArrayList<>();

        Cliente cliente1 = new Cliente();

        cliente1.setIdCliente(DEFAULT_ID_1);
        cliente1.setNome(DEFAULT_NOME_1);
        cliente1.setCpf(DEFAULT_CPF_1);
        cliente1.setEmail(DEFAULT_EMAIL_1);

        Cliente cliente2 = new Cliente();

        cliente2.setIdCliente(DEFAULT_ID_2);
        cliente2.setNome(DEFAULT_NOME_2);
        cliente2.setCpf(DEFAULT_CPF_2);
        cliente2.setEmail(DEFAULT_EMAIL_2);

        listaClientes.add(cliente1);
        listaClientes.add(cliente2);

        return listaClientes;
    }
}
