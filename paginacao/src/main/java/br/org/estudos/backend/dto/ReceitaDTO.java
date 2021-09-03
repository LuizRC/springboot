package br.org.estudos.backend.dto;

import br.org.estudos.backend.model.Receita;

public class ReceitaDTO {
	private Long id;
	private String nome;
	private String fantasia;
	
	public ReceitaDTO(){	
		
	}
	
	public ReceitaDTO(Receita receita) {
		super();
		this.id = receita.getId();
		this.nome = receita.getNome();
		this.fantasia = receita.getFantasia();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFantasia() {
		return fantasia;
	}

	public void setFantasia(String fantasia) {
		this.fantasia = fantasia;
	}

}
