package com.globalsolution.firemotion_app.controller.entidadeResposta;

import com.globalsolution.firemotion_app.domain.entidadeResposta.EntidadeResposta;
import com.globalsolution.firemotion_app.dto.entidadeResposta.EntidadeRespostaRequestDTO;
import com.globalsolution.firemotion_app.dto.entidadeResposta.EntidadeRespostaResponseDTO;
import com.globalsolution.firemotion_app.service.entidadeResposta.EntidadeRespostaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/entidades")
public class EntidadeRespostaController {

    private final EntidadeRespostaService entidadeRespostaService;

    public EntidadeRespostaController(EntidadeRespostaService entidadeRespostaService){
        this.entidadeRespostaService = entidadeRespostaService;
    }

    @GetMapping
    public ResponseEntity<List<EntidadeRespostaResponseDTO>> index(){
        List<EntidadeRespostaResponseDTO> entidades = entidadeRespostaService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(entidades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadeRespostaResponseDTO> show(@PathVariable Long id){
        EntidadeRespostaResponseDTO entidadeResposta = entidadeRespostaService.findById(id);

        return  ResponseEntity.status(HttpStatus.OK).body(entidadeResposta);
    }

    @PostMapping
    public ResponseEntity<EntidadeRespostaResponseDTO> create(@RequestBody EntidadeRespostaRequestDTO body){
        EntidadeRespostaResponseDTO entidadeResposta = entidadeRespostaService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(entidadeResposta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntidadeRespostaResponseDTO> update(@PathVariable Long id,@RequestBody EntidadeRespostaRequestDTO body){
        EntidadeRespostaResponseDTO entidadeResposta = entidadeRespostaService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(entidadeResposta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        entidadeRespostaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
}
