package br.com.fiap.horadaprotecao.controller;

@RestController
@RequestMapping("/zonasperigo")
@AllArgsConstructor
@Log
public class ZonasPerigoController {

    private final ZonasPerigoService service;

    @GetMapping
    public String listZonasPerigo(Model model) {
        var zonasPerigo = service.getFloodedZone();
        zonasPerigo.forEach(zp -> log.info("ID da zona de perigo: " + zp.getId()));
        model.addAttribute("zonasperigoList", zonasPerigo);
        return "zonasperigo";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "ZonasPerigo funcionando!";
    }

    @GetMapping("/new")
    public String newZonasPerigo(Model model) {
        model.addAttribute("zonasperigo", new ZonasPerigoDTO());
        return "zonasperigoformulario";
    }

    @PostMapping("/save")
    public String saveZonasPerigo(
            @Valid @ModelAttribute("zonasperigo") ZonasPerigoDTO zonasPerigoDTO,
            BindingResult bindingResult,
            Model model
    ) {
        if (bindingResult.hasErrors()) {
            log.warning("Erros de validação ao salvar zona de perigo:");
            bindingResult.getAllErrors().forEach(e -> log.warning(e.toString()));
            model.addAttribute("zonasperigo", zonasPerigoDTO);
            return "zonasperigoformulario";
        }

        log.info("Salvando zona de perigo: " + zonasPerigoDTO);
        service.save(zonasPerigoDTO);
        return "redirect:zonasperigo";
    }

    @GetMapping("/edit/{id}")
    public String editZonasPerigo(@PathVariable String id, Model model) {
        ZonasPerigoDTO zonasPerigo = service.findById(id);
        model.addAttribute("zonasperigo", zonasPerigo);
        return "zonasperigoformulario";
    }

    @GetMapping("/delete/{id}")
    public String deleteZonasPerigo(@PathVariable String id) {
        service.deleteById(id);
        return "redirect:zonasperigo";
    }
}
