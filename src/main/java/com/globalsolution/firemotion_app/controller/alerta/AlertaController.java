package com.globalsolution.firemotion_app.controller.alerta;

import com.globalsolution.firemotion_app.dto.alerta.AlertaRequestDTO;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/alertas")
public class AlertaController {

    @PutMapping
    public ResponseEntity<Void> create(@RequestBody AlertaRequestDTO body) {
        return ResponseEntity.ok().build();
    }
}
