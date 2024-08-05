package com.samuelradz.spring_data_jpa;

import com.samuelradz.spring_data_jpa.models.Author;
import com.samuelradz.spring_data_jpa.repositories.AuthorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	//@Bean
	public CommandLineRunner commandLineRunner(AuthorRepository authorRepository) {
		return args -> {
			Author author = Author.builder()
					.firstName("John")
					.lastName("Doe")
					.age(29)
					.email("john@doe.com")
					.build();

			authorRepository.save(author);
		};
	}
}
