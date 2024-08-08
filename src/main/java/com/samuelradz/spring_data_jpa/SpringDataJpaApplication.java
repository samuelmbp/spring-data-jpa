package com.samuelradz.spring_data_jpa;

import com.github.javafaker.Faker;
import com.samuelradz.spring_data_jpa.models.Author;
import com.samuelradz.spring_data_jpa.models.Video;
import com.samuelradz.spring_data_jpa.repositories.AuthorRepository;
import com.samuelradz.spring_data_jpa.repositories.VideoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthorRepository authorRepository,
			VideoRepository videoRepository
	) {
		return args -> {
			for (int i = 0; i < 50; i++) {
				Faker faker = new Faker();
				Author author = Author.builder()
						.firstName(faker.name().firstName())
						.lastName(faker.name().lastName())
						.age(faker.number().numberBetween(18, 50))
						.email(
								faker.name().username() + "@mail.com"
						)
						.build();

				authorRepository.save(author);
			}

			// Update Author with id #1
			Author author = Author.builder()
					.id(1)
					.firstName("Sam")
					.lastName("Radz")
					.age(29)
					.email("sam.radz@mail.com")
					.build();

			// Update age by id
			// authorRepository.updateAuthor(25, 1);

			// Update all ages
			authorRepository.updateAllAuthorsAges(18);
		};
	}
}
