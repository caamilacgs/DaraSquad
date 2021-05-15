package br.com.luizacode.dara.darawishlist.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.luizacode.dara.darawishlist.entity.Produto;

import br.com.luizacode.dara.darawishlist.repository.ProdutoRepository;
import br.com.luizacode.dara.darawishlist.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> listarTodos() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto buscaPorId(Long id) {
		return produtoRepository.findById(id).orElse(new Produto());
	}

	@Override
	public Produto cadastrar(Produto produto) {
		return this.produtoRepository.save(produto);

	}

	@Override
	public void remover(Long id) {
		this.produtoRepository.deleteById(id);
	}

	@Override
	public Produto atualizar(Produto produto, Long id) {
		Optional<Produto> prod = this.produtoRepository.findById(id);
		Produto novoDadosProduto = null;

		if (prod.isPresent()) {
			novoDadosProduto = prod.get();

			novoDadosProduto.setNome(produto.getNome());
			novoDadosProduto.setDescricao(produto.getDescricao());
			novoDadosProduto.setPreco(produto.getPreco());

			novoDadosProduto = this.produtoRepository.save(novoDadosProduto);
		}
		return novoDadosProduto;

	}
//	@Override
//	public List<Produto> findByNome(String nome) {
//        return this.produtoRepository.findBynome(nome);
//    }

}
