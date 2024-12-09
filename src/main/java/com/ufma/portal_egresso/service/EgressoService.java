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
    public Page<Egresso> listarEgressos(Pageable pageable) {

        Page<Egresso> egressos = egressoRepository.findAll(pageable);

        return egressos;
    }

    @Transactional(readOnly = true)
    public Page<Egresso> listarEgressosPorCursoNome(String cursoNome, Pageable pageable) {
        return egressoRepository.findByCursoNome(cursoNome, pageable);
    }


    @Transactional(readOnly = true)
    public Page<Egresso> listarEgressoPorCargo(String descricao, Pageable pageable) {
        return egressoRepository.findByCargo(descricao, pageable);
    }





}
