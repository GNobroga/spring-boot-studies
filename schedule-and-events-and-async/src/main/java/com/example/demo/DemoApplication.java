package com.example.demo;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import com.example.demo.asynchronous.EmailService;
import com.example.demo.events.Publisher;
import com.example.demo.events.SendNotificationEvent;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(Publisher publisher) {
		return args -> {
			publisher.execute(SendNotificationEvent.Type.EMAIL);
		};
	}


	/**
	 * This method allows to listen to my created event by calling SendNotificationEvent.
	 */
	@Bean 
	ApplicationListener<SendNotificationEvent> oApplicationListener(EmailService emailService) {
		return event -> {
			emailService.sendAsync("gabrielcardoso", "livia");
			System.out.println(event.getType());
		};
	}

}
