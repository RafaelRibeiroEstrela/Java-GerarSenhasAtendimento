package com.example.senhaatendimento;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.senhaatendimento.models.Guiche;
import com.example.senhaatendimento.repositories.GuicheRepository;

@SpringBootApplication
public class ApiSenhaAtendimentoApplication implements CommandLineRunner{
	
	@Autowired
	private GuicheRepository guicheRepository;
	
	@Value("${spring.profiles.active}")
	private String profile;

	public static void main(String[] args) {
		SpringApplication.run(ApiSenhaAtendimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		if (profile.equals("test")) {
			Guiche guiche1 = new Guiche(1L);
			Guiche guiche2 = new Guiche(2L);
			Guiche guiche3 = new Guiche(3L);
			Guiche guiche4 = new Guiche(4L);
			Guiche guiche5 = new Guiche(5L);
			
			guicheRepository.saveAll(Arrays.asList(guiche1, guiche2, guiche3, guiche4, guiche5));
			
		}
		
		
		
		
		
		
		
		
	}

}
