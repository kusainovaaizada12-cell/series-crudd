package com.example.series.controller;


import com.example.series.model.dto.SeriesDTO;
import com.example.series.service.SeriesService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("/api/series")
@RequiredArgsConstructor
public class SeriesController {
    private final SeriesService seriesService;

    @PostMapping
    public ResponseEntity<SeriesDTO> createSeries(@RequestBody SeriesDTO seriesDTO) {
        SeriesDTO created = seriesService.createSeries(seriesDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<SeriesDTO>> getAllSeries() {
        List<SeriesDTO> seriesList = seriesService.getAllSeries();
        return ResponseEntity.ok(seriesList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable Long id) {
        SeriesDTO seriesDTO = seriesService.getSeriesById(id);
        return ResponseEntity.ok(seriesDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SeriesDTO> updateSeries(@PathVariable Long id,
                                                  @RequestBody SeriesDTO seriesDTO) {
        SeriesDTO updated = seriesService.updateSeries(id, seriesDTO);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSeries(@PathVariable Long id) {
        seriesService.deleteSeries(id);
        return ResponseEntity.noContent().build();
    }
}