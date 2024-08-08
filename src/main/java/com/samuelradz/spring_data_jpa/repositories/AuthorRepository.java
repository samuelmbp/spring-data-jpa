package com.samuelradz.spring_data_jpa.repositories;

import com.samuelradz.spring_data_jpa.models.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    // IMPORTANT: Note that it needs both annotations for update to work
    @Modifying // Update Query -> Hibernate
    @Transactional
    @Query("update Author a set a.age = :age where a.id = :id")
    void updateAuthor(int age, int id);

    // BULK UPDATE
    @Modifying
    @Transactional
    @Query("update Author a set a.age = :age")
    void updateAllAuthorsAges(int age);

    // Named Queries
    List<Author> findByNamedQuery(@Param("age") int age);

    @Modifying
    @Transactional
    void updateByNamedQuery(@Param("age") int age);
}
