package com.ufma.portal_egresso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;



    @Transactional
    public Curso ManterCurso (Curso CursoDTO){

        Curso curso = new Curso();

        curso.setNome(CursoDTO.getNome());
        curso.setNivel(CursoDTO.getNivel());
        curso.setCoordenador(CursoDTO.getCoordenador());

        return cursoRepository.save(curso);
    }

}
