package br.org.estudos.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.estudos.backend.dto.VendedorDTO;
import br.org.estudos.backend.repository.LancamentoRepository;

@Service
public class LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	public List<VendedorDTO> total(){
		return lancamentoRepository.totalPorVendedor();
	}
	
	public boolean deletar(Long id) {
		if (!lancamentoRepository.existsById(id)) {
			return false;
		} else {
			lancamentoRepository.deleteById(id);
			return true;
		}
	}
}

