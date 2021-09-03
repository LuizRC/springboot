package br.org.estudos.backend.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.org.estudos.backend.model.Funcionario;
import br.org.estudos.backend.repository.FuncionarioRepository;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping
	public ResponseEntity<List<Funcionario>> listar() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/pagina")
	public ResponseEntity<Page<Funcionario>> listarPorPagina(
			@PageableDefault(page = 0, sort = ("nome"), direction = Direction.ASC, size = 8) Pageable pageable) {

		Page<Funcionario> funcionarios = funcionarioRepository.findAll(pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/salario")
	public ResponseEntity<Page<Funcionario>> buscarPorSalario(@RequestParam(defaultValue = "0") Double valorMinimo,
			@RequestParam(defaultValue = "13000") Double valorMaximo, Pageable pageable) {
		// Page<Funcionario> funcionarios =
		// funcionarioRepository.buscarSalarios(valorMinimo, valorMaximo, pageable);
		Page<Funcionario> funcionarios = funcionarioRepository.findBySalarioBetween(valorMinimo, valorMaximo, pageable);
		return ResponseEntity.ok(funcionarios);

	}

	@GetMapping("/nome")
	public ResponseEntity<Page<Funcionario>> buscarPorNome(@RequestParam(defaultValue = "") String paramNome,
			Pageable pageable) {
		// Page<Funcionario> funcionarios =
		// funcionarioRepository.buscarPorNome(paramNome, pageable);
		Page<Funcionario> funcionarios = funcionarioRepository.findByNomeContainingIgnoreCase(paramNome, pageable);
		return ResponseEntity.ok(funcionarios);
	}

	@GetMapping("/data")
	public ResponseEntity<Page<Funcionario>> buscarPorDataNascimento(@RequestParam String paramDataNascimento,
			Pageable pageable) { 
		LocalDate dataNascimento = LocalDate.parse(paramDataNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Page<Funcionario> funcionarios = funcionarioRepository.findByDataNascimentoGreaterThan(dataNascimento,
				pageable);
		return ResponseEntity.ok(funcionarios);
	}

}
