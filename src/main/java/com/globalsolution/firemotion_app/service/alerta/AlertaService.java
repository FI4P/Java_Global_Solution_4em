package com.globalsolution.firemotion_app.service.alerta;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.dto.alerta.AlertaRequestDTO;
import com.globalsolution.firemotion_app.repository.alerta.AlertaRepository;
import com.globalsolution.firemotion_app.service.focoIncendio.FocoIncendioService;
import com.globalsolution.firemotion_app.service.sensor.SensorService;
import org.springframework.stereotype.Service;

@Service
public class AlertaService {
    private AlertaRepository alertaRepository;
    private FocoIncendioService focoIncendioService;
    private SensorService sensorService;

    public AlertaService(AlertaRepository alertaRepository, FocoIncendioService focoIncendioService, SensorService sensorService) {
        this.alertaRepository = alertaRepository;
        this.focoIncendioService = focoIncendioService;
        this.sensorService = sensorService;
    };

    public void save(AlertaRequestDTO body){

    };


}
