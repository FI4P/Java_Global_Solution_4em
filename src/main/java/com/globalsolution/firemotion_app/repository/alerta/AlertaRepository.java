package com.globalsolution.firemotion_app.repository.alerta;

import com.globalsolution.firemotion_app.domain.alerta.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
