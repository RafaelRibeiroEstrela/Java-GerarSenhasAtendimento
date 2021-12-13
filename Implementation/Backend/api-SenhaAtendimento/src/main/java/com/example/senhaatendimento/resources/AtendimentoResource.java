package com.example.senhaatendimento.resources;

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

import com.example.senhaatendimento.models.Atendimento;
import com.example.senhaatendimento.models.dto.AtendimentoDTO;
import com.example.senhaatendimento.services.AtendimentoService;

@RestController
@RequestMapping(value = "/atendimentos")
public class AtendimentoResource {

	@Autowired
	private AtendimentoService atendimentoService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Atendimento>> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Atendimento> findById(@PathVariable Long id){
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Atendimento> save(@RequestBody AtendimentoDTO atendimentoDTO){
		return ResponseEntity.status(HttpStatus.OK).body(atendimentoService.save(atendimentoDTO));
	}
	
	
}
