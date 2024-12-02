package com.ufma.portal_egresso.repository.factory;

import com.ufma.portal_egresso.model.Cargo;
import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.CursoEgressoId;
import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.model.Egresso;

public class Factory {


    public static CursoEgresso createCursoEgresso(Curso curso, Egresso egresso) {
        CursoEgresso cursoEgresso = new CursoEgresso();

        cursoEgresso.setAno_fim(2021);
        cursoEgresso.setAno_inicio(2017);

        CursoEgressoId id = new CursoEgressoId();
        id.setId_curso(curso.getId_curso());
        id.setId_egresso(egresso.getId_egresso());
        cursoEgresso.setId(id);

        return cursoEgresso;
    }


    public static Egresso createEgresso() {
        Egresso egresso = new Egresso();

        
        egresso.setNome("João");
        egresso.setEmail("exemplo@gmail.com");
        egresso.setDescricao("Egresso do curso de Ciência da Computação");
        egresso.setFoto("foto.jpg");
        egresso.setLinkedin("linkedin.com");
        egresso.setInstagam("instagram.com");
        egresso.setCurriculo("curriculo.pdf");

        return egresso;
    }


    public static Curso createCurso() {
        Curso curso = new Curso();

        curso.setNome("BICT");
        curso.setNivel("Graduação");

        return curso;
    }



    public static Cargo createCargo() {
        Cargo cargo = new Cargo();

        cargo.setDescricao("Desenvolvedor de software");
        cargo.setLocal("São Luís");
        cargo.setAno_inicio(2021);
        cargo.setAno_fim(2021);

        return cargo;
    }


    public static Depoimento createDepoimento() {
        Depoimento depoimento = new Depoimento();

        depoimento.setTexto("Excelente curso");
        depoimento.setDate(java.time.LocalDate.now());

        return depoimento;
    }

}
