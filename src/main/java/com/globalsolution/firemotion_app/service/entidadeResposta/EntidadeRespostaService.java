package com.globalsolution.firemotion_app.service.entidadeResposta;


import com.globalsolution.firemotion_app.domain.entidadeResposta.EntidadeResposta;
import com.globalsolution.firemotion_app.dto.entidadeResposta.EntidadeRespostaRequestDTO;
import com.globalsolution.firemotion_app.dto.entidadeResposta.EntidadeRespostaResponseDTO;
import com.globalsolution.firemotion_app.repository.entidadeResposta.EntidadeRespostaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntidadeRespostaService {

    private final EntidadeRespostaRepository entidadeRespostaRepository;

    public EntidadeRespostaService(EntidadeRespostaRepository entidadeRespostaRepository ) {
        this.entidadeRespostaRepository = entidadeRespostaRepository;
    }

    public EntidadeRespostaResponseDTO responseDTO(EntidadeResposta entidadeResposta) {
        return  new EntidadeRespostaResponseDTO(entidadeResposta.getId(),entidadeResposta.getNome(),entidadeResposta.getTipo(), entidadeResposta.getContato());
    }


    public List<EntidadeRespostaResponseDTO> findAll(){
        List<EntidadeResposta> entidades =  entidadeRespostaRepository.findAll();

        return entidades.stream().map(this::responseDTO).toList();
    }

    public EntidadeRespostaResponseDTO findById(Long id) {
        EntidadeResposta entidade = entidadeRespostaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrada"));

        return  responseDTO(entidade);
    }

    public EntidadeRespostaResponseDTO save(EntidadeRespostaRequestDTO body){
        EntidadeResposta entidade = new EntidadeResposta(null, body.nome(), body.tipo(), body.contato());

        EntidadeResposta saved = entidadeRespostaRepository.save(entidade);

        return responseDTO(saved);
    }

    public EntidadeRespostaResponseDTO update(Long id, EntidadeRespostaRequestDTO body){
        EntidadeResposta entidade = entidadeRespostaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(("Não encontrado")));

        entidade.setNome(body.nome() != null ? body.nome() : entidade.getNome());
        entidade.setTipo(body.tipo() != null ? body.tipo() : entidade.getTipo());
        entidade.setContato(body.contato() != null ? body.contato() : entidade.getContato());

        EntidadeResposta updated = entidadeRespostaRepository.save(entidade);

        return responseDTO(updated);
    }

    public void delete(Long id){
        entidadeRespostaRepository.deleteById(id);
    }





}
