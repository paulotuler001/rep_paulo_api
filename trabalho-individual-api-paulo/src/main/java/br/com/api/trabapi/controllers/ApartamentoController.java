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
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabapi.entities.Apartamento;
import br.com.api.trabapi.services.ApartamentoService;

@RestController
@RequestMapping("/apartamento")
public class ApartamentoController {

	@Autowired
	ApartamentoService categoriaService;

	@GetMapping("/count")
	public Integer getCount() {
		return apartamentoService.getCount();
	}
	
	@PostMapping("/salvar")
	public Apartamento salvar(@RequestBody Apartamento objetoTeste) {
		return apartamentoService.salvar(objetoTeste);
	}

	@GetMapping("/{id}")
	public Apartamento acharId(@PathVariable Integer id) {
		return apartamentoService.acharId(id);
	}

	@GetMapping("/listar")
	public List<Apartamento> listar() {
		return apartamentoService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarlogico(@PathVariable Integer id) {
		apartamentoService.deletarlogico(id);
	}

	@PutMapping("/atualizar/{id}")
	public Apartamento atualizar(@PathVariable Integer id, @RequestBody Apartamento objetoTeste) {
		return apartamentoService.atualizar(id,objetoTeste);
	}
}
