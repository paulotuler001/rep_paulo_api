package br.com.api.trabapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabapi.dto.ApartamentoDTO;
import br.com.api.trabapi.dto.ApartamentoRespostaDTO;
import br.com.api.trabapi.entities.Apartamento;
import br.com.api.trabapi.services.ApartamentoService;
import br.com.api.trabapi.services.EmailService;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

	private EmailService emailService;
	
	@Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }
	
	@Autowired
	ApartamentoService apartamentoService;

	@GetMapping("/count")
	public Integer getCount() {
		return apartamentoService.getCount();
	}
	
	@PostMapping("/salvar")
	public void salvar(@RequestBody ApartamentoDTO objetoTeste, @RequestParam String emailProprietario) {
		apartamentoService.salvar(objetoTeste, emailProprietario);
	}

	@GetMapping("/{id}")
	public ApartamentoRespostaDTO acharId(@PathVariable Integer id) {
		return apartamentoService.acharId(id);
	}

	@GetMapping("/listar")
	public List<ApartamentoRespostaDTO> listar() {
		return apartamentoService.listar();
	}

	@DeleteMapping("/deletar/{id}")
	public void deletarlogico(@PathVariable Integer id) {
		apartamentoService.deletar(id);
	}

	@PutMapping("/atualizar/{id}")
	public Apartamento atualizar(@PathVariable Integer id, @RequestBody ApartamentoDTO objetoTeste) {
		return apartamentoService.atualizar(id,objetoTeste);
	}
}
