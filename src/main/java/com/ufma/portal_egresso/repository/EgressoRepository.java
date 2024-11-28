package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.Egresso;

public interface EgressoRepository extends JpaRepository<Egresso, Long> {
    
}
