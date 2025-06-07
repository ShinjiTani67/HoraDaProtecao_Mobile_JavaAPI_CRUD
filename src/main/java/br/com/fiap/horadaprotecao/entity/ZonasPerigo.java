package br.com.fiap.horadaprotecao.entity

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

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
