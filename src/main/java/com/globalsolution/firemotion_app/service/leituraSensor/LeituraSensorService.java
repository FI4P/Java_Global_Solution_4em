package com.globalsolution.firemotion_app.service.leituraSensor;


import com.globalsolution.firemotion_app.domain.leituraSensor.LeituraSensor;
import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorRequestDTO;
import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorResponseDTO;
import com.globalsolution.firemotion_app.repository.leituraSensor.LeituraSensorRepository;
import com.globalsolution.firemotion_app.repository.sensor.SensorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeituraSensorService {

    private final LeituraSensorRepository  leituraSensorRepository;
    private final SensorRepository sensorRepository;

    public LeituraSensorService(LeituraSensorRepository leituraSensorRepository, SensorRepository sensorRepository) {
        this.leituraSensorRepository = leituraSensorRepository;
        this.sensorRepository = sensorRepository;
    }

    public LeituraSensorResponseDTO responseDTO(LeituraSensor leituraSensor) {
        return  new LeituraSensorResponseDTO(leituraSensor.getId(),leituraSensor.getSensor().getId(), leituraSensor.getValor(), leituraSensor.getUnidade(), leituraSensor.getCreatedAt());
    }

    public List<LeituraSensorResponseDTO> findAll(){
        List<LeituraSensor> leituras =  leituraSensorRepository.findAll();

        return leituras.stream().map(this::responseDTO).toList();

    }

    public LeituraSensorResponseDTO findById(Long id) {
        LeituraSensor leituraSensor = leituraSensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada"));

        return responseDTO(leituraSensor);
    }

    public LeituraSensorResponseDTO save(LeituraSensorRequestDTO body){
        Sensor sensor = sensorRepository.findById(body.sensorId()).orElseThrow(() -> new EntityNotFoundException("Sensor não encontrado"));

        LeituraSensor leituraSensor = new LeituraSensor(null, sensor, body.valor(), body.unidade(), null);

        sensor.addLeitura(leituraSensor);

        LeituraSensor saved = leituraSensorRepository.save(leituraSensor);

        return responseDTO(saved);
    }

    public LeituraSensorResponseDTO update(Long id, LeituraSensorRequestDTO body) {
        LeituraSensor leituraSensor = leituraSensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada"));

        leituraSensor.setValor(body.valor() != null ? body.valor() : leituraSensor.getValor());

        LeituraSensor updated = leituraSensorRepository.save(leituraSensor);

        return responseDTO(updated);


    }

    public void delete(Long id) {
        LeituraSensor leituraSensor = leituraSensorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Leitura não encontrada")  );
        leituraSensorRepository.deleteById(id);
    }






}
