package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.Depoimento;

public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
    
}
