package br.com.fiap.horadaprotecao.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

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
