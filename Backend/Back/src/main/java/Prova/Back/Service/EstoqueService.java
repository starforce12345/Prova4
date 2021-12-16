package Prova.Back.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Prova.Back.DTO.EstoqueDTO;
import Prova.Back.Model.Produto;
import Prova.Back.Model.Estoque;
import Prova.Back.Repository.ProdutoRepository;
import Prova.Back.Repository.EstoqueRepository;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository repository;
	@Autowired
	private ProdutoRepository vendrepository;
	
	public List<EstoqueDTO> findAll() {
		List<Estoque>result = repository.findAll();
		return result.stream().map(x -> new 
		EstoqueDTO(x)).collect(Collectors.toList());
	}
	
	public Estoque findById(Long id) {
		Optional<Estoque> p = repository.findById(id);
		return p.get();
	}
	
	public Estoque save(Estoque Estoque) {
		Produto Produto = vendrepository.findById
		(Estoque.getProduto().getId()).get();
		Estoque.setProduto(Produto);
		Estoque v = repository.save(Estoque);
		return v;
	}
	
	@Transactional
	public Estoque update(Long id,Estoque Estoque) {
		Estoque p = repository.getById(id);
		p.setId(id);
		p.setQuantidade(Estoque.getQuantidade());
		Estoque prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
