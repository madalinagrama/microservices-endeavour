package com.codecool.videoserver.repository;

import com.codecool.videoserver.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Long> {
}
