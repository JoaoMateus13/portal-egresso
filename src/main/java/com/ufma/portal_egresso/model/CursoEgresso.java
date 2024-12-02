package com.ufma.portal_egresso.model;



import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "curso_egresso")
public class CursoEgresso {

    @EmbeddedId
    private CursoEgressoId id;

    @ManyToOne
    @MapsId("id_curso")
    @JoinColumn(name = "id_curso")
    private Curso curso;


    @ManyToOne
    @MapsId("id_egresso")
    @JoinColumn(name = "id_egresso")
    private Egresso egresso;


    private Integer ano_inicio;


    private Integer ano_fim;




    

}
