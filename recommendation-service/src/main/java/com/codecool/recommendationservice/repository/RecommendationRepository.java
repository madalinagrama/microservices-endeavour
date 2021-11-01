package com.codecool.recommendationservice.repository;

import com.codecool.recommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
    List<Recommendation> findAllByVideoId(Long videoId);
}
