package br.com.fiap.horadaprotecao.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "tb_zonasperigo")
public class ZonasPerigo{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "CHAR(36)")
    private String Id;

    private String nivelRisco;

    private Double raioEmKm;
  }
