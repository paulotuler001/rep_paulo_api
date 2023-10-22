package br.com.api.trabapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabapi.entities.Fiador;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/fiador")
public class FiadorController {

	@Autowired
	FiadorService fiadorService;

	@GetMapping("/count")
	public Integer getCount() {
		return fiadorService.getCount();
	}
	
	@PostMapping("/salvar")
	public Fiador salvar(@RequestBody Fiador objetoTeste) {
		return fiadorService.salvar(objetoTeste);
	}

	@GetMapping("/{id}")
	public Fiador acharId(@PathVariable Integer id) {
		return fiadorService.acharId(id);
	}

	@GetMapping("/listar")
	public List<Fiador> listar() {
		return fiadorService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarlogico(@PathVariable Integer id) {
		fiadorService.deletarlogico(id);
	}

	@PutMapping("/atualizar/{id}")
	public Fiador atualizar(@PathVariable Integer id, @RequestBody Fiador objetoTeste) {
		return fiadorService.atualizar(id,objetoTeste);
	}
}
