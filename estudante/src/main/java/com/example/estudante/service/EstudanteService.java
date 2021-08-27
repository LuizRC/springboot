package com.example.estudante.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.estudante.model.Estudante;
import com.example.estudante.repository.EstudanteRepository;

@Service
public class EstudanteService {
	
private final EstudanteRepository estudanteRepository;
	
	@Autowired
	public EstudanteService(EstudanteRepository estudanteRepository) {
		this.estudanteRepository = estudanteRepository;
	}

	public List<Estudante> getEstudantes() {
		return estudanteRepository.findAll();
		
	}

	public void addNewEstudante(Estudante estudante) {
		Optional<Estudante> estudanteOptional = estudanteRepository.findEstudanteByEmail(estudante.getEmail());
		if(estudanteOptional.isPresent()) {
			throw new IllegalStateException("email existente");
		}
		estudanteRepository.save(estudante);
	}

	public void deleteEstudante(Long id) {

		boolean exists = estudanteRepository.existsById(id);
		if(!exists) {
			throw new IllegalStateException("estudante com id" + id + " não existe ");
		}
		estudanteRepository.deleteById(id);
	}
    
	
	public void updateEstudante(Long id, String name, String email) {
		Estudante estudante = estudanteRepository.findById(id)
				.orElseThrow(() -> new IllegalStateException(
						"estudante com id" + id + " não existe "
						));
		if(name != null && name.length() > 0 && !Objects.equals(estudante.getName(), name)) {
			estudante.setName(name);
		}
		
		if(email != null && email.length() > 0 && !Objects.equals(estudante.getEmail(), email)) {
			Optional<Estudante> estudanteOptional = estudanteRepository.findEstudanteByEmail(email);
			if(estudanteOptional.isPresent()) {
				throw new IllegalStateException("email existente");
			}
			estudante.setEmail(email);
		}
	}

}
