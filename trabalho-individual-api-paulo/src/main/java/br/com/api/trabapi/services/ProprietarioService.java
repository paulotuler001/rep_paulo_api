package br.com.api.trabapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.trabapi.entities.Proprietario;


public class ProprietarioService {

	@Autowired
	ProprietarioRepository proprietarioRepository;

	public Integer getCount() {
		return proprietarioRepository.contar();
	}
	
	public Proprietario salvar(Proprietario objetoTeste) {
		return proprietarioRepository.save(objetoTeste);
	}

	public Proprietario acharId(Integer id) {
		return proprietarioRepository.findById(id).get();
	}

	public List<Proprietario> listar() {
		return proprietarioRepository.findAll();
	}

	public void deletarlogico(Integer id) {
		Proprietario objTeste = acharId(id);
		if (objTeste != null) {
			objTeste.setAtivo(false);
			proprietarioRepository.save(objTeste);
		}
	}

	public Proprietario atualizar(Integer id, Proprietario objetoTeste) {
		Proprietario registroAntigo = acharId(id);

		if (objetoTeste.getAtivo() != null) {
			registroAntigo.setAtivo(objetoTeste.getAtivo());
		}

		if (objetoTeste.getNome() != null) {
			registroAntigo.setNome(objetoTeste.getNome());
		}
		if (objetoTeste.getDescricao() != null) {
			registroAntigo.setDescricao(objetoTeste.getDescricao());
		}
		registroAntigo.setId(id);
		return proprietarioRepository.save(registroAntigo);
	}
}
