package com.globalsolution.firemotion_app.dto.leituraSensor;

import java.math.BigDecimal;

public record LeituraSensorRequestDTO(Long sensorId, BigDecimal valor, String unidade) {
}

