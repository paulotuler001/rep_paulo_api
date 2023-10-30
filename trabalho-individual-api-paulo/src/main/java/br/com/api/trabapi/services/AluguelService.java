package br.com.api.trabapi.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabapi.dto.AluguelDeApartamentoDTO;
import br.com.api.trabapi.dto.AluguelRespostaDTO;
import br.com.api.trabapi.dto.ApartamentoDeAluguelDTO;
import br.com.api.trabapi.entities.Aluguel;
import br.com.api.trabapi.entities.AluguelApartamentoEntry;
import br.com.api.trabapi.entities.Apartamento;
import br.com.api.trabapi.entities.Usuario;
import br.com.api.trabapi.repositories.AluguelRepository;
import br.com.api.trabapi.repositories.ApartamentoRepository;
import br.com.api.trabapi.repositories.UsuarioRepository;

@Service
public class AluguelService {

	@Autowired
	AluguelRepository aluguelRepository;
	@Autowired
	ApartamentoService apartamentoService;
	@Autowired
	ApartamentoRepository apartamentoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	List<Apartamento> apartamentos;

	public Aluguel parseAluguelDeApartamento(AluguelDeApartamentoDTO obj) {
		Aluguel aluguel = new Aluguel();
		List<Integer> quantidade = new ArrayList<>();
		List<Apartamento> prod = new ArrayList<>();

		for (int i = 0; i < obj.getApartamentos().size(); i++) {
			quantidade.add(obj.getApartamentos().get(i).getQuantidadePorApartamento());
			prod.add(apartamentoRepository.getReferenceById(obj.getApartamentos().get(i).getId()));
		}

		aluguel.setApartamentos(prod);

		return aluguel;
	}

	public Aluguel atualizacaoDeEstoque(AluguelDeApartamentoDTO obj) {
		apartamentos = new ArrayList<>();
		Aluguel aluguel = new Aluguel();
		List<ApartamentoDeAluguelDTO> apartamentosDoAluguel = obj.getApartamentos();

		for (ApartamentoDeAluguelDTO itemAluguel : apartamentosDoAluguel) {
			Apartamento apartamento = apartamentoRepository.findById(itemAluguel.getId()).get();
			AluguelApartamentoEntry aluguelApartamentoEntry = new AluguelApartamentoEntry();

			aluguelApartamentoEntry.setDataHora(LocalDateTime.now());

			if (itemAluguel.getQuantidadePorApartamento() <= apartamento.getQntdEstoque()) {
				Integer quantidadeAtualizada = apartamento.getQntdEstoque() - itemAluguel.getQuantidadePorApartamento();
				aluguelApartamentoEntry.setQuantidade(itemAluguel.getQuantidadePorApartamento());
				apartamento.getItemQuantidade().put(aluguel, aluguelApartamentoEntry);
				apartamento.setQntdEstoque(quantidadeAtualizada);
				apartamentos.add(apartamento);
			}
		}
		return aluguel;
	}

	public AluguelRespostaDTO parseDeAluguelResposta(Aluguel aluguel) {
		AluguelRespostaDTO aluguelResposta = new AluguelRespostaDTO();

		aluguelResposta.setAtivo(aluguel.getAtivo());
		aluguelResposta.setDataAluguel(aluguel.getDataAluguel());
		aluguelResposta.setApartamentos(aluguel.getApartamentos());

		return aluguelResposta;
	}

	public Integer getCount() {
		return aluguelRepository.contar();
	}

	public Aluguel salvar(AluguelDeApartamentoDTO objetoAluguel, String email) {
		Aluguel aluguel = atualizacaoDeEstoque(objetoAluguel);

		aluguel.setAtivo(true);
		aluguel.setDataAluguel(LocalDate.now());
//		aluguel.setApartamentos(Apartamentos);
		System.out.println(aluguel);
		aluguelRepository.save(aluguel);

		Usuario usuario = usuarioRepository.findByEmail(email).get();
		List<Aluguel> aluguels = usuario.getAluguels();
		if (aluguels == null) {
			usuario.setAluguels(List.of(aluguel));
		} else {
			aluguels.add(aluguel);
			usuario.setAluguels(aluguels);
		}
		usuarioRepository.save(usuario);

		return aluguel;
	}

//	public AluguelRespostaDTO acharId(Integer id) {
//		AluguelRespostaDTO aluguelResposta = parseDeAluguelResposta(aluguelRepository.findById(id).get());
//		return aluguelResposta;
//	}

	public List<AluguelRespostaDTO> listar() {
		List<AluguelRespostaDTO> aluguelsResposta = new ArrayList<>();
		List<Aluguel> aluguels = aluguelRepository.findAll();

		for (Aluguel aluguel : aluguels) {
			aluguelsResposta.add(parseDeAluguelResposta(aluguel));
		}
		return aluguelsResposta;

	}

	public void apagarLogico(Integer id) {
		if (aluguelRepository.findById(id).get() == null) {
			throw new EntityNotFoundException("Esse aluguel não existe");
		} else {
			Optional<Aluguel> objAluguel = aluguelRepository.findById(id);
			if (objAluguel != null) {

				objAluguel.get().setAtivo(false);
				aluguelRepository.save(objAluguel.get());
			}
		}
	}

}