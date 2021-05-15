package br.com.luizacode.dara.darawishlist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizacode.dara.darawishlist.entity.Cliente;
import br.com.luizacode.dara.darawishlist.repository.ClienteRepository;
import br.com.luizacode.dara.darawishlist.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodos() {
		return this.clienteRepository.findAll();
	}

	@Override
	public Cliente buscaPorId(Long id) {
		return clienteRepository.findById(id).orElse(new Cliente());
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		return this.clienteRepository.save(cliente);

	}

	@Override
	public void remover(Long id) {
		this.clienteRepository.deleteById(id);
	}

	@Override
	public Cliente atualizar(Cliente cliente, Long id) {
		Optional<Cliente> cli = this.clienteRepository.findById(id);
		Cliente novoDadosCliente = null;

		if (cli.isPresent()) {
			novoDadosCliente = cli.get();

			novoDadosCliente.setNome(cliente.getNome());
			novoDadosCliente.setCpf(cliente.getCpf());
			novoDadosCliente.setEmail(cliente.getEmail());
			novoDadosCliente.setEndereco(cliente.getEndereco());

			novoDadosCliente = this.clienteRepository.save(novoDadosCliente);
		}
		return novoDadosCliente;

	}

}
