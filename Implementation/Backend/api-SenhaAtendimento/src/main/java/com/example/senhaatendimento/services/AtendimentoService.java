package com.example.senhaatendimento.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.senhaatendimento.models.Atendimento;
import com.example.senhaatendimento.models.dto.AtendimentoDTO;
import com.example.senhaatendimento.repositories.AtendimentoRepository;
import com.example.senhaatendimento.services.expcetion.ExceptionService;

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
		Atendimento atendimento = atendimentoRepository.findById(id).orElseThrow(() -> new ExceptionService("Objeto não encontrado com id = " + id));
		return atendimento;
	}

	public Atendimento save(AtendimentoDTO atendimentoDTO) {
		Atendimento atendimento = new Atendimento(null, LocalDateTime.now(), senhaService.update(atendimentoDTO.getPrioridade()), atendimentoDTO.getGuiche());
		return atendimentoRepository.save(atendimento);
	}
	
	//public void resetarSenhaAtendimento() {
	//	atendimentoRepository.resetarSenhaAtendimento();
	//}

}
