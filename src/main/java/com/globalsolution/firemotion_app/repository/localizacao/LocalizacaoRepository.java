package com.globalsolution.firemotion_app.repository.localizacao;

import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}
