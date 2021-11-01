package com.codecool.videoserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Recommendation {

    private Long id;
    private String comment;
    private int rating;
    private Long videoId;
}
