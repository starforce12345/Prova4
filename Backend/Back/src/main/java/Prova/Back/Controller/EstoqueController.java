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

import Prova.Back.DTO.EstoqueDTO;
import Prova.Back.Model.Estoque;
import Prova.Back.Service.EstoqueService;

@RestController
@RequestMapping(value = "estoque")
public class EstoqueController {
	
	@Autowired
	private EstoqueService service;
	
	@GetMapping
	public ResponseEntity<List<EstoqueDTO>> findAll() {
		System.out.println("List of Stock:");
		List<EstoqueDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EstoqueDTO> findById(@PathVariable Long id) {
		System.out.println("Stock:");
		EstoqueDTO p = new EstoqueDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<EstoqueDTO> save(@RequestBody Estoque Estoque) {
		System.out.println("Stock Saved Sucessfully.");
		EstoqueDTO p = new EstoqueDTO(service.save(Estoque));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Estoque> update(@PathVariable Long id,@RequestBody Estoque Estoque) {
		return ResponseEntity.ok(service.update(id, Estoque));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Stock Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
