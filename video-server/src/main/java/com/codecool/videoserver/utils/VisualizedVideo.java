package com.codecool.videoserver.utils;

import com.codecool.videoserver.model.Recommendation;
import com.codecool.videoserver.model.Video;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class VisualizedVideo {
    private Long id;
    private String name;
    private String url;
    private Set<Recommendation> recommendation = new HashSet<>();

    public VisualizedVideo(Video video) {
        this.id = video.getId();
        this.name = video.getName();
        this.url = video.getUrl();
    }
 }
