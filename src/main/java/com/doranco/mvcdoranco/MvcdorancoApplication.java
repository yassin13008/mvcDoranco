package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class MvcdorancoApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(MvcdorancoApplication.class);

	@Autowired
	private AuthorService authorService;

	public static void main(String[] args) {
		SpringApplication.run(MvcdorancoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		authorService.addUser("jdoe", "John", "Doe", "1990-01-01", "john.doe@gmail.com");
		authorService.addUser("asmith", "Alice", "Smith", null, "alice.smith@gmail.com");

		// Vérifier que les utilisateurs ont été ajoutés
		logger.info("Users added:");
		logger.info("User jdoe: " + authorService.getUser("jdoe"));
		logger.info("User asmith: " + authorService.getUser("asmith"));
	}
}
