package com.globalsolution.firemotion_app.dto.focoIncendio;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioIntensidade;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioStatus;

import java.time.LocalDateTime;

public record FocoIncendioResponseDTO(Long id, FocoIncendioIntensidade intensidade, FocoIncendioStatus status, String origem, Long localizacaoId, LocalDateTime createdAt) {
}
