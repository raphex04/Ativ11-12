package com.ativ12.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ativ12.entities.Funcionario;
import com.ativ12.service.FuncionarioService;

@RestController
@RequestMapping("/Funcionario")
public class FuncionarioController {
	private final FuncionarioService FuncionarioService;
	@Autowired
	public FuncionarioController(FuncionarioService FuncionarioService) {
		this.FuncionarioService = FuncionarioService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Long id) {
		Funcionario Funcionario = FuncionarioService.getFuncionarioById(id);
		if (Funcionario != null) {
			return ResponseEntity.ok(Funcionario);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/")
	public ResponseEntity<List<Funcionario>> getAllFuncionario() {
		List<Funcionario> Funcionario = FuncionarioService.getAllFuncionario();
		return ResponseEntity.ok(Funcionario);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Funcionario>> getFuncionarioPorNome(@PathVariable String nome) {
		List<Funcionario> Funcionario = FuncionarioService.getFuncionarioPorNome(nome);
		return ResponseEntity.ok(Funcionario);
	}
	@GetMapping("/nome/{nome}/salario/{salario}")
	public ResponseEntity<List<Funcionario>> getFuncionarioPorNomeESalario(@PathVariable String nome, String salario) {
		List<Funcionario> Funcionario = FuncionarioService.getFuncionarioPorNomeESalario(nome, salario);
		return ResponseEntity.ok(Funcionario);
	}
	@PostMapping("/")
	public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario Funcionario) {
		Funcionario criarFuncionario = FuncionarioService.salvarFuncionario(Funcionario);
		return ResponseEntity.status(HttpStatus.CREATED).body(criarFuncionario);
	}


	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> updateFuncionario(@PathVariable Long id,@RequestBody Funcionario Funcionario) {
		Funcionario updatedFuncionario = FuncionarioService.updateFuncionario(id, Funcionario);
		if (updatedFuncionario != null) {
			return ResponseEntity.ok(updatedFuncionario);
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteFuncionario(@PathVariable Long id) {
		boolean deleted = FuncionarioService.deleteFuncionario(id);
		if (deleted) {
			return ResponseEntity.ok().body("O Funcionario foi excluído com sucesso.");
		} else {
			return ResponseEntity.notFound().build();
		}
	}


}

