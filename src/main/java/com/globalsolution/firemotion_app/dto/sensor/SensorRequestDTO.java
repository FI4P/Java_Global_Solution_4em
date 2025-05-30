package com.globalsolution.firemotion_app.dto.sensor;

import com.globalsolution.firemotion_app.domain.sensor.SensorTipo;

public record SensorRequestDTO(Long localizacaoId, SensorTipo tipo, String descricao) {
}
