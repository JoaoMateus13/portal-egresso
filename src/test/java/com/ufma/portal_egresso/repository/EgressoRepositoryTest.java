package com.ufma.portal_egresso.repository;



import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.factory.Factory;


@DataJpaTest
public class EgressoRepositoryTest {

    @Autowired
    private EgressoRepository repository;

    private Long totalEgresso;

    @BeforeEach
    void setUp() throws Exception {
        totalEgresso = repository.count();
    }


    @Test
    public void shouldVerifySaveEgresso() {

        Egresso egresso = Factory.createEgresso();
        
        repository.save(egresso);

        Assertions.assertNotNull(egresso.getId_egresso());
        Assertions.assertEquals(totalEgresso + 1, repository.count());
        
        Optional<Egresso> result = repository.findById(egresso.getId_egresso());
        
        Assertions.assertTrue(result.isPresent());
        Assertions.assertEquals(egresso.getNome(), result.get().getNome());
        Assertions.assertEquals(egresso.getEmail(), result.get().getEmail());
    }
    
    @Test
    public void shouldVerifyDeleteEgresso(){
            
            Egresso egresso = Factory.createEgresso();
            
            repository.save(egresso);
    
            Assertions.assertNotNull(egresso.getId_egresso());
            Assertions.assertEquals(totalEgresso + 1, repository.count());
            
            repository.delete(egresso);
            
            Assertions.assertEquals(totalEgresso, repository.count());
    }

    @Test
    public void shouldVerifyUpdateEgresso(){
            
            Egresso egresso = Factory.createEgresso();
            
            repository.save(egresso);
    
            Assertions.assertNotNull(egresso.getId_egresso());
            Assertions.assertEquals(totalEgresso + 1, repository.count());
            
            
            egresso.setNome("Nome Atualizado");
            egresso.setEmail("jose@exemplo.com");
            repository.save(egresso);
            
            Optional<Egresso> result = repository.findById(egresso.getId_egresso());

            Assertions.assertTrue(result.isPresent());
            Assertions.assertEquals(egresso.getNome(), result.get().getNome());
            Assertions.assertEquals(egresso.getEmail(), result.get().getEmail());

    }
}
