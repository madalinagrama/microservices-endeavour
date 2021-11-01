package com.codecool.videoserver.controller;

import com.codecool.videoserver.model.Recommendation;
import com.codecool.videoserver.model.Video;
import com.codecool.videoserver.service.VideoService;
import com.codecool.videoserver.utils.VisualizedVideo;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/video")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping
    private List<Video> getAllVideos(){
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public VisualizedVideo getVideoWithRecommendations(@PathVariable Long id){
        return videoService.getVideoWithRecommendations(id);
    }

    @PostMapping("/{id}/recommendation")
    public Recommendation saveNewRecommendation(@PathVariable Long id, @RequestBody Recommendation toSave){
        return videoService.saveNewRecommendation(toSave, id);
    }

    @PutMapping("/{id}/recommendation")
    public Recommendation updateRecommendation(@PathVariable Long id, @RequestBody Recommendation toUpdate) {
        return videoService.updateRecommendation(toUpdate);
    }

    @DeleteMapping("/{id}/recommendation/{recId}")
    public String deleteRecommendation(@PathVariable Long id, @PathVariable Long recId) {
        videoService.deleteRecommendation(recId);
        return "Success";
    }
}
