package Prova.Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Prova.Back.DTO.FornecedorDTO;
import Prova.Back.Model.Fornecedor;
import Prova.Back.Service.FornecedorService;

@RestController
@RequestMapping(value = "fornecedores")
public class FornecedorController {
	@Autowired
	private FornecedorService service;
	
	@GetMapping
	public ResponseEntity<List<FornecedorDTO>> findAll() {
		System.out.println("List of Providers:");
		List<FornecedorDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FornecedorDTO> findById(@PathVariable Long id) {
		System.out.println("Provider:");
		FornecedorDTO p = new FornecedorDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<FornecedorDTO> save(@RequestBody Fornecedor Fornecedor) {
		System.out.println("New Provider Saved Sucessfully.");
		FornecedorDTO p = new FornecedorDTO(service.save(Fornecedor));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> update(@PathVariable Long id,@RequestBody Fornecedor Fornecedor) {
		return ResponseEntity.ok(service.update(id, Fornecedor));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Provider Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
