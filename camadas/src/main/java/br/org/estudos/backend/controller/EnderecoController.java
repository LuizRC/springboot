package br.org.estudos.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.estudos.backend.dto.EnderecoDTO;
import br.org.estudos.backend.model.Endereco;
import br.org.estudos.backend.service.EnderecoService;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoController {
	
	@Autowired
	private EnderecoService enderecoService;
	
	/*@GetMapping("{cep}")
	public ResponseEntity<Endereco> buscar(@PathVariable String cep){
		Endereco endereco = enderecoService.buscar(cep);
		if(endereco == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(endereco);
		}
		
	}*/
	
	@GetMapping("{cep}")
	public ResponseEntity<EnderecoDTO> buscar(@PathVariable String cep){
		EnderecoDTO enderecoDTO = enderecoService.buscar(cep);
		if(enderecoDTO == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(enderecoDTO);
		}
		
	}

}
