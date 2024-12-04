package com.ufma.portal_egresso.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufma.portal_egresso.model.Coordenador;

public interface CoordenadorRepository extends JpaRepository<Coordenador, Long> {


    Optional<Coordenador> findByLogin(String login);

}
