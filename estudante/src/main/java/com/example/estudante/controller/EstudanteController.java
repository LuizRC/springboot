package com.example.estudante.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.estudante.model.Estudante;
import com.example.estudante.service.EstudanteService;



@RestController
@RequestMapping(path = "estudante")
public class EstudanteController {

@Autowired
private final EstudanteService estudanteService;
	
	@Autowired
	public EstudanteController(EstudanteService estudanteService) {
		this.estudanteService = estudanteService;
	}

	@GetMapping
	public List<Estudante> getEstudantes() {
		return estudanteService.getEstudantes();	
	}
	
	@PostMapping
	public void registerNewEstudante(@RequestBody Estudante estudante) {
		estudanteService.addNewEstudante(estudante);
	}
	
	@DeleteMapping(path = "{id}")
	public void deleteEstudante(@PathVariable("id") Long id) {
		estudanteService.deleteEstudante(id);
		
	}
	
	@PutMapping(path = "{id}")
	public void updateEstudante(@PathVariable("id") Long id, 
			@RequestParam(required = false) String name,
	        @RequestParam(required = false) String email){
		estudanteService.updateEstudante(id, name, email);
	}

}
