package com.globalsolution.firemotion_app.service.alerta;

import com.globalsolution.firemotion_app.domain.alerta.Alerta;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import com.globalsolution.firemotion_app.dto.alerta.AlertaRequestDTO;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import com.globalsolution.firemotion_app.repository.alerta.AlertaRepository;
import com.globalsolution.firemotion_app.repository.focoIncendio.FocoIncendioRepository;
import com.globalsolution.firemotion_app.repository.sensor.SensorRepository;
import com.globalsolution.firemotion_app.service.focoIncendio.FocoIncendioService;
import com.globalsolution.firemotion_app.service.sensor.SensorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlertaService {
    private final AlertaRepository alertaRepository;
    private final FocoIncendioRepository focoIncendioRepository;
    private final SensorRepository sensorRepository;

    public AlertaService(AlertaRepository alertaRepository, SensorRepository sensorRepository, FocoIncendioRepository focoIncendioRepository) {
        this.alertaRepository = alertaRepository;
        this.sensorRepository = sensorRepository;
        this.focoIncendioRepository = focoIncendioRepository;
    };

    public AlertaResponseDTO responseDTO(Alerta alerta) {
        return new AlertaResponseDTO(alerta.getId(), alerta.getDescricao(), alerta.getNivelRisco(), alerta.getSensor().getId(), alerta.getCreatedAt(), alerta.getFocoIncendio().getId());
    }
    public AlertaResponseDTO save(AlertaRequestDTO body){

        //Entidades relacionais com alerta
        FocoIncendio focoIncendio = focoIncendioRepository.findById(body.focoIncendioId()).orElseThrow(() -> new EntityNotFoundException(("Incendio não encontrad")));
        Sensor sensor = sensorRepository.findById(body.sensorId()).orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado!"));

        Alerta alerta = new Alerta(null, body.descricao(), body.nivelRisco(), null, null, null);

        //Atualizando entidade Sensor com o novo alerta criado
        sensor.addAlerta(alerta);

        //Atualizando a entidade FocoIncendio com o novo alerta criado
        focoIncendio.addAlerta(alerta);

        Alerta savedAlerta = alertaRepository.save(alerta);


        return  responseDTO(savedAlerta);

    };

    public List<AlertaResponseDTO> findAll(){
        List<Alerta> alertas = alertaRepository.findAll();

        return alertas.stream().map(this::responseDTO).toList();
    }


}
