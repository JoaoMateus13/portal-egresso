package com.ufma.portal_egresso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ufma.portal_egresso.model.Curso;
import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.CursoEgressoId;
import com.ufma.portal_egresso.model.Egresso;
import com.ufma.portal_egresso.repository.CursoEgressoRepository;

@Service
public class CursoEgressoService {


    @Autowired
    private CursoEgressoRepository cursoEgressoRepository;


    @Transactional
    public CursoEgresso adicionarCursoEgresso(Egresso egresso, Curso curso, Integer anoInicio, Integer anoFim) {
        CursoEgresso cursoEgresso = new CursoEgresso();
        
        CursoEgressoId id = new CursoEgressoId(curso.getId_curso(), egresso.getId_egresso());
        cursoEgresso.setId(id);
        cursoEgresso.setCurso(curso);
        cursoEgresso.setEgresso(egresso);
        cursoEgresso.setAno_inicio(anoInicio);
        cursoEgresso.setAno_fim(anoFim);
        
        egresso.getCursoEgresso().add(cursoEgresso);
        curso.getCursoEgresso().add(cursoEgresso);
        
        return cursoEgressoRepository.save(cursoEgresso);
    }

}
