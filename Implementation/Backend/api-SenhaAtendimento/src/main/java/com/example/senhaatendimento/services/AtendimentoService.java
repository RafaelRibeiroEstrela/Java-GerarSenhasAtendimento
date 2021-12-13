package com.example.senhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.models.Atendimento;
import com.example.senhaatendimento.models.Senha;
import com.example.senhaatendimento.models.dto.AtendimentoDTO;
import com.example.senhaatendimento.repositories.AtendimentoRepository;

@Service
public class AtendimentoService {

	@Autowired
	private AtendimentoRepository atendimentoRepository;

	@Autowired
	private SenhaService senhaService;

	public List<Atendimento> findAll() {
		return atendimentoRepository.findAll();
	}

	public Atendimento findById(Long id) {
		Atendimento atendimento = atendimentoRepository.findById(id).get();
		if (atendimento == null) {
			throw new RuntimeException("Objeto não encontrado com id = " + id);
		}
		return atendimento;
	}

	public Atendimento save(AtendimentoDTO atendimentoDTO) {
		Senha senha = new Senha();
		senha.setId(senhaService.chamarSenha(atendimentoDTO.getPrioridadeEnum().getCod()));
		Atendimento atendimento = new Atendimento(null, LocalDateTime.now(), senha, atendimentoDTO.getGuiche());
		return atendimentoRepository.save(atendimento);
	}
	
	public void resetarSenhaAtendimento() {
		atendimentoRepository.resetarSenhaAtendimento();
	}

}
