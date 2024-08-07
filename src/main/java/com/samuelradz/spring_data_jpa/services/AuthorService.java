package com.samuelradz.spring_data_jpa.services;

import com.samuelradz.spring_data_jpa.models.Author;
import com.samuelradz.spring_data_jpa.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Author> getAuthorByFirstName(String firstName) {
        return authorRepository.findAllByFirstNameIgnoreCase(firstName);
    }

    public List<Author> getAuthorsByFirstNameEndingWith(String suffix) {
        return authorRepository.findAllByFirstNameEndsWithIgnoreCase(suffix);
    }
}
