package com.ativ12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ativ12.entities.Funcionario;
import com.ativ12.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	private final FuncionarioRepository FuncionarioRepository;
	
	@Autowired
	public FuncionarioService(FuncionarioRepository FuncionarioRepository) {
		this.FuncionarioRepository = FuncionarioRepository;
	}

	public List<Funcionario> getAllFuncionario() {
		return FuncionarioRepository.findAll();
	}

	public Funcionario getFuncionarioById(Long id) {
		Optional<Funcionario> Funcionario = FuncionarioRepository.findById(id);
		return Funcionario.orElse(null);
	}
	//Query Method
		public List<Funcionario> getFuncionarioPorNome(String nome) {
			return FuncionarioRepository.findByNome(nome);
	}
	//Query Method
		public List<Funcionario> getFuncionarioPorNomeESalario(String nome, String salario) {
			return FuncionarioRepository.findByNomeAndSalario(nome, salario);
	}
	public Funcionario salvarFuncionario(Funcionario Funcionario) {
		return FuncionarioRepository.save(Funcionario);
	}

	public Funcionario updateFuncionario(Long id, Funcionario updatedFuncionario) {
		Optional<Funcionario> existingFuncionario = FuncionarioRepository.findById(id);
		if (existingFuncionario.isPresent()) {
			updatedFuncionario.setId(id);
			return FuncionarioRepository.save(updatedFuncionario);
		}
		return null;
	}

	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> existingFuncionario = FuncionarioRepository.findById(id);
		if (existingFuncionario.isPresent()) {
			FuncionarioRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
