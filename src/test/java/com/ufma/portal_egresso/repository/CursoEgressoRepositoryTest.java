package com.ufma.portal_egresso.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Assertions;
import java.util.Optional;

import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.factory.Factory;

@DataJpaTest
public class CursoEgressoRepositoryTest {

    @Autowired
    private CursoEgressoRepository repository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EgressoRepository egressoRepository;


    private Long totalCursoEgresso;

    @BeforeEach
    void setUp() throws Exception {
        totalCursoEgresso = repository.count();
    }


    @Test
    public void shouldVerifySaveCursoEgresso() {
        Curso curso = Factory.createCurso();
        cursoRepository.save(curso);

        Egresso egresso = Factory.createEgresso();
        egressoRepository.save(egresso);

        CursoEgresso cursoEgresso = Factory.createCursoEgresso(curso, egresso);

        repository.save(cursoEgresso);

        Assertions.assertNotNull(cursoEgresso.getId());
        Assertions.assertEquals(totalCursoEgresso + 1, repository.count());

        Optional<CursoEgresso> result = repository.findById(cursoEgresso.getId());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(cursoEgresso.getAno_fim(), result.get().getAno_fim());
        Assertions.assertEquals(cursoEgresso.getAno_inicio(), result.get().getAno_inicio());
    }

}
