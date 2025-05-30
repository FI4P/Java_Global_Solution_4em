package com.globalsolution.firemotion_app.dto.localizacao;

import com.globalsolution.firemotion_app.domain.sensor.Sensor;

import java.math.BigDecimal;
import java.util.List;

public record LocalizacaoResponseDTO(Long id, BigDecimal latitude, BigDecimal longitude, String regiao, String descricao, List<Sensor> sensores) {
}
