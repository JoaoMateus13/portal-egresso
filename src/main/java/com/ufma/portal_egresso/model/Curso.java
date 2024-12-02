package com.ufma.portal_egresso.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "curso")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;

    private String nome;

    private String nivel;

    @OneToMany(mappedBy = "curso")
    private Set<CursoEgresso> cursoEgresso = new HashSet<>();


    @ManyToOne
    @JoinColumn(name = "id_coordenador")
    private Coordenador coordenador;

}