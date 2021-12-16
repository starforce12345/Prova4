package Prova.Back.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Prova.Back.DTO.FornecedorDTO;
import Prova.Back.Model.Fornecedor;
import Prova.Back.Model.Produto;
import Prova.Back.Repository.FornecedorRepository;
import Prova.Back.Repository.ProdutoRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repository;
	@Autowired
	private ProdutoRepository vendrepository;
	
	public List<FornecedorDTO> findAll() {
		List<Fornecedor>result = repository.findAll();
		return result.stream().map(x -> new 
		FornecedorDTO(x)).collect(Collectors.toList());
	}
	
	public Fornecedor findById(Long id) {
		Optional<Fornecedor> p = repository.findById(id);
		return p.get();
	}
	
	public Fornecedor save(Fornecedor Fornecedor) {
		Produto Produto = vendrepository.findById
		(Fornecedor.getProduto().getId()).get();
		Fornecedor.setProduto(Produto);
		Fornecedor v = repository.save(Fornecedor);
		return v;
	}
	
	@Transactional
	public Fornecedor update(Long id,Fornecedor Fornecedor) {
		Fornecedor p = repository.getById(id);
		p.setId(id);
		p.setNome(Fornecedor.getNome());
		p.setLocal(Fornecedor.getLocal());
		Fornecedor prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
