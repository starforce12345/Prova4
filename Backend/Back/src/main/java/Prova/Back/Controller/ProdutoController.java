package Prova.Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Prova.Back.DTO.ProdutoDTO;
import Prova.Back.Model.Produto;
import Prova.Back.Service.ProdutoService;

@RestController
@RequestMapping(value = "produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		System.out.println("List of Products:");
		List<ProdutoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		System.out.println("Product:");
		ProdutoDTO v = new ProdutoDTO(service.findById(id));
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto Produto) throws Exception {
		try {
			Produto save = service.save(Produto);
			System.out.println("New Product Saved Sucessfully.");
			return new ResponseEntity<>(save, null, HttpStatus.CREATED);
		}
		catch(Exception ex) {
			throw new Exception(ex);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id,@RequestBody Produto Produto) {
		return ResponseEntity.ok(service.update(id, Produto));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		System.out.println("Product Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
