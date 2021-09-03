package br.org.estudos.backend.model;



import java.time.LocalDate;


import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.annotations.ApiModelProperty;


@MappedSuperclass
public class Pessoa {

	@NotBlank(message = "Nome não pode estar em branco")
	@ApiModelProperty(value= "Nome", required = true)
	protected String nome;
	
	@CPF(message = "CPF inválido")
	@NotBlank(message = "CPF não pode estar em branco")
	@ApiModelProperty(value= "CPF", required = true)
	protected String cpf;
	
	@Past(message = "Data inválida")
	@ApiModelProperty(value= "Data de Nascimento", required = true)
	protected LocalDate dataNasc;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

}
