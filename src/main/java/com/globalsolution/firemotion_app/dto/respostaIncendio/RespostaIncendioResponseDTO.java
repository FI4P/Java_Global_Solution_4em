package com.globalsolution.firemotion_app.dto.respostaIncendio;

import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendioAcao;
import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendioStatus;

import java.time.LocalDateTime;

public record RespostaIncendioResponseDTO(Long id, Long focoIncendio, Long entidadeId, LocalDateTime createdAt, RespostaIncendioAcao acao, RespostaIncendioStatus status) {
}
