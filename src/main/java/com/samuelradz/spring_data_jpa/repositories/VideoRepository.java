package com.samuelradz.spring_data_jpa.repositories;

import com.samuelradz.spring_data_jpa.models.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends
        JpaRepository<Video, Integer> {

}
