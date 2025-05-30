package com.globalsolution.firemotion_app.dto.alerta;

import com.globalsolution.firemotion_app.domain.alerta.AlertaNivelRisco;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public record AlertaResponseDTO(Long id, String descricao, AlertaNivelRisco nivelRisco, Long sensorId, LocalDateTime createdAt, Long focoIncendioId) {
}
