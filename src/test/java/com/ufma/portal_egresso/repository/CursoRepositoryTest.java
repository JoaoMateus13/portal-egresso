package com.ufma.portal_egresso.repository;

import java.util.Optional;

import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.repository.factory.Factory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class CursoRepositoryTest {

    @Autowired
    private CursoRepository repository;

    private Long totalCurso;

    @BeforeEach
    void setUp() throws Exception {
        totalCurso = repository.count();
    }

    @Test
    public void shouldVerifySaveCourse() {
        Curso curso = Factory.createCurso();
        curso.setId_curso(null); // Garante que o ID será gerado automaticamente

        repository.save(curso);

        Optional<Curso> result = repository.findById(curso.getId_curso());

        Assertions.assertTrue(result.isPresent());
    }
}
