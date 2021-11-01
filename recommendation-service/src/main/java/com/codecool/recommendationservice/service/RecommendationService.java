package com.codecool.recommendationservice.service;

import com.codecool.recommendationservice.model.Recommendation;
import com.codecool.recommendationservice.repository.RecommendationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class RecommendationService {

    private final RecommendationRepository recommendationRepository;

    public List<Recommendation> getAllRecommendationForVideo(Long videoId){
        return recommendationRepository.findAllByVideoId(videoId);
    }

    public Recommendation saveNewRecommendationToAVideoId(Recommendation recommendation){
        return recommendationRepository.save(recommendation);
    }

    @Transactional
    public Recommendation updateRecommendation(Recommendation toUpdate){
        Recommendation recommendation = recommendationRepository.findById(toUpdate.getId()).orElseThrow(IllegalArgumentException::new);
        recommendation.setComment(toUpdate.getComment());
        recommendation.setRating(toUpdate.getRating());
        return recommendation;
    }

    @Transactional
    public void deleteRecommendation(Long id){
        recommendationRepository.deleteById(id);
    }
}
