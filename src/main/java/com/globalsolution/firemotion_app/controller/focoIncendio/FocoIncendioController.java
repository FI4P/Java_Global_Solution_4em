package com.globalsolution.firemotion_app.controller.focoIncendio;

import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioRequestDTO;
import com.globalsolution.firemotion_app.dto.focoIncendio.FocoIncendioResponseDTO;
import com.globalsolution.firemotion_app.service.focoIncendio.FocoIncendioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/incendios")
public class FocoIncendioController {

    private final FocoIncendioService focoIncendioService;

    public FocoIncendioController(FocoIncendioService focoIncendioService) {
        this.focoIncendioService = focoIncendioService;
    }


    @PostMapping
    public ResponseEntity<FocoIncendioResponseDTO> create(@RequestBody FocoIncendioRequestDTO body) {
        FocoIncendioResponseDTO focoIncendio = focoIncendioService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(focoIncendio);
    }


}
