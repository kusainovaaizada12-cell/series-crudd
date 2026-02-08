package com.example.series.service.Impl;

import com.example.series.model.dto.SeriesDTO;
import com.example.series.model.entity.Series;
import com.example.series.repository.SeriesRepository;
import com.example.series.service.SeriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeriesServiceImpl implements SeriesService {

    private final SeriesRepository seriesRepository;

    @Override
    public SeriesDTO createSeries(SeriesDTO seriesDTO) {
        Series series = mapToEntity(seriesDTO);
        Series saved = seriesRepository.save(series);
        return mapToDTO(saved);
    }
    @Override
    public SeriesDTO getSeriesById(Long id) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Series not found with id " + id));
        return mapToDTO(series);
    }
    @Override
    public List<SeriesDTO> getAllSeries() {
        return seriesRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }
    @Override
    public SeriesDTO updateSeries(Long id, SeriesDTO seriesDTO) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Series not found with id " + id));

        series.setName(seriesDTO.getName());
        series.setCountry(seriesDTO.getCountry());
        series.setYear(seriesDTO.getYear());
        series.setEpisodes(seriesDTO.getEpisodes());
        series.setRating(seriesDTO.getRating());

        Series updated = seriesRepository.save(series);
        return mapToDTO(updated);
    }
    @Override
    public void deleteSeries(Long id) {
        Series series = seriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Series not found with id " + id));
        seriesRepository.delete(series);
    }
    private SeriesDTO mapToDTO(Series series) {
        return new SeriesDTO(
                series.getId(),
                series.getName(),
                series.getCountry(),
                series.getYear(),
                series.getEpisodes(),
                series.getRating()
        );
    }

    private Series mapToEntity(SeriesDTO dto) {
        Series series = new Series();
        series.setId(dto.getId());
        series.setName(dto.getName());
        series.setCountry(dto.getCountry());
        series.setYear(dto.getYear());
        series.setEpisodes(dto.getEpisodes());
        series.setRating(dto.getRating());
        return series;
    }
}