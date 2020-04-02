package com.example.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.course.entities.User;
import com.example.course.repositories.UserRepository;

@Configuration // indica que é uma classe de configuraçao
@Profile("test") // indica que é no perfil de teste, definido no application.properties
public class TestConfig implements CommandLineRunner {

	@Autowired // indica que é uma dependencia dessa classe
	private UserRepository userRepository;

	@Override // Executa quand o programa for iniciado
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		//Salva objetos no banco de dados
		userRepository.saveAll(Arrays.asList(u1,u2));
	}

}
