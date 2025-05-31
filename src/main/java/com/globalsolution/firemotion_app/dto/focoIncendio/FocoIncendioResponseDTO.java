package com.globalsolution.firemotion_app.dto.focoIncendio;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioIntensidade;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioStatus;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import com.globalsolution.firemotion_app.dto.respostaIncendio.RespostaIncendioResponseDTO;

import java.time.LocalDateTime;
import java.util.List;

public record FocoIncendioResponseDTO(Long id, FocoIncendioIntensidade intensidade, FocoIncendioStatus status, String origem, Long localizacaoId, LocalDateTime createdAt, List<AlertaResponseDTO> alertas, List<RespostaIncendioResponseDTO> focosIncendios) {
}
