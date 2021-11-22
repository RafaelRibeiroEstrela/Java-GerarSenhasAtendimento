package com.example.gerarsenhaatendimento.resources;

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
	
	@PostMapping(value = "/gerar/{prioridade}")
	public ResponseEntity<Senha> gerarSenha(@PathVariable String prioridade){
		return ResponseEntity.status(HttpStatus.CREATED).body(senhaService.gerarSenha(prioridade));
	}
	
	@GetMapping
	public ResponseEntity<Void> resetarSenha(){
		return ResponseEntity.noContent().build();
	}
	
}
