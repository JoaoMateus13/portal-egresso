package com.ufma.portal_egresso.repository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Coordenador;
import com.ufma.portal_egresso.model.Curso;


@DataJpaTest
public class CoordenadorRepositoryTest {

    @Autowired
    private CoordenadorRepository repository;

    @Autowired
    private CursoRepository cursoRepository;


    private Long totalCoordenador;


    @BeforeEach
    void setUp() throws Exception {
        totalCoordenador = repository.count();
    }

    @Test
    public void shouldSaveCoordenador() {

        Curso curso = Factory.createCurso();

        cursoRepository.save(curso);

        Coordenador coordenador = Factory.createCoordenador("test", "test");

        coordenador.getCursos().add(curso);

        repository.save(coordenador);

        Assertions.assertNotNull(coordenador.getId_coordenador());
        Assertions.assertEquals(totalCoordenador + 1, repository.count());

        Optional<Coordenador> result = repository.findById(coordenador.getId_coordenador());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(coordenador.getLogin(), result.get().getLogin());
    }

    @Test
    public void shouldDeleteCoordenador(){

        Curso curso = Factory.createCurso();

        cursoRepository.save(curso);

        Coordenador coordenador = Factory.createCoordenador("test", "test");

        coordenador.getCursos().add(curso);

        repository.save(coordenador);

        repository.delete(coordenador);

        Assertions.assertEquals(totalCoordenador, repository.count());
    }


    @Test
    public void shouldUpdateCoordenador(){

        Curso curso = Factory.createCurso();

        cursoRepository.save(curso);

        Coordenador coordenador = Factory.createCoordenador("test", "test");

        coordenador.getCursos().add(curso);

        repository.save(coordenador);

        Assertions.assertNotNull(coordenador.getId_coordenador());
        Assertions.assertEquals(totalCoordenador + 1, repository.count());

        coordenador.setLogin("login");

        repository.save(coordenador);

        Optional<Coordenador> result = repository.findById(coordenador.getId_coordenador());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(coordenador.getLogin(), result.get().getLogin());
    }

    @Test
    public void shouldReturnNullWhenCoordenadorDoesNotExist(){
            
            Optional<Coordenador> result = repository.findById(0L);
    
            Assertions.assertTrue(result.isEmpty());
    }


    @Test
    public void shouldReturnAllCoordenador(){
            
            Curso curso = Factory.createCurso();

            cursoRepository.save(curso);

            Coordenador coordenador = Factory.createCoordenador("test", "test");

            coordenador.getCursos().add(curso);

            repository.save(coordenador);

            Assertions.assertEquals(totalCoordenador+1, repository.count());
    }

}
