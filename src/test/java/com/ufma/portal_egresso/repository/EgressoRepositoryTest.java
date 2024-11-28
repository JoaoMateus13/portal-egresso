package com.ufma.portal_egresso.repository;



import org.junit.jupiter.api.BeforeEach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest
public class EgressoRepositoryTest {

    @Autowired
    private EgressoRepository repository;

    private Long totalEgresso;

    @BeforeEach
    void setUp() throws Exception {
        totalEgresso = repository.count();
    }
}
