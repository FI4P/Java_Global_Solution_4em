package com.globalsolution.firemotion_app.dto.focoIncendio;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioIntensidade;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendioStatus;

public record FocoIncendioRequestDTO(FocoIncendioIntensidade intensidade, FocoIncendioStatus status, String origem, Long localizacaoId) {
}
