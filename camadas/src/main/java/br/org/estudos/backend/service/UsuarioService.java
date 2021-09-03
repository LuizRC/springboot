package br.org.estudos.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.org.estudos.backend.config.MailConfig;
import br.org.estudos.backend.dto.UsuarioDTO;
import br.org.estudos.backend.dto.UsuarioInserirDTO;
import br.org.estudos.backend.exception.EmailException;
import br.org.estudos.backend.model.Usuario;
import br.org.estudos.backend.model.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MailConfig mailConfig;
	
	public List<UsuarioDTO> listar(){
		List<UsuarioDTO> usuarioDTOs = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = usuarioRepository.findAll();
		/*long total = 0;
		total= usuarioRepository.count();*/
		
		for(Usuario usuario: usuarios) {
			UsuarioDTO dto = new UsuarioDTO(usuario);
			usuarioDTOs.add(dto);
		}
		return usuarioDTOs;
	}

	public UsuarioDTO inserir (UsuarioInserirDTO usuarioInserirDTO) throws EmailException {
		Usuario u = usuarioRepository.findByEmail(usuarioInserirDTO.getEmail());
		if(u != null) {
			throw new EmailException("Email existente ! Insira outro");
		}
		Usuario usuario = new Usuario();
		usuario.setNome(usuarioInserirDTO.getNome());
		usuario.setEmail(usuarioInserirDTO.getEmail());
		usuario.setPerfil("Usuario Padrão");
		usuario.setSenha(bCryptPasswordEncoder.encode(usuarioInserirDTO.getSenha()));
		usuario = usuarioRepository.save(usuario);
		mailConfig.enviarEmail(usuarioInserirDTO.getEmail(), "Cadastro de Usuario!!", usuario.toString());
		return new UsuarioDTO(usuario);
	}

}
