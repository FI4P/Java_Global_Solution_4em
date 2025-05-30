package com.globalsolution.firemotion_app.dto.leituraSensor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LeituraSensorResponseDTO(Long id, Long sensorId, BigDecimal valor, String unidade, LocalDateTime createdAt) {
}

