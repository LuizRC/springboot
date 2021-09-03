package br.org.estudos.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.org.estudos.backend.model.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long>{
	public Dependente findByCpf(String cpf);

}
