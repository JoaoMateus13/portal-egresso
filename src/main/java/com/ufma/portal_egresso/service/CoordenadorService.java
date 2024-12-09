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


    @Transactional
    public Curso ManterCurso (Curso CursoDTO){

        Curso curso = new Curso();

        curso.setNome(CursoDTO.getNome());
        curso.setNivel(CursoDTO.getNivel());
        curso.setCoordenador(CursoDTO.getCoordenador());

        return cursoRepository.save(curso);
    }


    @Transactional
    public Egresso ManterEgresso (Egresso egressoDTO){
            
        Egresso egresso = new Egresso();

        egresso.setNome(egressoDTO.getNome());
        egresso.setEmail(egressoDTO.getEmail());
        egresso.setDescricao(egressoDTO.getDescricao());
        egresso.setFoto(egressoDTO.getFoto());
        egresso.setLinkedin(egressoDTO.getLinkedin());
        egresso.setInstagram(egressoDTO.getInstagram());
        egresso.setCurriculo(egressoDTO.getCurriculo());

        return egressoRepository.save(egresso);
    }


    @Transactional
    public Egresso adicionarDepoimentoEgresso(Egresso egresso, Depoimento depoimento) {

  
        egresso.getDepoimentos().add(depoimento);


        return egressoRepository.save(egresso);

    }

    @Transactional
    public Egresso adicionarCargoEgresso(Egresso egressoDTO, Cargo cargoDTO) {


        egressoDTO.getCargos().add(cargoDTO);

        return egressoRepository.save(egressoDTO);

    }

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



