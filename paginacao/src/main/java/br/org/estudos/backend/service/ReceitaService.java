package br.org.estudos.backend.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.org.estudos.backend.dto.ReceitaDTO;
import br.org.estudos.backend.model.Receita;
import br.org.estudos.backend.repository.ReceitaRepository;

@Service
public class ReceitaService {
	
	@Autowired
	private ReceitaRepository receitarepository;
	
	public ReceitaDTO buscar(String cnpj) {
		RestTemplate rs = new RestTemplate();
		String uri = "https://www.receitaws.com.br/v1/cnpj/" + cnpj;
		Map<String, String> params = new HashMap<String, String>();
		params.put("cnpj", cnpj);
		Receita receitaws = rs.getForObject(uri, Receita.class, params);
		return inserir(receitaws);
	}
	
	public ReceitaDTO inserir(Receita receita) {
		//receita = receitarepository.save(receita);
		//return new ReceitaDTO(receita);
		
		return new ReceitaDTO(receitarepository.save(receita));
	}

}
