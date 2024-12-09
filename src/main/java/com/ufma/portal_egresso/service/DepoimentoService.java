package com.ufma.portal_egresso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.repository.DepoimentoRepository;

@Service
public class DepoimentoService {


    @Autowired
    private DepoimentoRepository depoimentoRepository;



    public Page<Depoimento> listarDepoimentosRecentes(Pageable pageable) {

        Page<Depoimento> depoimentos = depoimentoRepository.findAllOrderByDate(pageable);

        return depoimentos;
    }

}
