package com.ufma.portal_egresso.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
@Table(name = "egresso")
public class Egresso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_egresso;

    private String nome;

    private String email;

    private String descricao;

    private String foto;

    private String linkedin;

    private String instagam;

    private String curriculo;

    @OneToMany(mappedBy = "egresso", cascade = CascadeType.ALL)
    private List<Cargo> cargos = new ArrayList<>();


    @OneToMany(mappedBy = "egresso")
    private List<Depoimento> depoimentos = new ArrayList<>();


    @OneToMany(mappedBy = "egresso")
    private Set<CursoEgresso> cursoEgresso = new HashSet<>();

}
