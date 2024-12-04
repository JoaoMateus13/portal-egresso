package com.ufma.portal_egresso.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Coordenador;
import com.ufma.portal_egresso.repository.CoordenadorRepository;
import com.ufma.portal_egresso.repository.CursoRepository;
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

    @BeforeEach
    void setUp() {
        // Cria e salva um coordenador para teste
        Coordenador coordenador = Factory.createCoordenador();
        coordenador.setLogin("test");
        coordenador.setSenha("test");
        coordenadorRepository.save(coordenador);
    }

    // @Test
    // public void deveRetornarErro

    @Test
    public void deveEfectuarLogin() {
        Assertions.assertTrue(coordenadorService.efetuarLogin("admin", "admin"));
    }
}