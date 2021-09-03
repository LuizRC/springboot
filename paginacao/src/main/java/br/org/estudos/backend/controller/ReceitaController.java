package br.org.estudos.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.estudos.backend.dto.ReceitaDTO;
import br.org.estudos.backend.model.Receita;
import br.org.estudos.backend.service.ReceitaService;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {
	
	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping("{cnpj}")
	public ResponseEntity<ReceitaDTO> buscar(@PathVariable String cnpj){
		ReceitaDTO receitaDTO = receitaService.buscar(cnpj);
		if(receitaDTO != null) {
			return ResponseEntity.ok(receitaDTO);
		}else {
			return ResponseEntity.notFound().build();
		
		}
		
	}

}
