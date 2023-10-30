package br.com.api.trabapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabapi.dto.ApartamentoDTO;
import br.com.api.trabapi.dto.ApartamentoRespostaDTO;
import br.com.api.trabapi.entities.Apartamento;
import br.com.api.trabapi.entities.Usuario;
import br.com.api.trabapi.repositories.ApartamentoRepository;
import br.com.api.trabapi.repositories.UsuarioRepository;

@Service
public class ApartamentoService {

	@Autowired
	ApartamentoRepository apartamentoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public Apartamento parseDeApartamento(ApartamentoDTO objeto) {
		Apartamento apartamento = new Apartamento();

		apartamento.setDescricao(objeto.getDescricao());
		apartamento.setQntdEstoque(objeto.getQntdEstoque());
		apartamento.setValorUnitario(objeto.getValorUnitario());

		return apartamento;
	}

	public ApartamentoRespostaDTO parseDeApartamentoResposta(Apartamento objeto) {
		ApartamentoRespostaDTO apartamento = new ApartamentoRespostaDTO();

		apartamento.setDescricao(objeto.getDescricao());
		apartamento.setQntdEstoque(objeto.getQntdEstoque());
		apartamento.setValorUnitario(objeto.getValorUnitario());

		return apartamento;
	}

	public Integer getCount() {
		return apartamentoRepository.contar();
	}

	public void salvar(ApartamentoDTO objetoapartamento, String email) {
		Apartamento apartamentoNovo = parseDeApartamento(objetoapartamento);

		apartamentoNovo.setAtivo(true);

		Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
		usuario.get().getApartamentos().add(apartamentoNovo);

		apartamentoRepository.save(apartamentoNovo);
		usuarioRepository.save(usuario.get());
	}

	public ApartamentoRespostaDTO acharId(Integer id) {
		if (apartamentoRepository.findById(id).get() == null) {

			throw new EntityNotFoundException("Esse apartamento não existe");
		} else {
			ApartamentoRespostaDTO apartamentoResposta = parseDeApartamentoResposta(apartamentoRepository.findById(id).get());
			return apartamentoResposta;
		}
	}

	public List<ApartamentoRespostaDTO> listar() {
		List<ApartamentoRespostaDTO> apartamentosResposta = new ArrayList<>();
		List<Apartamento> apartamentos = apartamentoRepository.findAll();
		for (Apartamento apartamento : apartamentos) {
			apartamentosResposta.add(parseDeApartamentoResposta(apartamento));
		}
		return apartamentosResposta;
	}

	public void deletar(Integer id) {
		if (apartamentoRepository.findById(id).get() == null) {
			throw new EntityNotFoundException("Esse apartamento não existe");
		} else {
			apartamentoRepository.deleteById(id);
		}
	}

	public Apartamento atualizar(Integer id, ApartamentoDTO objetoapartamento) {
		if (apartamentoRepository.findById(id).get() == null) {
			throw new EntityNotFoundException("Esse apartamento não existe");
		} else {
			Optional<Apartamento> registroAntigo = apartamentoRepository.findById(id);
			Apartamento apartamento = parseDeApartamento(objetoapartamento);

			if (apartamento.getAtivo() != null) {
				registroAntigo.get().setAtivo(apartamento.getAtivo());
			}
			if (apartamento.getDescricao() != null) {
				registroAntigo.get().setDescricao(apartamento.getDescricao());
			}
			if (apartamento.getQntdEstoque() != null) {
				registroAntigo.get().setQntdEstoque(apartamento.getQntdEstoque());
			}
			if (apartamento.getValorUnitario() != null) {
				registroAntigo.get().setValorUnitario(apartamento.getValorUnitario());
			}
			registroAntigo.get().setId(id);
			return apartamentoRepository.save(registroAntigo.get());
		}
	}

//	public List<PromocaoDTO> promocao() {
//		return apartamentoRepository.promocao().stream()
//				.map(record -> new PromocaoDTO(String.valueOf(record[0]), String.valueOf(record[1])))
//				.collect(Collectors.toList());
//	}


}