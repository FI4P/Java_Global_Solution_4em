package com.globalsolution.firemotion_app.dto.alerta;

import com.globalsolution.firemotion_app.domain.alerta.AlertaNivelRisco;
import org.springframework.cglib.core.Local;

public record AlertaResponseDTO(String descricao, AlertaNivelRisco nivelRisco, Long sensorId, Local createdAt) {
}
