package com.example.estudante.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.estudante.model.Estudante;


@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Long> {
	Optional<Estudante> findEstudanteByEmail(String email);

}
