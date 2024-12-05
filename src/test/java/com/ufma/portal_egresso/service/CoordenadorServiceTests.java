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


    @Test
    public void manterEgressoShouldSaveEgresso() {
        
        Egresso egresso =  Factory.createEgresso();

        Egresso egresso2 = coordenadorService.ManterEgresso(egresso);


        Assertions.assertNotNull(egresso2);
        Assertions.assertEquals(egresso.getNome(), egresso2.getNome());
        Assertions.assertEquals(totalEgressos + 1, egressoRepository.count());
    }

    @Test
    public void manterCursoShouldSaveCurso() {
        
        Curso curso =  Factory.createCurso();

        Curso curso2 = coordenadorService.ManterCurso(curso);

        Assertions.assertNotNull(curso2);
        Assertions.assertEquals(curso.getNome(), curso2.getNome());
        Assertions.assertEquals(totalCursos + 1, cursoRepository.count());

    }


    @Test
    public void shouldAdicionarDepoimentoEgresso(){

        Egresso egresso = Factory.createEgresso();

        Depoimento depoimento = Factory.createDepoimento();

        Egresso egresso2 =coordenadorService.adicionarDepoimentoEgresso(egresso, depoimento);

        Assertions.assertEquals(totalDepoimento + 1, depoimentoRepository.count());
        Assertions.assertEquals(1, egresso2.getDepoimentos().size());
        Assertions.assertEquals(depoimento.getTexto(), egresso2.getDepoimentos().get(0).getTexto());

    }

    @Test
    public void shouldAdicionarCargoEgresso(){
            
            Egresso egresso = Factory.createEgresso();
    
            Cargo cargo = Factory.createCargo();
    
            Egresso egresso2 =coordenadorService.adicionarCargoEgresso(egresso, cargo);

            Assertions.assertEquals(totalCargo + 1, cargoRepository.count());
            Assertions.assertEquals(1, egresso2.getCargos().size());
    }

    @Test
    public void shouldAdicionarCursoEgresso() {

        Egresso egresso = Factory.createEgresso();
        egresso = egressoRepository.save(egresso);
        
        Curso curso = Factory.createCurso();
        curso = cursoRepository.save(curso);
        

        CursoEgresso cursoEgresso = coordenadorService.adicionarCursoEgresso(egresso, curso, 2020, 2021);
        

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