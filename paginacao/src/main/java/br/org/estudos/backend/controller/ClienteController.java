package br.org.estudos.backend.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import br.org.estudos.backend.dto.ClienteDTO;
import br.org.estudos.backend.model.Cliente;
import br.org.estudos.backend.model.Foto;
import br.org.estudos.backend.service.ClienteService;
import br.org.estudos.backend.service.FotoService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private FotoService fotoService;

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	@PreAuthorize(value = "Admin")
	public ResponseEntity<List<ClienteDTO>> listar(@AuthenticationPrincipal UserDetails details) {
		List<ClienteDTO> clientes = clienteService.listar();
		return ResponseEntity.ok(clientes);
	}

	@GetMapping("/{id}/foto")
	@PreAuthorize(value = "Users")
	public ResponseEntity<byte[]> buscarPorFoto (@PathVariable Long id){
		Foto foto = fotoService.buscar(id);
		HttpHeaders headers = new HttpHeaders();
		headers.add("content-type",foto.getTipo());
		headers.add("content-length",String.valueOf(foto.getDados().length));
		return new ResponseEntity<>(foto.getDados(),headers,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDTO> buscarCliente(@PathVariable Long id){
			ClienteDTO dto=	clienteService.buscar(id);
			return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDTO inserir(@RequestParam MultipartFile file, @RequestPart Cliente cliente) throws IOException {
		return clienteService.inserir(cliente, file);
	}
}
