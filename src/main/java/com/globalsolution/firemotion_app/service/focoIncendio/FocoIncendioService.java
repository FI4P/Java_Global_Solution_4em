package com.globalsolution.firemotion_app.service.focoIncendio;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.domain.localizacao.Localizacao;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioRequestDTO;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioResponseDTO;
import com.globalsolution.firemotion_app.repository.focoIncendio.FocoIncendioRepository;
import com.globalsolution.firemotion_app.repository.localizacao.LocalizacaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class FocoIncendioService {

    private final FocoIncendioRepository focoIncendioRepository;
    private final LocalizacaoRepository localizacaoRepository;

    public FocoIncendioService(FocoIncendioRepository focoIncendioRepository, LocalizacaoRepository localizacaoRepository) {
        this.focoIncendioRepository = focoIncendioRepository;
        this.localizacaoRepository = localizacaoRepository;
    }

    public FocoIncendioResponseDTO responseDTO(FocoIncendio focoIncendio) {
        return new FocoIncendioResponseDTO(focoIncendio.getId(), focoIncendio.getIntensidade(),focoIncendio.getStatus(), focoIncendio.getOrigem(), focoIncendio.getLocalizacao().getId(), focoIncendio.getCreatedAt());
    }

    public FocoIncendioResponseDTO save(FocoIncendioRequestDTO body) {
        Localizacao localizacao = localizacaoRepository.findById(body.localizacaoId()).orElseThrow(() -> new EntityNotFoundException("Localizacao não encontrada"));

        FocoIncendio focoIncendio = new FocoIncendio(null, null, body.intensidade(), body.origem(), body.status(), localizacao, null, null);

        FocoIncendio saved = focoIncendioRepository.save(focoIncendio);

        return  responseDTO(saved);
    }
}
