package com.ufma.portal_egresso.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.CursoEgressoRepository;
import com.ufma.portal_egresso.repository.CursoRepository;
import com.ufma.portal_egresso.repository.EgressoRepository;

@SpringBootTest
public class CursoEgressoServiceTests {

    @Autowired
    private CursoEgressoService cursoEgressoService;

    @Autowired
    private CursoEgressoRepository cursoEgressoRepository;

    @Autowired
    private CursoRepository cursoRepository;
    
    @Autowired 
    private EgressoRepository egressoRepository;

    private long totalCursoEgresso;

    @BeforeEach
    void setUp() {

        totalCursoEgresso = cursoEgressoRepository.count();

    }



    @Test
    public void shouldAdicionarCursoEgresso() {

        Egresso egresso = Factory.createEgresso();
        egresso = egressoRepository.save(egresso);
        
        Curso curso = Factory.createCurso();
        curso = cursoRepository.save(curso);
        

        CursoEgresso cursoEgresso = cursoEgressoService.adicionarCursoEgresso(egresso, curso, 2020, 2021);
        

        Assertions.assertNotNull(cursoEgresso);
        Assertions.assertEquals(totalCursoEgresso + 1, cursoEgressoRepository.count());
        Assertions.assertEquals(2020, cursoEgresso.getAno_inicio());
        Assertions.assertEquals(2021, cursoEgresso.getAno_fim());
        Assertions.assertEquals(egresso.getId_egresso(), cursoEgresso.getId().getId_egresso());
        Assertions.assertEquals(curso.getId_curso(), cursoEgresso.getId().getId_curso());

        Assertions.assertEquals(1, egresso.getCursoEgresso().size());
        Assertions.assertEquals(1, curso.getCursoEgresso().size());
    }

}
