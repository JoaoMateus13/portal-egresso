package com.ufma.portal_egresso.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.lang.IllegalArgumentException;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Cargo;
import com.ufma.portal_egresso.model.Coordenador;
import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.repository.CargoRepository;
import com.ufma.portal_egresso.repository.CoordenadorRepository;
import com.ufma.portal_egresso.repository.CursoEgressoRepository;
import com.ufma.portal_egresso.repository.CursoRepository;
import com.ufma.portal_egresso.repository.DepoimentoRepository;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.EgressoRepository;

@SpringBootTest
public class CoordenadorServiceTests {

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EgressoRepository egressoRepository;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CursoEgressoRepository cursoEgressoRepository;

    private long totalEgressos;
    private long totalCursos;
    private long totalDepoimento;
    private long totalCargo;
    private long totalCursoEgresso;

    @BeforeEach
    void setUp() {

        totalEgressos = egressoRepository.count();
        totalCursos = cursoRepository.count();
        totalDepoimento = depoimentoRepository.count();
        totalCargo = cargoRepository.count();
        totalCursoEgresso = cursoEgressoRepository.count();

    }

    @Test
    public void loginSuccessShouldReturnTrue() {
        Coordenador coordenador = Factory.createCoordenador("test", "test");

        coordenadorRepository.save(coordenador);

        Assertions.assertTrue(coordenadorService.efetuarLogin("test", "test"));
    }

    @Test
    public void loginFailurehouldReturnExeptionIllegalArgument() {

        Coordenador coordenador = Factory.createCoordenador("test2", "test");

        coordenadorRepository.save(coordenador);

        Assertions.assertThrows(IllegalArgumentException.class, () ->
         coordenadorService.efetuarLogin("test2", "wrong"));
    }

}