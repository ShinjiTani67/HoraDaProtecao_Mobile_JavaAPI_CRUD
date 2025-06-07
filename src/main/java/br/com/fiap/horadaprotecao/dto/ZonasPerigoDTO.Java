package br.com.fiap.horadaprotecao.dto;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZonasPerigoDTO {

    @NotBlank(message = "ID é obrigatório")
    private String id;

    @NotBlank(message = "Nível de risco não é válido")
    private String nivelRisco;

    @NotNull(message = "Raio não é válido")
    private Double raioEmKm;
}
