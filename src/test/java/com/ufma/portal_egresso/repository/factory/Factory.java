package com.ufma.portal_egresso.repository.factory;

import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.Egresso;

public class Factory {


    public static CursoEgresso createCursoEgresso() {
        CursoEgresso cursoEgresso = new CursoEgresso();

        cursoEgresso.setAno_fim(2021);
        cursoEgresso.setAno_inicio(2017);
        cursoEgresso.setCurso(createCurso());
        cursoEgresso.setEgresso(createEgresso());

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

}
