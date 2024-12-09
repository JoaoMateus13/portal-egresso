package com.ufma.portal_egresso.service;



import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import com.ufma.portal_egresso.model.Depoimento;

@SpringBootTest
public class DepoimentoServiceTests {


    @Autowired
    private DepoimentoService depoimentoService;



    @Test
    public void ShouldReturnPageOfDepoimentosRecents(){

        PageRequest pageRequest = PageRequest.of(0, 10);

        Page<Depoimento> result = depoimentoService.listarDepoimentosRecentes(pageRequest);

        Assertions.assertFalse(result.isEmpty());
        Assertions.assertTrue(result.getContent().get(0).getDate().isAfter(result.getContent().get(1).getDate()));

    }



}
