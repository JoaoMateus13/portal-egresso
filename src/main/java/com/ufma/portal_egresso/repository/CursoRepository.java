package com.ufma.portal_egresso.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ufma.portal_egresso.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
