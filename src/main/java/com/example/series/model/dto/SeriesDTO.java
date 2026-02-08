package com.example.series.model.dto;

import lombok.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDTO {
    private Long id;
    private String name;
    private String country;
    private Integer year;
    private Integer episodes;
    private Double rating;
}
