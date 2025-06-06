package com.globalsolution.firemotion_app.dto.respostaIncendio;

import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendioAcao;
import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendioStatus;

public record RespostaIncendioRequestDTO(Long focoIncendioId, Long entidadeId, RespostaIncendioAcao acao, RespostaIncendioStatus status) {
}
