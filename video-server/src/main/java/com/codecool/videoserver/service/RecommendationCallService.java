package com.codecool.videoserver.service;

import com.codecool.videoserver.model.Recommendation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;

@Service
public class RecommendationCallService {

    @Value("${recommendation.url}")
    private String baseUrl;

    @Autowired
    RestTemplate restTemplate;

    public Set<Recommendation> getRecommendationsForVideo(Long videoId){
        String url = String.format(baseUrl + "/%s", videoId);
        ResponseEntity<Recommendation[]> entity = restTemplate.getForEntity(url, Recommendation[].class);
        Recommendation[] results = entity.getBody();
        return Set.of(results);
    }

    public Recommendation saveNewRecommendation (Recommendation toSave, Long id) {
        String url = baseUrl + "/add";
        toSave.setVideoId(id);
        HttpEntity<Recommendation> entity = new HttpEntity<>(toSave);
        return restTemplate.postForObject(url, entity, Recommendation.class);
    }

    public Recommendation updateRecommendation(Recommendation toUpdate) {
        String url = baseUrl + "/edit";
        HttpEntity<Recommendation> entity = new HttpEntity<>(toUpdate);
        HttpEntity<Recommendation> response = restTemplate.exchange(url, HttpMethod.PUT, entity, Recommendation.class);
        return response.getBody();
    }

    public void deleteRecommendation(long recommendationId) {
        String url = baseUrl + "/delete/" + recommendationId;
        restTemplate.delete(url);
    }
}
