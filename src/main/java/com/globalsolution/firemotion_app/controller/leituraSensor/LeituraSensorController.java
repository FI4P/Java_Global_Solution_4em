package com.globalsolution.firemotion_app.controller.leituraSensor;


import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorRequestDTO;
import com.globalsolution.firemotion_app.dto.leituraSensor.LeituraSensorResponseDTO;
import com.globalsolution.firemotion_app.service.leituraSensor.LeituraSensorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leituras")
public class LeituraSensorController {

    private LeituraSensorService leituraSensorService;

    public  LeituraSensorController(LeituraSensorService leituraSensorService) {
        this.leituraSensorService = leituraSensorService;
    }

    @GetMapping
    public ResponseEntity<List<LeituraSensorResponseDTO>> index() {
        List<LeituraSensorResponseDTO> leituras =  leituraSensorService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(leituras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeituraSensorResponseDTO> index(@PathVariable Long id) {
        LeituraSensorResponseDTO leitura = leituraSensorService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(leitura);
    }

    @PostMapping
    public ResponseEntity<LeituraSensorResponseDTO> create(@RequestBody LeituraSensorRequestDTO body) {
        LeituraSensorResponseDTO leitura = leituraSensorService.save(body);

        return ResponseEntity.status(HttpStatus.CREATED).body(leitura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeituraSensorResponseDTO> update(@PathVariable Long id, @RequestBody LeituraSensorRequestDTO body) {
        LeituraSensorResponseDTO leitura = leituraSensorService.update(id, body);

        return ResponseEntity.status(HttpStatus.OK).body(leitura);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        leituraSensorService.delete(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
