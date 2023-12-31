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

import br.com.api.trabapi.dto.EnderecoDTO;
import br.com.api.trabapi.entities.Endereco;
import br.com.api.trabapi.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;

	@GetMapping("/count")
	public Integer getCount() {
		return enderecoService.getCount();
	}

	@PostMapping("/salvar")
	public void salvar(@RequestBody EnderecoDTO endereco, @RequestParam String email) {
		enderecoService.salvar(endereco, email);
	}

	@GetMapping("/{id}")
	public Endereco acharId(@PathVariable Integer id) {
		return enderecoService.acharId(id);
	}

	@GetMapping("/listar")
	public List<Endereco> listar() {
		return enderecoService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarlogico(@PathVariable Integer id) {
		enderecoService.deletarlogico(id);
	}

	@PutMapping("/atualizar/{id}")
	public Endereco atualizar(@PathVariable Integer id, @RequestBody EnderecoDTO objetoEndereco) {
		return enderecoService.atualizar(id, objetoEndereco);
	}

	@PutMapping("/reativacaoDeEndereco/{id}")
	public void reativacaoDeEndereco(@PathVariable Integer id) {
		enderecoService.reativacaoDeEndereco(id);
	}
}