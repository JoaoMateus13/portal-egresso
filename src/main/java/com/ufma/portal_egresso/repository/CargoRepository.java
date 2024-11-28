package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    
}
