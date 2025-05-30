package com.globalsolution.firemotion_app.dto.entidadeResposta;

import com.globalsolution.firemotion_app.domain.entidadeResposta.EntidadeRespostaTipo;

public record EntidadeRespostaRequestDTO(String nome, EntidadeRespostaTipo tipo, String contato) {
}
