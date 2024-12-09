package com.ufma.portal_egresso.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ufma.portal_egresso.model.Cargo;
import com.ufma.portal_egresso.model.Coordenador;
import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.CursoEgressoId;
import com.ufma.portal_egresso.model.Depoimento;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.CoordenadorRepository;
import com.ufma.portal_egresso.repository.CursoEgressoRepository;
import com.ufma.portal_egresso.repository.CursoRepository;
import com.ufma.portal_egresso.repository.EgressoRepository;
import com.ufma.portal_egresso.service.expections.ResourceNotFoundException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EgressoRepository egressoRepository;

    @Autowired
    private CursoEgressoRepository cursoEgressoRepository;

    @Transactional
    public boolean efetuarLogin(String login, String senha) {

        Optional<Coordenador> coordenador = coordenadorRepository.findByLogin(login);

        
        if (coordenador.isPresent()) {
            if (!coordenador.get().getSenha().equals(senha))
                throw new IllegalArgumentException("Senha incorreta");
        }
        
        else{
            throw new ResourceNotFoundException("Coordenador não encontrado");
        }

        return true;
    }
}



