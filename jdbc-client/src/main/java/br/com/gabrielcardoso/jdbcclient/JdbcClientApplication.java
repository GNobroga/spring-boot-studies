package br.com.gabrielcardoso.jdbcclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JdbcClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(JdbcClientApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository) {
		return args -> {
			var user = new User(null, "Pedro", "gabrielcardo@gmail.cpom", "dsds");
			userRepository.save(user);

			user = new User(5L, "Pedro3432434", "gabrielcardo@gmail.cpom", "dsds");
			
			userRepository.update(user);

			userRepository.findAll().forEach(System.out::println);
		};
	}

}
