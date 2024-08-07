package com.doranco.mvcdoranco;

import com.doranco.mvcdoranco.service.UserService;
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
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(MvcdorancoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.addUser("jdoe", "John", "Doe", "1990-01-01", "/images/jdoe.png");
		userService.addUser("asmith", "Alice", "Smith", null, "/images/asmith.png");

		// Vérifier que les utilisateurs ont été ajoutés
		logger.info("Users added:");
		logger.info("User jdoe: " + userService.getUser("jdoe"));
		logger.info("User asmith: " + userService.getUser("asmith"));
	}
}
