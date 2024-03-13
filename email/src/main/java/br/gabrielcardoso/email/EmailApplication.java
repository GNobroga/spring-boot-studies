package br.gabrielcardoso.email;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmailApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailApplication.class, args);
	}

	@Bean
	ApplicationRunner sendEmail(EmailService emailService) {
		return args -> {

			var body = """
				<h1>Olá, você acaba de receber um E-mail</h2>		
				<p>Não leia isso, é uma besteira</p>
			""";

			emailService.send(new Email("gabrielcardoso_stelo@hotmail.com", "kkkk", body));
		};
	}

}
