package br.org.estudos.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.org.estudos.backend.dto.VendedorDTO;
import br.org.estudos.backend.model.Lancamento;
import br.org.estudos.backend.model.Vendedor;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	@Query("SELECT new br.org.estudos.backend.dto.VendedorDTO(l.vendedor, SUM(l.total)) FROM Lancamento l GROUP BY l.vendedor")
	public List<VendedorDTO> totalPorVendedor();

}
