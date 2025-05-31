package com.globalsolution.firemotion_app.dto.sensor;

import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import com.globalsolution.firemotion_app.domain.sensor.SensorTipo;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorResponseDTO;

import java.util.List;

public record SensorResponseDTO(Long id, SensorTipo tipo, String descricao, String localizacao, List<AlertaResponseDTO> alertas, List<LeituraSensorResponseDTO> leituras) {
}
