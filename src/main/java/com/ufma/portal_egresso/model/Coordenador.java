package com.ufma.portal_egresso.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "coordenador")
public class Coordenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_coordenador;

    private String login;

    private String senha;

    private String tipo;

    @OneToMany(mappedBy = "coordenador")
    private List<Curso> cursos = new ArrayList<>();

}
