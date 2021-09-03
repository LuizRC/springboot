package br.org.estudos.backend.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.org.estudos.backend.model.Lancamento;
import br.org.estudos.backend.model.Vendedor;

public class LancamentoDTO {
    private LocalDate dataLancamento;
	
	private BigDecimal total;
	
	private Vendedor vendedor;
	
	public LancamentoDTO() {
		
	}

	public LancamentoDTO(Lancamento lancamento) {
		super();
		this.dataLancamento = lancamento.getDataLancamento();
		this.total = lancamento.getTotal();
		this.vendedor = lancamento.getVendedor();
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
