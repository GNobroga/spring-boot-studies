package br.com.gabrielcardoso.multidatasource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.simple.JdbcClient;

@SpringBootApplication
public class MultidataSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultidataSourceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(JdbcClient postJdbClient, @Qualifier("commentsJdbcClient") JdbcClient commentsJdbClient) {
		return args -> {
			var comments = commentsJdbClient.sql("SELECT * FROM comments").query(Comment.class).list();
			comments.forEach(System.out::println);
		};
	}

}
