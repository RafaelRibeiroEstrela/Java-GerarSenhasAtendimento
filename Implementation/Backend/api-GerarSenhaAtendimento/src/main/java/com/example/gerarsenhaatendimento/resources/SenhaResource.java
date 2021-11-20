package com.example.gerarsenhaatendimento.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.services.SenhaService;

@RestController
@RequestMapping(value = "/senhas")
public class SenhaResource {
	
	@Autowired
	private SenhaService service;
	
	@PostMapping(value = "/gerarnormal")
	public ResponseEntity<Senha> gerarSenhaNormal(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.gerarSenhaNormal());
	}
	
	@PostMapping(value = "/gerarprioridade")
	public ResponseEntity<Senha> gerarSenhaPrioridade(){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.gerarSenhaPrioridade());
	}
	
	@GetMapping(value = "/resetar")
	public ResponseEntity<Void> resetarSenhas(){
		service.resetar();
		return ResponseEntity.noContent().build();
	}
	
	

}
