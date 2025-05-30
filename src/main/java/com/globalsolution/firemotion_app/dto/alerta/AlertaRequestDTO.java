package com.globalsolution.firemotion_app.dto.alerta;

import com.globalsolution.firemotion_app.domain.alerta.AlertaNivelRisco;


public record AlertaRequestDTO (String descricao, AlertaNivelRisco nivelRisco, Long sensorId, Long focoIncendioId){
}
