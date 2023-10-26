//package br.com.api.trabapi.controllers;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.api.trabapi.entities.Proprietario;
//import br.com.api.trabapi.services.ProprietarioService;
//
//@RestController
//@RequestMapping("/proprietario")
//public class ProprietarioController {
//
//	@Autowired
//	ProprietarioService proprietarioService;
//
//	@GetMapping("/count")
//	public Integer getCount() {
//		return proprietarioService.getCount();
//	}
//	
//	@PostMapping("/salvar")
//	public Proprietario salvar(@RequestBody Proprietario objetoTeste) {
//		return proprietarioService.salvar(objetoTeste);
//	}
//
//	@GetMapping("/{id}")
//	public Proprietario acharId(@PathVariable Integer id) {
//		return proprietarioService.acharId(id);
//	}
//
//	@GetMapping("/listar")
//	public List<Proprietario> listar() {
//		return proprietarioService.listar();
//	}
//
//	@DeleteMapping("/deletarLogico/{id}")
//	public void deletarlogico(@PathVariable Integer id) {
//		proprietarioService.deletarlogico(id);
//	}
//
//	@PutMapping("/atualizar/{id}")
//	public Proprietario atualizar(@PathVariable Integer id, @RequestBody Proprietario objetoTeste) {
//		return proprietarioService.atualizar(id,objetoTeste);
//	}
//}
