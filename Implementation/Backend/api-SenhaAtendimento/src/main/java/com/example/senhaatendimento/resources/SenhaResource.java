package com.example.senhaatendimento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.senhaatendimento.models.Senha;
import com.example.senhaatendimento.models.enums.PrioridadeEnum;
import com.example.senhaatendimento.services.SenhaService;

@RestController
@RequestMapping(value = "/senhas")
public class SenhaResource {

	@Autowired
	private SenhaService senhaService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Senha>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Senha> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.findById(id));
	}
	
	@PostMapping("/{prioridade}")
	public ResponseEntity<Senha> save(@PathVariable PrioridadeEnum prioridade){
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.save(prioridade));
	}
	
	@PutMapping
	public ResponseEntity<Void> resetarSenhaAtendimento(){
		senhaService.resetarSenhaAtendimento();
		return ResponseEntity.noContent().build();
	}
	
	
}
