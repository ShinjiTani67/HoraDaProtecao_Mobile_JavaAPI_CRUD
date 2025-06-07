package br.com.fiap.horadaprotecao.controller;

@RestController
@RequestMapping("/zonasperigo")
@AllArgsConstructor
@Log
public class ZonasPerigoController {

    private final ZonasPerigoService service;

    @GetMapping
    public ResponseEntity<List<ZonasPerigoDTO>> listZonasPerigo() {
        var zonasPerigo = service.getFloodedZone();
        zonasPerigo.forEach(zp -> log.info("ID da zona de perigo: " + zp.getId()));
        return ResponseEntity.ok(zonasPerigo);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("ZonasPerigo funcionando!");
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
