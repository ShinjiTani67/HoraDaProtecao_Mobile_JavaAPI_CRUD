package br.com.fiap.horadaprotecao.controller;

import br.com.fiap.horadaprotecao.dto.ZonasPerigoDTO;
import br.com.fiap.horadaprotecao.service.ZonasPerigoService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Log
public class ZonasPerigoController {

    private final ZonasPerigoService service;

    @GetMapping
    public ResponseEntity<List<ZonasPerigoDTO>> listZonasPerigo() {
        List<ZonasPerigoDTO> zonasPerigo = service.getFloodedZone();
        zonasPerigo.forEach(zp -> log.info("ID da zona de perigo: " + zp.getId()));
        return ResponseEntity.ok(zonasPerigo);
    }


    @PostMapping
    public ResponseEntity<?> saveZonasPerigo(@Valid @RequestBody ZonasPerigoDTO zonasPerigoDTO) {
        try {
            log.info("Salvando zona de perigo: " + zonasPerigoDTO);
            var saved = service.save(zonasPerigoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            log.warning("Erro ao salvar zona de perigo: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao salvar zona de perigo");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ZonasPerigoDTO> getZonasPerigoById(@PathVariable String id) {
        var zonasPerigo = service.findById(id);
        return ResponseEntity.ok(zonasPerigo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteZonasPerigo(@PathVariable String id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
