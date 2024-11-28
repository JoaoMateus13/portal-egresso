package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.CursoEgresso;
import com.ufma.portal_egresso.model.CursoEgressoId;

public interface CursoEgressoRepository extends JpaRepository<CursoEgresso, CursoEgressoId> {

    
}
