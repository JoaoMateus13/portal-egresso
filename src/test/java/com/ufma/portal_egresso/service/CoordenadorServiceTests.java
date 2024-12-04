package com.ufma.portal_egresso.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.IllegalArgumentException;
import java.lang.foreign.Linker.Option;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Coordenador;
import com.ufma.portal_egresso.repository.CoordenadorRepository;
import com.ufma.portal_egresso.repository.CursoRepository;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.EgressoRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

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

    private long totalEgressos;

    @BeforeEach
    void setUp() {
        // Cria e salva um coordenador para teste
        Coordenador coordenador = Factory.createCoordenador();
        coordenador.setLogin("test");
        coordenador.setSenha("test");
        coordenadorRepository.save(coordenador);

        totalEgressos = egressoRepository.count();


    }

    @Test
    public void loginSuccessShouldReturnTrue() {
        Assertions.assertTrue(coordenadorService.efetuarLogin("test", "test"));
    }

    @Test
    public void loginFailurehouldReturnExeptionIllegalArgument() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
         coordenadorService.efetuarLogin("test", "wrong"));
    }


    @Test
    public void shouldSaveEgresso() {
        
        Egresso egresso =  Factory.createEgresso();

        Egresso egresso2 = coordenadorService.ManterEgresso(egresso);


        Assertions.assertNotNull(egresso2);
        Assertions.assertEquals(egresso.getNome(), egresso2.getNome());
        Assertions.assertEquals(totalEgressos + 1, egressoRepository.count());
    }
}