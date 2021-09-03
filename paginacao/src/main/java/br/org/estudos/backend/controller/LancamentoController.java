package br.org.estudos.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.estudos.backend.dto.VendedorDTO;
import br.org.estudos.backend.service.LancamentoService;


@RestController
@RequestMapping("/vendedores")
public class LancamentoController {
	
	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping("/total")
	public ResponseEntity<List<VendedorDTO>> total() {
		List<VendedorDTO> vendedores = lancamentoService.total();
		return ResponseEntity.ok(vendedores);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagar(@PathVariable Long id) {

		if (!lancamentoService.deletar(id)) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.noContent().build();
	}

}

