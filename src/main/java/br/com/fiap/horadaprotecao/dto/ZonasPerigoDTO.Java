package br.com.fiap.horadaprotecao.dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonasPerigoDTO{
  @NotBlank(message = "ID é obrigatório")
    private UUID uuid;

    @NotBlank(message = "nivel de risco não valido")
    private String nivelRisco;

    @NotBlank(message = "Raio não é valido")
    private Double raioEmKm;
}
