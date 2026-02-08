package com.example.series.service;

import com.example.series.model.dto.SeriesDTO;
import com.example.series.model.entity.Series;

import java.util.List;

public interface SeriesService {
    SeriesDTO createSeries(SeriesDTO seriesDTO );
    SeriesDTO getSeriesById(Long id);
    List<SeriesDTO> getAllSeries();
    SeriesDTO updateSeries(Long id, SeriesDTO seriesDTO);
    void deleteSeries(Long id);
}
