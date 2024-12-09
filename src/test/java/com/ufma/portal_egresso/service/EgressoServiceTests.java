package com.ufma.portal_egresso.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Transactional;

import com.ufma.portal_egresso.model.Egresso;

@SpringBootTest
public class EgressoServiceTests {

    @Autowired
    private EgressoService egressoService;



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
