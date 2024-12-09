package com.ufma.portal_egresso.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.ufma.portal_egresso.factory.Factory;
import com.ufma.portal_egresso.model.Cargo;
import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.CargoRepository;
import com.ufma.portal_egresso.repository.DepoimentoRepository;
import com.ufma.portal_egresso.repository.EgressoRepository;

@SpringBootTest
public class EgressoServiceTests {

    @Autowired
    private EgressoService egressoService;

    @Autowired
    private EgressoRepository egressoRepository;

    @Autowired
    private DepoimentoRepository depoimentoRepository;

    @Autowired
    private CargoRepository cargoRepository;
    

    private long totalEgressos;
    private long totalCargo;
    private long totalDepoimento;


    @BeforeEach
    void setUp() {

        totalEgressos = egressoRepository.count();
        totalDepoimento = depoimentoRepository.count();
        totalCargo = cargoRepository.count();


    }


    @Test
    public void manterEgressoShouldSaveEgresso() {
        
        Egresso egresso =  Factory.createEgresso();

        Egresso egresso2 = egressoService.ManterEgresso(egresso);

        Assertions.assertNotNull(egresso2);
        Assertions.assertEquals(egresso.getNome(), egresso2.getNome());
        Assertions.assertEquals(totalEgressos + 1, egressoRepository.count());
    }



    @Test
    public void shouldAdicionarDepoimentoEgresso(){

        Egresso egresso = Factory.createEgresso();

        Depoimento depoimento = Factory.createDepoimento();

        Egresso egresso2 =egressoService.adicionarDepoimentoEgresso(egresso, depoimento);

        Assertions.assertEquals(totalDepoimento + 1, depoimentoRepository.count());
        Assertions.assertEquals(1, egresso2.getDepoimentos().size());
        Assertions.assertEquals(depoimento.getTexto(), egresso2.getDepoimentos().get(0).getTexto());

    }


    @Test
    public void shouldAdicionarCargoEgresso(){
            
            Egresso egresso = Factory.createEgresso();
    
            Cargo cargo = Factory.createCargo();
    
            Egresso egresso2 =egressoService.adicionarCargoEgresso(egresso, cargo);

            Assertions.assertEquals(totalCargo + 1, cargoRepository.count());
            Assertions.assertEquals(1, egresso2.getCargos().size());
    }


    @Test
    public void ShouldReturnPageWhenPage0Size10(){

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<Egresso> result = egressoService.listarEgressos(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(10, result.getSize());

    }

    @Test
    @Transactional
    public void ShouldReturnPageOfEgressosByCursoNome() {
        String cursoNome = "Engenharia de Software";
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Egresso> result = egressoService.listarEgressosPorCursoNome(cursoNome, pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertTrue(result.stream().allMatch(e -> e.getCursoEgresso().stream().
                                    anyMatch(ce -> ce.getCurso().getNome().equals(cursoNome))));

    }

    @Test
    @Transactional
    public void ShouldReturnPageOfEgressosByCargo() {
        String descricao = "Desenvolvedor";
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Egresso> result = egressoService.listarEgressoPorCargo(descricao, pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(0, result.getNumber());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertTrue(result.stream().allMatch(e -> e.getCargos().stream().
                                    anyMatch(c -> c.getDescricao().equals(descricao))));

    }



}
