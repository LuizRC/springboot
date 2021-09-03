package br.org.estudos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	public Cliente findByNome(String nome);

}
