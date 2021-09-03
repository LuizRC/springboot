package br.org.estudos.backend.repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.org.estudos.backend.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	@Query("SELECT f FROM Funcionario f WHERE f.salario >= :valorMinimo AND f.salario <= :valorMaximo ")
	public Page<Funcionario> buscarSalarios(Double valorMinimo, Double valorMaximo, Pageable pageable); 

	public Page<Funcionario> findBySalarioBetween(Double valorMinimo, Double valorMaximo, Pageable pageable);
	
	@Query("SELECT f FROM Funcionario f WHERE UPPER(f.nome) LIKE UPPER(CONCAT('%',:paramNome,'%'))" )
	public Page<Funcionario> buscarPorNome(String paramNome, Pageable pageable);
	
	public Page<Funcionario> findByNomeContainingIgnoreCase(String paramNome, Pageable pageable);
	
	public Page<Funcionario> findByDataNascimentoGreaterThan(LocalDate paramDataNascimento, Pageable pageable);

}
