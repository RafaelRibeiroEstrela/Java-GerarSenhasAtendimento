package com.example.gerarsenhaatendimento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.gerarsenhaatendimento.services.SenhaService;

@SpringBootApplication
public class ApiGerarSenhaAtendimentoApplication implements CommandLineRunner{
	
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGerarSenhaAtendimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
	}

	

}
