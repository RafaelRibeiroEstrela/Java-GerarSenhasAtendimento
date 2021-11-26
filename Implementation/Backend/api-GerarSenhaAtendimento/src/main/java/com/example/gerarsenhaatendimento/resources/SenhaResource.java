package com.example.gerarsenhaatendimento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.models.enums.PrioridadeEnum;
import com.example.gerarsenhaatendimento.models.enums.SenhaStatusEnum;
import com.example.gerarsenhaatendimento.services.SenhaService;

@RestController
@RequestMapping(value = "/senhas")
public class SenhaResource {

	@Autowired
	private SenhaService senhaService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Senha>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.buscarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Senha> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.buscarPorId(id));
	}

	@GetMapping(value = "/buscarstatusprioridade")
	public ResponseEntity<List<Senha>> buscarPorStatusEPrioridade(@RequestParam SenhaStatusEnum status,
			@RequestParam PrioridadeEnum prioridade) {
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.buscarPorStatusEPrioridade(status, prioridade));
	}

	@PostMapping
	public ResponseEntity<Senha> criar(Integer prioridade) {
		return ResponseEntity.status(HttpStatus.CREATED).body(senhaService.criar(prioridade));
	}

	@GetMapping(value = "/chamar")
	public ResponseEntity<Senha> chamar() {
		return ResponseEntity.status(HttpStatus.OK).body(senhaService.chamar());
	}

}
