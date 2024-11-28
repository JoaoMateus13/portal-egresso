package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    

}
