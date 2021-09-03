package br.org.estudos.backend.dto;

import java.math.BigDecimal;

import br.org.estudos.backend.model.Vendedor;

public class VendedorDTO {
	
	private String nome;
	private BigDecimal totalGeral;
	
	public VendedorDTO() {
		
	}
	
	public VendedorDTO(Vendedor vendedor, BigDecimal totalGeral) {
		super();
		this.nome = vendedor.getNome();
		this.totalGeral = totalGeral;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getTotalGeral() {
		return totalGeral;
	}

	public void setTotalGeral(BigDecimal totalGeral) {
		this.totalGeral = totalGeral;
	}
	
	

}
