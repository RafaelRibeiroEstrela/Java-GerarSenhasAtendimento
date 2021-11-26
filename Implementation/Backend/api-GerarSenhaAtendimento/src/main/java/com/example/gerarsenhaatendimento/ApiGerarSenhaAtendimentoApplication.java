package com.example.gerarsenhaatendimento;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.gerarsenhaatendimento.models.Atendimento;
import com.example.gerarsenhaatendimento.models.Guiche;
import com.example.gerarsenhaatendimento.models.Senha;
import com.example.gerarsenhaatendimento.models.enums.PrioridadeEnum;
import com.example.gerarsenhaatendimento.models.enums.SenhaStatusEnum;
import com.example.gerarsenhaatendimento.repositories.AtendimentoRepository;
import com.example.gerarsenhaatendimento.repositories.GuicheRepository;
import com.example.gerarsenhaatendimento.repositories.SenhaRepository;

@SpringBootApplication
public class ApiGerarSenhaAtendimentoApplication implements CommandLineRunner{
	
	@Autowired
	private SenhaRepository senhaRepository;
	
	@Autowired
	private AtendimentoRepository atendimentoRepository;
	
	@Autowired
	private GuicheRepository guicheRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGerarSenhaAtendimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		guicheRepository.save(new Guiche(1L));
		
		/*
		List<Senha> senhas = new ArrayList<>();
		
		List<Atendimento> atendimentos = new ArrayList<>();
		
		Senha senhaAtendida = null;
		
		Guiche guiche1 = new Guiche(1L);
		guiche1 = guicheRepository.save(guiche1);
		
		Senha senha1 = new Senha(null, PrioridadeEnum.NORMAL, LocalDateTime.now(), SenhaStatusEnum.AGUARDANDO_ATENDIMENTO); 
		senha1 = senhaRepository.save(senha1);
		senhas.add(senha1);
		
		
		Senha senha2 = new Senha(null, PrioridadeEnum.NORMAL, LocalDateTime.now(), SenhaStatusEnum.AGUARDANDO_ATENDIMENTO); 
		senha2 = senhaRepository.save(senha2);
		senhas.add(senha2);
		
		
		//INICIA ATENDIMENTO
		for (Senha senha : senhas) {
			if (senha.getStatus() == SenhaStatusEnum.AGUARDANDO_ATENDIMENTO) {
				Atendimento atendimento = new Atendimento(null, LocalDateTime.now(), senha, guiche1);
				atendimento = atendimentoRepository.save(atendimento);
				atendimentos.add(atendimento);
				
				senha.setStatus(SenhaStatusEnum.EM_ATENDIMENTO);
				senha = senhaRepository.save(senha);
				
				senhaAtendida = senha;
				break;
			}
		}
		
		//FECHA ATENDIMENTO
		for (Senha senha : senhas) {
			if (senha.getId() == senhaAtendida.getId()) {
				senha.setStatus(SenhaStatusEnum.CONCLUIDO);
				senha = senhaRepository.save(senha);
				break;
			}
		}
		*/
	}

}
