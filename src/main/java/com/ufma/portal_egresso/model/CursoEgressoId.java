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
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CursoEgressoId that = (CursoEgressoId) o;

        if (!id_curso.equals(that.id_curso)) return false;
        return id_egresso.equals(that.id_egresso);
    }

    @Override
    public int hashCode() {
        int result = id_curso.hashCode();
        result = 31 * result + id_egresso.hashCode();
        return result;
    }
}

