package com.example.senhaatendimento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.models.enums.GuicheStatusEnum;
import com.example.senhaatendimento.repositories.GuicheRepository;

@SpringBootApplication
public class ApiSenhaAtendimentoApplication implements CommandLineRunner{
	
	@Autowired
	private GuicheRepository guicheRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiSenhaAtendimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Guiche guiche1 = new Guiche(1L, GuicheStatusEnum.FECHADO);
		Guiche guiche2 = new Guiche(2L, GuicheStatusEnum.FECHADO);
		Guiche guiche3 = new Guiche(3L, GuicheStatusEnum.FECHADO);
		Guiche guiche4 = new Guiche(4L, GuicheStatusEnum.FECHADO);
		Guiche guiche5 = new Guiche(5L, GuicheStatusEnum.FECHADO);
		
		guicheRepository.saveAll(Arrays.asList(guiche1, guiche2, guiche3, guiche4, guiche5));
		
		
		
		
		
		
	}

}
