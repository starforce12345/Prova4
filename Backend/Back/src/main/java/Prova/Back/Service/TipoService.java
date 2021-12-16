package Prova.Back.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Prova.Back.DTO.TipoDTO;
import Prova.Back.Model.Produto;
import Prova.Back.Model.Tipo;
import Prova.Back.Repository.ProdutoRepository;
import Prova.Back.Repository.TipoRepository;

@Service
public class TipoService {

	@Autowired
	private TipoRepository repository;
	@Autowired
	private ProdutoRepository vendrepository;
	
	public List<TipoDTO> findAll() {
		List<Tipo>result = repository.findAll();
		return result.stream().map(x -> new 
		TipoDTO(x)).collect(Collectors.toList());
	}
	
	public Tipo findById(Long id) {
		Optional<Tipo> p = repository.findById(id);
		return p.get();
	}
	
	public Tipo save(Tipo Tipo) {
		Produto Produto = vendrepository.findById
		(Tipo.getProduto().getId()).get();
		Tipo.setProduto(Produto);
		Tipo v = repository.save(Tipo);
		return v;
	}
	
	@Transactional
	public Tipo update(Long id,Tipo Tipo) {
		Tipo p = repository.getById(id);
		p.setId(id);
		p.setNome(Tipo.getNome());
		Tipo prod = repository.save(p);
		return prod;
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
