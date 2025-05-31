package com.globalsolution.firemotion_app.controller.respostaIncendio;


import com.globalsolution.firemotion_app.domain.respostaIncendio.RespostaIncendio;
import com.globalsolution.firemotion_app.dto.respostaIncendio.RespostaIncendioRequestDTO;
import com.globalsolution.firemotion_app.dto.respostaIncendio.RespostaIncendioResponseDTO;
import com.globalsolution.firemotion_app.service.respostaIncendio.RespostaIncendioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/respostas")
public class RespostaIncendioController {

    private RespostaIncendioService respostaIncendioService;

    public RespostaIncendioController(RespostaIncendioService respostaIncendioService){
        this.respostaIncendioService = respostaIncendioService;
    }

    @GetMapping
    public ResponseEntity<List<RespostaIncendioResponseDTO>> index(){
        List<RespostaIncendioResponseDTO> respostasIncendios = respostaIncendioService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(respostasIncendios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RespostaIncendioResponseDTO> show(@PathVariable Long id){
        RespostaIncendioResponseDTO resposta = respostaIncendioService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(resposta);
    }

    @PostMapping
    public ResponseEntity<RespostaIncendioResponseDTO> create(@RequestBody RespostaIncendioRequestDTO body){
        RespostaIncendioResponseDTO resposta = respostaIncendioService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);

    }

    @PutMapping("/{id}")
    public ResponseEntity<RespostaIncendioResponseDTO> update(@PathVariable Long id, @RequestBody RespostaIncendioRequestDTO body){
        RespostaIncendioResponseDTO resposta = respostaIncendioService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(resposta);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        respostaIncendioService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
