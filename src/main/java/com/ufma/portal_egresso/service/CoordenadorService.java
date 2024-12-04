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
import com.ufma.portal_egresso.repository.CursoRepository;
import com.ufma.portal_egresso.repository.EgressoRepository;
import com.ufma.portal_egresso.service.expections.ResourceNotFoundException;

import jakarta.transaction.Transactional;

@Service
public class CoordenadorService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private EgressoRepository egressoRepository;

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
    private Curso ManterCurso (Curso CursoDTO){

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
    public Egresso adicionarDepoimentoEgresso(Egresso egressoDTO, Depoimento depoimentoDTO) {

        egressoDTO.getDepoimentos().add(depoimentoDTO);

        return egressoRepository.save(egressoDTO);

    }

    @Transactional
    public Egresso adicionarCargoEgresso(Egresso egressoDTO, Cargo cargoDTO) {


        egressoDTO.getCargos().add(cargoDTO);

        return egressoRepository.save(egressoDTO);

    }

    @Transactional
    public CursoEgresso adicionarCursoEgresso(Egresso egressoDTO, Curso cursoDTO) {
        
        CursoEgresso cursoEgresso = new CursoEgresso();

        CursoEgressoId id = new CursoEgressoId();

        id.setId_curso(cursoDTO.getId_curso());
        id.setId_egresso(egressoDTO.getId_egresso());

        cursoEgresso.setId(id);

        cursoEgresso.setCurso(cursoDTO);
        cursoEgresso.setEgresso(egressoDTO);
        cursoEgresso.setAno_inicio(2014);
        cursoEgresso.setAno_fim(2018);

        

        return cursoEgresso;

    }









    

    

}
