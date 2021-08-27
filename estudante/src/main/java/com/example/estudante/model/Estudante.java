package com.example.estudante.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estudante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_estudante" )
	private Long id;
	private String name;
	private String email;
	private LocalDate nasc;
	
public Estudante() {
		
}

public Estudante(Long id, String name, String email, LocalDate nasc) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.nasc = nasc;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public LocalDate getNasc() {
	return nasc;
}

public void setNasc(LocalDate nasc) {
	this.nasc = nasc;
}

@Override
public String toString() {
	return "Estudante [id=" + id + ", name=" + name + ", email=" + email + ", nasc=" + nasc + "]";
}

}
