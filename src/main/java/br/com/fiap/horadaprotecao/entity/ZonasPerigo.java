package br.com.fiap.horadaprotecao.entity

@Data
@Entity
@ToString
@Table(name = "tb_zonasperigo")
public class ZonasPerigo{
    @Id
    private String Id;
    private String nivelRisco;
    private Double raioEmkm;
  }
