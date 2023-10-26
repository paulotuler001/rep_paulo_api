//package br.com.api.trabapi.services;
//
//import java.util.List;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import br.com.api.trabapi.entities.Inquilino;
//import br.com.api.trabapi.repositories.InquilinoRepository;
//
//@Service
//public class InquilinoService {
//
//	@Autowired
//	InquilinoRepository inquilinoRepository;
//
//	public Integer getCount() {
//		return inquilinoRepository.contar();
//	}
//	
//	public Inquilino salvar(Inquilino objetoTeste) {
//		return inquilinoRepository.save(objetoTeste);
//	}
//
//	public Inquilino acharId(Integer id) {
//		return inquilinoRepository.findById(id).get();
//	}
//
//	public List<Inquilino> listar() {
//		return inquilinoRepository.findAll();
//	}
//
//	public void deletar(Integer id) {
//		if (inquilinoRepository.findById(id).get() == null) {
//			throw new EntityNotFoundException("Esse produto não existe");
//		} else {
//			inquilinoRepository.deleteById(id);
//		}
//	}
//
//	public Inquilino atualizar(Integer id, Inquilino objetoTeste) {
//		Inquilino registroAntigo = acharId(id);
//
//		if (objetoTeste.getAtivo() != null) {
//			registroAntigo.setAtivo(objetoTeste.getAtivo());
//		}
//
//		if (objetoTeste.getNome() != null) {
//			registroAntigo.setNome(objetoTeste.getNome());
//		}
////		if (objetoTeste.getDescricao() != null) {
////			registroAntigo.setDescricao(objetoTeste.getDescricao());
////		}
//		registroAntigo.setId(id);
//		return inquilinoRepository.save(registroAntigo);
//	}
//}
