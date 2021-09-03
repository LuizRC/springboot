package br.org.estudos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
 

}
