package com.ufma.portal_egresso.repository;

import java.util.Optional;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.factory.Factory;

@DataJpaTest
public class DepoimentoRepositoryTest {

    @Autowired
    private DepoimentoRepository repository;

    @Autowired
    private EgressoRepository egressoRepository;

    private Long totalDepoimento;

    @BeforeEach
    void setUp() throws Exception {
        totalDepoimento = repository.count();
    }


    @Test
    public void shouldSaveDepoimento() {
        Egresso egresso = Factory.createEgresso();

        egressoRepository.save(egresso);

        Depoimento depoimento = Factory.createDepoimento();

        depoimento.setEgresso(egresso);

        repository.save(depoimento);

        Assertions.assertNotNull(depoimento.getId_depoimento());
        Assertions.assertEquals(totalDepoimento + 1, repository.count());

        Optional<Depoimento> result = repository.findById(depoimento.getId_depoimento());

        Assertions.assertTrue(result.isPresent());

        Assertions.assertEquals(depoimento.getTexto(), result.get().getTexto());
        Assertions.assertEquals(depoimento.getDate(), result.get().getDate());

    }


    @Test
    public void shouldDeleteDepoimento(){

        Egresso egresso = Factory.createEgresso();

        egressoRepository.save(egresso);

        Depoimento depoimento = Factory.createDepoimento();

        depoimento.setEgresso(egresso);

        repository.save(depoimento);

        Assertions.assertNotNull(depoimento.getId_depoimento());
        Assertions.assertEquals(totalDepoimento + 1, repository.count());

        repository.delete(depoimento);

        Assertions.assertEquals(totalDepoimento, repository.count());
    }


    @Test
    public void shouldUpdateDepoimento(){

        Egresso egresso = Factory.createEgresso();

        egressoRepository.save(egresso);

        Depoimento depoimento = Factory.createDepoimento();

        depoimento.setEgresso(egresso);

        repository.save(depoimento);

        Assertions.assertNotNull(depoimento.getId_depoimento());
        Assertions.assertEquals(totalDepoimento + 1, repository.count());

    
        
    }


    @Test
    public void shouldReturnNullWhenDepoimentoDoesNotExist() {
        
        Optional<Depoimento> result = repository.findById(0L);

        Assertions.assertFalse(result.isPresent());

    }


    @Test
    public void shouldReturnAllDepoimentos() {
        
        Iterable<Depoimento> depoimentos = repository.findAll();

        Assertions.assertNotNull(depoimentos);
        Assertions.assertEquals(totalDepoimento, repository.count());
    }

}