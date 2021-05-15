package br.com.luizacode.dara.darawishlist.service;

import java.util.List;

import br.com.luizacode.dara.darawishlist.entity.Cliente;

public interface ClienteService {

	List<Cliente> listarTodos();

	public Cliente buscaPorId(Long id);

	Cliente cadastrar(Cliente cliente);

	void remover(Long id);

	public Cliente atualizar(Cliente cliente, Long id);

}
