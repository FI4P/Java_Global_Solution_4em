package com.globalsolution.firemotion_app.controller.alerta;

import com.globalsolution.firemotion_app.dto.alerta.AlertaRequestDTO;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import com.globalsolution.firemotion_app.service.alerta.AlertaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    private final AlertaService alertaService;

    public AlertaController(AlertaService alertaService) {
        this.alertaService = alertaService;
    }

    @PostMapping
    public ResponseEntity<AlertaResponseDTO> create(@RequestBody AlertaRequestDTO body) {
        AlertaResponseDTO alerta  = alertaService.save(body);

        return ResponseEntity.ok().body(alerta);

    }

    @GetMapping
    public ResponseEntity<List<AlertaResponseDTO>> index() {
        List<AlertaResponseDTO> alertas = alertaService.findAll();

        return ResponseEntity.ok().body(alertas);
    }
}
