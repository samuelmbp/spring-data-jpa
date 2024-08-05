package com.samuelradz.spring_data_jpa.repositories;

import com.samuelradz.spring_data_jpa.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends
        JpaRepository<Author, Integer> {


}
