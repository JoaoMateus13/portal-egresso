package com.ufma.portal_egresso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.EgressoRepository;

@Service
public class EgressoService {


    @Autowired
    private EgressoRepository egressoRepository;


    @Transactional(readOnly = true)
    public Page<Egresso> listarEgressos(Integer ano, Pageable pageable) {

        Page<Egresso> egressos = egressoRepository.findByAno(ano, pageable);


        return egressos;


    }



}
