package com.example.senhaatendimento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
}
