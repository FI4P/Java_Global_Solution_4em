package com.globalsolution.firemotion_app.service.sensor;

import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import com.globalsolution.firemotion_app.dto.alerta.AlertaResponseDTO;
import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorRequestDTO;
import com.globalsolution.firemotion_app.dto.sensor.SensorRequestDTO;
import com.globalsolution.firemotion_app.dto.sensor.SensorResponseDTO;
import com.globalsolution.firemotion_app.repository.localizacao.LocalizacaoRepository;
import com.globalsolution.firemotion_app.repository.sensor.SensorRepository;
import com.globalsolution.firemotion_app.service.alerta.AlertaService;
import jakarta.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;
    private final LocalizacaoRepository localizacaoRepository;
    private final AlertaService alertaService;

    public SensorService(SensorRepository sensorRepository, LocalizacaoRepository localizacaoRepository, AlertaService alertaService) {
        this.sensorRepository = sensorRepository;
        this.localizacaoRepository = localizacaoRepository;
        this.alertaService = alertaService;
    }

    public SensorResponseDTO responseDTO(Sensor sensor){
        List<AlertaResponseDTO> alertasResponseDTO = sensor.getAlertas() != null ? sensor.getAlertas().stream().map(alertaService::responseDTO).toList() : new ArrayList<>();

        return  new SensorResponseDTO(sensor.getId(), sensor.getTipo(), sensor.getDescricao(), sensor.getLocalizacao().getRegiao(), alertasResponseDTO);
    }


    public List<SensorResponseDTO> findAll(){
        List<Sensor> sensors = sensorRepository.findAll();

        return  sensors.stream().map(this::responseDTO).toList();
    }

    public SensorResponseDTO findById(Long id){
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor nao encontrado"));

        return  responseDTO(sensor);
    }

    public SensorResponseDTO save(SensorRequestDTO body){

        Localizacao localizacao = localizacaoRepository.findById(body.localizacaoId()).orElseThrow(() -> new EntityNotFoundException("Localização não encontrada"));

        Sensor sensor = new Sensor(null, body.tipo(), body.descricao(), localizacao, null , null);

        localizacao.addSensor(sensor);

        Sensor saved = sensorRepository.save(sensor);

        return responseDTO(saved);
    }

    public SensorResponseDTO update(Long id, SensorRequestDTO body){
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));

        sensor.setTipo(body.tipo() != null ? body.tipo() : sensor.getTipo());
        sensor.setDescricao(body.descricao() != null ? body.descricao() : sensor.getDescricao());

        Sensor saved = sensorRepository.save(sensor);

        return responseDTO(saved);

    }

    public void delete(Long id){
        Sensor sensor = sensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));
        sensorRepository.deleteById(id);
    }
}
