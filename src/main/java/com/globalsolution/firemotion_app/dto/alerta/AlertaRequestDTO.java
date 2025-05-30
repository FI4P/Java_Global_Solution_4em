package com.globalsolution.firemotion_app.dto.alerta;

import com.globalsolution.firemotion_app.domain.alerta.AlertaNivelRisco;

import java.time.LocalDateTime;

public record AlertaRequestDTO (String descricao, AlertaNivelRisco nivelRisco, Long sensorId){
}
