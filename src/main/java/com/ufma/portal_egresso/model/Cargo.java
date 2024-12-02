package com.ufma.portal_egresso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cargo;

    private String descricao;

    private String local;

    private Integer ano_inicio;

    private Integer ano_fim;

    @ManyToOne
    @JoinColumn(name = "id_egresso")
    private Egresso egresso;

}
