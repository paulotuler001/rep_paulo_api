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

import br.com.api.trabapi.entities.Inquilino;
import br.com.api.trabapi.services.InquilinoService;

@RestController
@RequestMapping("/inquilino")
public class InquilinoController {

	@Autowired
	InquilinoService inquilinoService;

	@GetMapping("/count")
	public Integer getCount() {
		return inquilinoService.getCount();
	}
	
	@PostMapping("/salvar")
	public Inquilino salvar(@RequestBody Inquilino objetoTeste) {
		return inquilinoService.salvar(objetoTeste);
	}

	@GetMapping("/{id}")
	public Inquilino acharId(@PathVariable Integer id) {
		return inquilinoService.acharId(id);
	}

	@GetMapping("/listar")
	public List<Inquilino> listar() {
		return inquilinoService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarlogico(@PathVariable Integer id) {
		inquilinoService.deletarlogico(id);
	}

	@PutMapping("/atualizar/{id}")
	public Inquilino atualizar(@PathVariable Integer id, @RequestBody Inquilino objetoTeste) {
		return inquilinoService.atualizar(id,objetoTeste);
	}
}
