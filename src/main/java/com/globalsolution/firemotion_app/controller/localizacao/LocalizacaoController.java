package com.globalsolution.firemotion_app.controller.localizacao;

import com.globalsolution.firemotion_app.dto.localizacao.LocalizacaoRequestDTO;
import com.globalsolution.firemotion_app.dto.localizacao.LocalizacaoResponseDTO;
import com.globalsolution.firemotion_app.service.localizacao.LocalizacaoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("api/v1/localizacoes")
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    @GetMapping
    public ResponseEntity<List<LocalizacaoResponseDTO>> index(){
        List<LocalizacaoResponseDTO> localizacoes = localizacaoService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(localizacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> show(@PathVariable Long id) {
        LocalizacaoResponseDTO localizacao = localizacaoService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(localizacao);
    }

    @PostMapping
    public ResponseEntity<LocalizacaoResponseDTO> create(@RequestBody  LocalizacaoRequestDTO body) {
        LocalizacaoResponseDTO localizacao = localizacaoService.save(body);

        return ResponseEntity.status(HttpStatus.OK).body(localizacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocalizacaoResponseDTO> update(@PathVariable Long id, @RequestBody LocalizacaoRequestDTO body) {
        LocalizacaoResponseDTO localizacao = localizacaoService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(localizacao);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        localizacaoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
