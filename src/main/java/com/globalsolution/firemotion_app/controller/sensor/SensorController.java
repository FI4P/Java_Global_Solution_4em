package com.globalsolution.firemotion_app.controller.sensor;


import com.globalsolution.firemotion_app.dto.sensor.SensorRequestDTO;
import com.globalsolution.firemotion_app.dto.sensor.SensorResponseDTO;
import com.globalsolution.firemotion_app.service.sensor.SensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/sensores")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public ResponseEntity<List<SensorResponseDTO>> getAllSensors() {
        List<SensorResponseDTO> sensores = sensorService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(sensores);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> show(@PathVariable("id") Long id) {

        SensorResponseDTO sensor = sensorService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(sensor);

    }

    @PostMapping
    public ResponseEntity<SensorResponseDTO> create(@RequestBody SensorRequestDTO body) {
        SensorResponseDTO sensor = sensorService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(sensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorResponseDTO> update(@PathVariable Long id, @RequestBody SensorRequestDTO body) {
        SensorResponseDTO sensor = sensorService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(sensor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        sensorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
