package com.codecool.recommendationservice.controller;

import com.codecool.recommendationservice.model.Recommendation;
import com.codecool.recommendationservice.service.RecommendationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class RecommendationController {

    private final RecommendationService recommendationService;

    @GetMapping("/{videoId}")
    public List<Recommendation> getRecommendationsForVideo(@PathVariable long videoId){
        return recommendationService.getAllRecommendationForVideo(videoId);
    }

    @PostMapping("/add")
    public Recommendation addRecommendationForVideo(@RequestBody Recommendation toSave){
        return recommendationService.saveNewRecommendationToAVideoId(toSave);
    }

    @PutMapping("/edit")
    public Recommendation updateRecommendationForVideo(@RequestBody Recommendation toUpdate){
        return recommendationService.updateRecommendation(toUpdate);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRecommendation(@PathVariable Long id){
        recommendationService.deleteRecommendation(id);
        return new ResponseEntity<>("Recommendation with id " + id + " was deleted!", HttpStatus.NO_CONTENT);
    }
}
