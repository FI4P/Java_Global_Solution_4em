package com.globalsolution.firemotion_app.dto.localizacao;

import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioResponseDTO;
import com.globalsolution.firemotion_app.dto.sensor.SensorResponseDTO;

import java.math.BigDecimal;
import java.util.List;

public record LocalizacaoResponseDTO(Long id, BigDecimal latitude, BigDecimal longitude, String regiao, String descricao, List<SensorResponseDTO> sensores, List<FocoIncendioResponseDTO> focosIncendios) {
}
