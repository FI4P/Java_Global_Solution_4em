package com.globalsolution.firemotion_app.service.localizacao;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import com.globalsolution.firemotion_app.domain.sensor.Sensor;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioResponseDTO;
import com.globalsolution.firemotion_app.dto.localizacao.LocalizacaoRequestDTO;
import com.globalsolution.firemotion_app.dto.localizacao.LocalizacaoResponseDTO;
import com.globalsolution.firemotion_app.dto.sensor.SensorResponseDTO;
import com.globalsolution.firemotion_app.repository.localizacao.LocalizacaoRepository;
import com.globalsolution.firemotion_app.repository.sensor.SensorRepository;
import com.globalsolution.firemotion_app.service.focoIncendio.FocoIncendioService;
import com.globalsolution.firemotion_app.service.sensor.SensorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;
    private final SensorService sensorService;
    private final FocoIncendioService focoIncendioService;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository, SensorService sensorService, FocoIncendioService focoIncendioService) {
        this.localizacaoRepository = localizacaoRepository;
        this.sensorService = sensorService;
        this.focoIncendioService = focoIncendioService;
    }



    public LocalizacaoResponseDTO responseDTO(Localizacao localizacao){

        List<Sensor> sensores = localizacao.getSensores();
        List<SensorResponseDTO> sensoresResponseDto = sensores != null ? sensores.stream().map(sensorService::responseDTO).toList() : new ArrayList<>();

        List<FocoIncendio> focosIncendios = localizacao.getFocosIncendios();
        List<FocoIncendioResponseDTO> focosIncendiosResponseDTO = focosIncendios != null ? focosIncendios.stream().map(focoIncendioService::responseDTO).toList() : new ArrayList<>();

        return new LocalizacaoResponseDTO(localizacao.getId(), localizacao.getLatitude(), localizacao.getLongitude(), localizacao.getRegiao(), localizacao.getDescricao(), sensoresResponseDto,focosIncendiosResponseDTO);
    }

    public LocalizacaoResponseDTO findById(Long id) {
        Localizacao localizacao = localizacaoRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        return responseDTO(localizacao);

    }

    public List<LocalizacaoResponseDTO> findAll() {
        List<Localizacao> localizacoes = localizacaoRepository.findAll();

        return localizacoes.stream().map(this::responseDTO).toList();
    }

    public LocalizacaoResponseDTO save(LocalizacaoRequestDTO body){
        Localizacao localizacao = new Localizacao(null, body.latitude(), body.longitude(), body.regiao(), body.descricao(), null, null);

        Localizacao localizacaoSave = localizacaoRepository.save(localizacao);

        return responseDTO(localizacaoSave);

    }

    public LocalizacaoResponseDTO update(Long id, LocalizacaoRequestDTO body){
        Localizacao localizacao = localizacaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Localização não encontrada!"));

        localizacao.setLatitude(body.latitude() != null ? body.latitude() : localizacao.getLatitude());
        localizacao.setLongitude(body.longitude() != null ? body.longitude() : localizacao.getLongitude());
        localizacao.setRegiao(body.regiao() != null ? body.regiao() : localizacao.getRegiao());
        localizacao.setDescricao(body.descricao() != null ? body.descricao() : localizacao.getDescricao());

        Localizacao localizacaoUpdate = localizacaoRepository.save(localizacao);

        return responseDTO(localizacaoUpdate);

    }

    public void delete(Long id){
        Localizacao localizacao = localizacaoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Localização não encontrada!"));

        localizacaoRepository.delete(localizacao);
    }
}
