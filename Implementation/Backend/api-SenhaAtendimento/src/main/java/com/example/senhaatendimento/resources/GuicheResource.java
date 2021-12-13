package com.example.senhaatendimento.resources;

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

import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.services.GuicheService;

@RestController
@RequestMapping(value = "/guiches")
public class GuicheResource {

	@Autowired
	private GuicheService guicheService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Guiche>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(guicheService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Guiche> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(guicheService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Guiche> save(@RequestBody Guiche guiche){
		return ResponseEntity.status(HttpStatus.OK).body(guicheService.save(guiche));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Guiche> save(@PathVariable Long id, @RequestBody Guiche guiche){
		return ResponseEntity.status(HttpStatus.OK).body(guicheService.update(id, guiche));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		return ResponseEntity.noContent().build();
	}
	
}
