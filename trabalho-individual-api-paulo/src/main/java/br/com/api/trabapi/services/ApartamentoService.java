package br.com.api.trabapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.api.trabapi.entities.Apartamento;
import br.com.api.trabapi.repositories.ApartamentoRepository;

public class ApartamentoService {

	@Autowired
	ApartamentoRepository apartamentoRepository;

	public Integer getCount() {
		return apartamentoRepository.contar();
	}
	
	public Apartamento salvar(Apartamento objetoTeste) {
		return apartamentoRepository.save(objetoTeste);
	}

	public Apartamento acharId(Integer id) {
		return apartamentoRepository.findById(id).get();
	}

	public List<Apartamento> listar() {
		return apartamentoRepository.findAll();
	}

	public void deletarlogico(Integer id) {
		Apartamento objTeste = acharId(id);
		if (objTeste != null) {
			objTeste.setAtivo(false);
			apartamentoRepository.save(objTeste);
		}
	}

	public Apartamento atualizar(Integer id, Apartamento objetoTeste) {
		Apartamento registroAntigo = acharId(id);

		if (objetoTeste.getAtivo() != null) {
			registroAntigo.setAtivo(objetoTeste.getAtivo());
		}

//		if (objetoTeste.getNome() != null) {
//			registroAntigo.setNome(objetoTeste.getNome());
//		}
//		if (objetoTeste.getDescricao() != null) {
//			registroAntigo.setDescricao(objetoTeste.getDescricao());
//		}
		registroAntigo.setId(id);
		return apartamentoRepository.save(registroAntigo);
	}
}
