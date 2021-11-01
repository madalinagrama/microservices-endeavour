package com.codecool.videoserver.service;

import com.codecool.videoserver.model.Recommendation;
import com.codecool.videoserver.model.Video;
import com.codecool.videoserver.repository.VideoRepository;
import com.codecool.videoserver.utils.VisualizedVideo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class VideoService {

    private final VideoRepository videoRepository;

    private final RecommendationCallService recommendationCallService;

    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    public VisualizedVideo getVideoWithRecommendations(Long videoId){
        Video video = videoRepository.findById(videoId).orElseThrow(IllegalArgumentException::new);
        Set<Recommendation> results = recommendationCallService.getRecommendationsForVideo(videoId);
        VisualizedVideo visualizedVideo = new VisualizedVideo(video);
        visualizedVideo.setRecommendation(results);
        return visualizedVideo;
    }

    public Recommendation saveNewRecommendation(Recommendation toSave, Long id){
        return recommendationCallService.saveNewRecommendation(toSave, id);
    }

    public Recommendation updateRecommendation(Recommendation toUpdate){
        return recommendationCallService.updateRecommendation(toUpdate);
    }

    public void deleteRecommendation(Long recommendationId){
        recommendationCallService.deleteRecommendation(recommendationId);
    }
}
