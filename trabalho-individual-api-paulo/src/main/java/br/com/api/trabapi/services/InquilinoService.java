package br.com.api.trabapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.trabapi.entities.Inquilino;
import br.com.api.trabapi.repositories.InquilinoRepository;

public class InquilinoService {

	@Autowired
	InquilinoRepository inquilinoRepository;

	public Integer getCount() {
		return inquilinoRepository.contar();
	}
	
	public Inquilino salvar(Inquilino objetoTeste) {
		return inquilinoRepository.save(objetoTeste);
	}

	public Inquilino acharId(Integer id) {
		return inquilinoRepository.findById(id).get();
	}

	public List<Inquilino> listar() {
		return inquilinoRepository.findAll();
	}

	public void deletarlogico(Integer id) {
		Inquilino objTeste = acharId(id);
		if (objTeste != null) {
			objTeste.setAtivo(false);
			inquilinoRepository.save(objTeste);
		}
	}

	public Inquilino atualizar(Integer id, Inquilino objetoTeste) {
		Inquilino registroAntigo = acharId(id);

		if (objetoTeste.getAtivo() != null) {
			registroAntigo.setAtivo(objetoTeste.getAtivo());
		}

		if (objetoTeste.getNome() != null) {
			registroAntigo.setNome(objetoTeste.getNome());
		}
//		if (objetoTeste.getDescricao() != null) {
//			registroAntigo.setDescricao(objetoTeste.getDescricao());
//		}
		registroAntigo.setId(id);
		return inquilinoRepository.save(registroAntigo);
	}
}
