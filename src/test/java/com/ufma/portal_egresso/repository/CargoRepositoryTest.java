package com.ufma.portal_egresso.repository;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ufma.portal_egresso.model.Cargo;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.factory.Factory;

@DataJpaTest
public class CargoRepositoryTest {

    @Autowired
    private CargoRepository repository;

    @Autowired
    private EgressoRepository egressoRepository;

    private Long totalCargo;

    @BeforeEach
    void setUp() throws Exception {
        totalCargo = repository.count();
    }

    @Test
    public void shouldVerifySaveCargo() {
        Egresso egresso = Factory.createEgresso();
        egressoRepository.save(egresso);


        Cargo cargo = Factory.createCargo();
        cargo.setEgresso(egresso);

        

        repository.save(cargo);

        Assertions.assertNotNull(cargo.getId_cargo());
        Assertions.assertEquals(totalCargo + 1, repository.count());

        Optional<Cargo> result = repository.findById(cargo.getId_cargo());

        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(cargo.getDescricao(), result.get().getDescricao());
        Assertions.assertEquals(cargo.getAno_fim(), result.get().getAno_fim());
    }

}
