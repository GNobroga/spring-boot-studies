package br.com.gabrielcardoso.reactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReactiveApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void contextLoads() {
		var user = new User(null, "Gabriel", "camilo123", "thallesju@gmail.com");

		webTestClient.post().uri("/users").bodyValue(user)
			.exchange()
			.expectBody(User.class)
			.value(response -> {
				assertNotNull(response.id());
				assertEquals(response.username(), user.username());
				assertEquals(response.password(), user.password());
				assertEquals(response.email(), user.email());
			});

		
		webTestClient.get().uri("/users")	
			.exchange()
			.expectStatus().is2xxSuccessful()
			.expectBodyList(User.class)
			.value(response -> {
				for (var u: response) {
					assertNotNull(u.id());
					assertEquals(u.username(), user.username());
					assertEquals(u.password(), user.password());
					assertEquals(u.email(), user.email());
				}
			});
	}

}
