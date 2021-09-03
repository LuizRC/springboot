package br.org.estudos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, Long>{

}
