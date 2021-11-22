package com.example.gerarsenhaatendimento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.services.SenhaService;

@RestController
@RequestMapping(value = "/senhas")
public class SenhaResource {
	
	@Autowired
	private SenhaService senhaService;
	
	@PostMapping(value = "/gerarnormal")
	public ResponseEntity<Senha> gerarSenhaPrioridadeNormal(){
		return ResponseEntity.status(HttpStatus.CREATED).body(senhaService.gerarSenhaPrioridadeNormal());
	}
	
	@PostMapping(value = "/geraralta")
	public ResponseEntity<Senha> gerarSenhaPrioridadeAlta(){
		return ResponseEntity.status(HttpStatus.CREATED).body(senhaService.gerarSenhaPrioridadeAlta());
	}
	
	@GetMapping(value = "/resetar")
	public ResponseEntity<Void> resetarSenha(){
		senhaService.resetarTodasAsSenhas();
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Senha>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.findAll());
	}
	
	@GetMapping(value = "/{cod}")
	public ResponseEntity<List<Senha>> findByCod(@PathVariable Long cod){
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.findByCod(cod));
	}
	
}
