package com.example.gerarsenhaatendimento.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.gerarsenhaatendimento.models.Atendimento;
import com.example.gerarsenhaatendimento.models.Guiche;
import com.example.gerarsenhaatendimento.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService atendimentoService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Atendimento>> buscarTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.buscarTodos());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Atendimento> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.buscarPorId(id));
	}

	@PostMapping(value = "/criar")
	public ResponseEntity<Atendimento> criar(@RequestBody Guiche guiche) {
		return ResponseEntity.status(HttpStatus.CREATED).body(atendimentoService.criar(guiche));
	}

}
