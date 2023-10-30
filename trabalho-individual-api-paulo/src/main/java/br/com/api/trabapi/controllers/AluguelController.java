package br.com.api.trabapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabapi.dto.AluguelDeApartamentoDTO;
import br.com.api.trabapi.dto.AluguelRespostaDTO;
import br.com.api.trabapi.entities.Aluguel;
import br.com.api.trabapi.services.AluguelService;
import br.com.api.trabapi.services.EmailService;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {

	@Autowired
	AluguelService aluguelService;

	private EmailService emailService;

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@GetMapping("/count")
	public Integer getCount() {
		return aluguelService.getCount();
	}

	@PostMapping("/salvar")
	public Aluguel salvar(@RequestBody AluguelDeApartamentoDTO objetoAluguel, @RequestParam String email) {
		emailService.envioEmailAluguel(objetoAluguel);
		return aluguelService.salvar(objetoAluguel, email);
	}

//	@GetMapping("/{id}")
//	public AluguelRespostaDTO acharId(@PathVariable Integer id) {
//		return aluguelService.acharId(id);
//	}

	@GetMapping("/listar")
	public List<AluguelRespostaDTO> listar() {
		return aluguelService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarLogico(@PathVariable Integer id) {
		aluguelService.apagarLogico(id);
	}

}