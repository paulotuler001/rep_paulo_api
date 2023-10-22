package br.com.api.trabapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.trabapi.entities.Fiador;
import br.com.api.trabapi.repositories.FiadorRepository;

public class FiadorService {

	@Autowired
	FiadorRepository fiadorRepository;

	public Integer getCount() {
		return fiadorRepository.contar();
	}
	
	public Fiador salvar(Fiador objetoTeste) {
		return fiadorRepository.save(objetoTeste);
	}

	public Fiador acharId(Integer id) {
		return fiadorRepository.findById(id).get();
	}

	public List<Fiador> listar() {
		return fiadorRepository.findAll();
	}

	public void deletarlogico(Integer id) {
		Fiador objTeste = acharId(id);
		if (objTeste != null) {
			objTeste.setAtivo(false);
			fiadorRepository.save(objTeste);
		}
	}

	public Fiador atualizar(Integer id, Fiador objetoTeste) {
		Fiador registroAntigo = acharId(id);

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
		return fiadorRepository.save(registroAntigo);
	}
}
