package com.globalsolution.firemotion_app.service.respostaIncendio;

import com.globalsolution.firemotion_app.domain.entidadeResposta.EntidadeResposta;
import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendio;
import com.globalsolution.firemotion_app.dto.respostaIncendio.RespostaIncendioRequestDTO;
import com.globalsolution.firemotion_app.dto.respostaIncendio.RespostaIncendioResponseDTO;
import com.globalsolution.firemotion_app.repository.entidadeResposta.EntidadeRespostaRepository;
import com.globalsolution.firemotion_app.repository.focoIncendio.FocoIncendioRepository;
import com.globalsolution.firemotion_app.repository.respostaIncendio.RespostaIncendioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespostaIncendioService {

    private final RespostaIncendioRepository respostaIncendioRepository;
    private final FocoIncendioRepository focoIncendioRepository;
    private final EntidadeRespostaRepository entidadeRespostaRepository;

    public RespostaIncendioService(RespostaIncendioRepository respostaIncendioRepository, FocoIncendioRepository focoIncendioRepository, EntidadeRespostaRepository entidadeRespostaRepository) {
        this.respostaIncendioRepository = respostaIncendioRepository;
        this.focoIncendioRepository = focoIncendioRepository;
        this.entidadeRespostaRepository = entidadeRespostaRepository;
    }

    public RespostaIncendioResponseDTO responseDTO(RespostaIncendio respostaIncendio) {
        return new RespostaIncendioResponseDTO(respostaIncendio.getId(), respostaIncendio.getFocoIncendio().getId(), respostaIncendio.getEntidadeResposta().getId(), respostaIncendio.getCreatedAt(), respostaIncendio.getAcao(),respostaIncendio.getStatus());
    }

    public List<RespostaIncendioResponseDTO> findAll(){
        List<RespostaIncendio> respostas = respostaIncendioRepository.findAll();

        return respostas.stream().map(this::responseDTO).toList();
    }

    public RespostaIncendioResponseDTO findById(Long id){
        RespostaIncendio resposta = respostaIncendioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrada"));

        return responseDTO(resposta);
    }

    public RespostaIncendioResponseDTO save(RespostaIncendioRequestDTO body){
        FocoIncendio focoIncendio = focoIncendioRepository.findById(body.focoIncendioId()).orElseThrow(() -> new EntityNotFoundException("Incendio não encontrado"));
        EntidadeResposta entidadeResposta = entidadeRespostaRepository.findById(body.entidadeId()).orElseThrow(() -> new EntityNotFoundException("Entidade não encontrado"));

        RespostaIncendio resposta = new RespostaIncendio(null,null, body.acao(), body.status(), focoIncendio, entidadeResposta);

        RespostaIncendio saved = respostaIncendioRepository.save(resposta);

        return responseDTO(saved);


    }

    public  RespostaIncendioResponseDTO update(Long id, RespostaIncendioRequestDTO body){
        RespostaIncendio respostaIncendio = respostaIncendioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado"));

        respostaIncendio.setAcao(body.acao() != null ? body.acao() : respostaIncendio.getAcao());
        respostaIncendio.setStatus(body.status() != null ? body.status() : respostaIncendio.getStatus());

        RespostaIncendio updated = respostaIncendioRepository.save(respostaIncendio);

        return responseDTO(updated);
    }

    public void delete(Long id){
        respostaIncendioRepository.deleteById(id);
    }

}
