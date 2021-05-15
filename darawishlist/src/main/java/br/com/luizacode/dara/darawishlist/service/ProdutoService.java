package br.com.luizacode.dara.darawishlist.service;

import java.util.List;




import br.com.luizacode.dara.darawishlist.entity.Produto;



public interface ProdutoService {
	
	
	
	List<Produto> listarTodos();

	public Produto buscaPorId(Long id);

	Produto cadastrar(Produto produto);

	void remover(Long id);

	public Produto atualizar(Produto produto, Long id);
	
	//public List<Produto> findByNome(String nome);

}
