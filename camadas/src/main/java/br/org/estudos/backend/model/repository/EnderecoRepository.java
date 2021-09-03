package br.org.estudos.backend.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
	public Endereco findByCep(String cep);

}
