package br.org.estudos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Foto;

public interface FotoRepository extends JpaRepository<Foto, Long>{

}
