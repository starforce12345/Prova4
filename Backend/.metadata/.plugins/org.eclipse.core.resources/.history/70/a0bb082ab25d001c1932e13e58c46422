package Prova.Back.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Prova.Back.DTO.ProdutoDTO;
import Prova.Back.Model.Produto;
import Prova.Back.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<ProdutoDTO> findAll() {
		List<Produto> result = repository.findAll();
		return result.stream().map(x -> new
		ProdutoDTO(x)).collect(Collectors.toList());
	}
	
	public Produto findById(Long id) {
		Optional<Produto> v = repository.findById(id);
		return v.get();
	}
	
	public Produto save(Produto Produto) {
		Produto v = repository.save(Produto);
		return v;
	}
	
	@Transactional
	public Produto update(Long id,Produto Produto) {
		Produto v = repository.getById(id);
		v.setId(id); 
		v.setNome(Produto.getNome());
		v.setQuantidade(Produto.getQuantidade());
		v.setTipo(Produto.getTipo());
		v.setFornecedor(Produto.getFornecedor());
		v.setPrecovenda(Produto.getPrecovenda());
		v.setPrecocompra(Produto.getPrecocompra());
		Produto vendpt = repository.save(v);
		return vendpt;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
