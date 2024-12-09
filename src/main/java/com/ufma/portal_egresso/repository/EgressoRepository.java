package com.ufma.portal_egresso.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ufma.portal_egresso.model.Egresso;

@Repository
public interface EgressoRepository extends JpaRepository<Egresso, Long> {


    @Query("SELECT e FROM Egresso e" +
            "WHERE e.ano = :ano")
    Page<Egresso> findByAno(Integer ano, Pageable pageable);
    
}
