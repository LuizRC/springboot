package br.org.estudos.backend.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.org.estudos.backend.dto.ClienteDTO;
import br.org.estudos.backend.model.Cliente;
import br.org.estudos.backend.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FotoService fotoService;
	
	public ClienteDTO inserir(Cliente cliente, MultipartFile file) throws IOException {

		fotoService.inserir(clienteRepository.save(cliente), file);
		return adicionarFotoUrl(cliente);

	}
	
	public List<ClienteDTO> listar(){
		List<Cliente> clientes = clienteRepository.findAll();
		List<ClienteDTO> clientesDTO = new ArrayList<ClienteDTO>();
		
		for(Cliente cliente : clientes) {
			clientesDTO.add(adicionarFotoUrl(cliente));
		}
		return clientesDTO;
	}
    
	public ClienteDTO buscar (Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);

		return adicionarFotoUrl(cliente.get());
	}
	
	public ClienteDTO adicionarFotoUrl(Cliente cliente) {
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/clientes/{id}/foto")
				.buildAndExpand(cliente.getId()).toUri();
		
		System.out.println("URI" + uri);
		
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setUrl(uri.toString());
		return clienteDTO;
	}
	
	
}
