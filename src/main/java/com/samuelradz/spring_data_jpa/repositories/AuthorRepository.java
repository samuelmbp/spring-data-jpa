package com.samuelradz.spring_data_jpa.repositories;

import com.samuelradz.spring_data_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepository extends
        JpaRepository<Author, Integer> {

    // SELECT * FROM Author WHERE first_name = 'Sam'
    List<Author> findAllByFirstName(String firstName);

    // SELECT * FROM Author WHERE first_name = 'sam'
    List<Author> findAllByFirstNameIgnoreCase(String firstName);

    // SELECT * FROM Author WHERE first_name like '%sa%'
    List<Author> findAllByFirstNameContainingIgnoreCase(String firstName);

    // SELECT * FROM Author WHERE first_name like 'sa%'
    List<Author> findAllByFirstNameStartsWithIgnoreCase(String firstName);

    // SELECT * FROM Author WHERE first_name like '%sa'
    List<Author> findAllByFirstNameEndsWithIgnoreCase(String firstName);

    // SELECT * FROM Author WHERE first_name in ('sam', 'coding', 'engineer'
    List<Author> findAllByFirstNameInIgnoreCase(List<String> firstNames);

}
