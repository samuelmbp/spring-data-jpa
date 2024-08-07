package com.samuelradz.spring_data_jpa.controllers;

import com.samuelradz.spring_data_jpa.models.Author;
import com.samuelradz.spring_data_jpa.services.AuthorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AuthorController {

 private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/api/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/api/authors/{firstName}")
    public List<Author> getAuthorByFirstName(@PathVariable String firstName) {
        return authorService.getAuthorByFirstName(firstName);
    }

    @GetMapping("/api/authors/endsWith/{suffix}")
    public List<Author> getAuthorsByFirstNameEndingWith(@PathVariable String suffix) {
        return authorService.getAuthorsByFirstNameEndingWith(suffix);
    }
}
