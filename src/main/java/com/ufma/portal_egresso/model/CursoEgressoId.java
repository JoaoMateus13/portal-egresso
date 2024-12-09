package com.ufma.portal_egresso.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class CursoEgressoId implements Serializable{

    @Column(name = "id_curso")
    private Long id_curso;

    @Column(name = "id_egresso")
    private Long id_egresso; 

    public CursoEgressoId() {
    }

    public CursoEgressoId(Long idCurso, Long idEgresso) {
        this.id_curso = idCurso;
        this.id_egresso = idEgresso;
    }
    
}


