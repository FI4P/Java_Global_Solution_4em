package com.globalsolution.firemotion_app.dto.localizacao;

import java.math.BigDecimal;

public record LocalizacaoRequestDTO(BigDecimal latitude, BigDecimal longitude, String regiao, String descricao) {
}
