package com.globalsolution.firemotion_app.controller.focoIncendio;

import com.globalsolution.firemotion_app.domain.focoIncendio.FocoIncendio;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioRequestDTO;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioResponseDTO;
import com.globalsolution.firemotion_app.service.focoIncendio.FocoIncendioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incendios")
public class FocoIncendioController {

    private final FocoIncendioService focoIncendioService;

    public FocoIncendioController(FocoIncendioService focoIncendioService) {
        this.focoIncendioService = focoIncendioService;
    }

    @GetMapping
    public ResponseEntity<List<FocoIncendioResponseDTO>> index() {
        List<FocoIncendioResponseDTO> focosIncendios = focoIncendioService.findAll();

        return ResponseEntity.status(HttpStatus.OK).body(focosIncendios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FocoIncendioResponseDTO> show(@PathVariable Long id) {
        FocoIncendioResponseDTO focoIncendio = focoIncendioService.findById(id);

        return  ResponseEntity.status(HttpStatus.OK).body(focoIncendio);
    }

    @PostMapping
    public ResponseEntity<FocoIncendioResponseDTO> create(@RequestBody FocoIncendioRequestDTO body) {
        FocoIncendioResponseDTO focoIncendio = focoIncendioService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(focoIncendio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FocoIncendioResponseDTO> update(@PathVariable Long id, @RequestBody FocoIncendioRequestDTO body) {
        FocoIncendioResponseDTO focoIncendio = focoIncendioService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(focoIncendio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        focoIncendioService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
