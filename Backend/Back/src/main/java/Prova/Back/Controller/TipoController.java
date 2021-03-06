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

import Prova.Back.DTO.TipoDTO;
import Prova.Back.Model.Tipo;
import Prova.Back.Service.TipoService;

@RestController
@RequestMapping(value = "tipos")
public class TipoController {

	@Autowired
	private TipoService service;
	
	@GetMapping
	public ResponseEntity<List<TipoDTO>> findAll() {
		System.out.println("List of Types:");
		List<TipoDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDTO> findById(@PathVariable Long id) {
		System.out.println("Type:");
		TipoDTO p = new TipoDTO(service.findById(id));
		return ResponseEntity.ok(p);
	}
	
	@PostMapping
	public ResponseEntity<TipoDTO> save(@RequestBody Tipo Tipo) {
		System.out.println("New Type Saved Sucessfully.");
		TipoDTO p = new TipoDTO(service.save(Tipo));
		return ResponseEntity.ok(p);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Tipo> update(@PathVariable Long id,@RequestBody Tipo Tipo) {
		return ResponseEntity.ok(service.update(id, Tipo));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		System.out.println("Type Deleted Sucessfully.");
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
