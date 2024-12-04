package com.ufma.portal_egresso.repository;

import java.util.Optional;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Curso;

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
        public void shouldSaveCourse() {

                Curso curso = Factory.createCurso();

                repository.save(curso);

                Assertions.assertNotNull(curso.getId_curso());
                Assertions.assertEquals(totalCurso + 1, repository.count());

                Optional<Curso> result = repository.findById(curso.getId_curso());

                Assertions.assertTrue(result.isPresent());
                Assertions.assertEquals(curso.getNome(), result.get().getNome());
                Assertions.assertEquals(curso.getNivel(), result.get().getNivel());
        }

        @Test
        public void shouldDeleteCourse() {

                Curso curso = Factory.createCurso();

                repository.save(curso);

                Assertions.assertNotNull(curso.getId_curso());
                Assertions.assertEquals(totalCurso + 1, repository.count());

                repository.delete(curso);

                Assertions.assertEquals(totalCurso, totalCurso);
        }

        @Test
        public void shouldUpdateCourse() {

                Curso curso = Factory.createCurso();

                repository.save(curso);

                Assertions.assertNotNull(curso.getId_curso());
                Assertions.assertEquals(totalCurso + 1, repository.count());

                curso.setNome("Bacharelado em Ciência da Computação");
                curso.setNivel("Bacharelado");

                repository.save(curso);

                Optional<Curso> result = repository.findById(curso.getId_curso());

                Assertions.assertTrue(result.isPresent());
                Assertions.assertEquals(curso.getNome(), result.get().getNome());
                Assertions.assertEquals(curso.getNivel(), result.get().getNivel());
        }

        @Test
        public void shouldReturnNullWhenCourseDoesNotExist() {

                Optional<Curso> result = repository.findById(0L);

                Assertions.assertTrue(result.isEmpty());
        }

        @Test
        public void shouldReturnAllCourses() {

                Curso curso = Factory.createCurso();

                repository.save(curso);

                Assertions.assertNotNull(curso.getId_curso());
                Assertions.assertEquals(totalCurso + 1, repository.count());

                Iterable<Curso> result = repository.findAll();

                Assertions.assertTrue(result.iterator().hasNext());
        }

}
