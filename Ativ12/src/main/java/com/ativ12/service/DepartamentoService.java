package com.ativ12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ativ12.entities.Departamento;
import com.ativ12.repository.DepartamentoRepository;

@Service
public class DepartamentoService {
	private final DepartamentoRepository DepartamentoRepository;
	
	@Autowired
	public DepartamentoService(DepartamentoRepository DepartamentoRepository) {
		this.DepartamentoRepository = DepartamentoRepository;
	}

	public List<Departamento> getAllDepartamento() {
		return DepartamentoRepository.findAll();
	}

	public Departamento getDepartamentoById(Long id) {
		Optional<Departamento> Departamento = DepartamentoRepository.findById(id);
		return Departamento.orElse(null);
	}
	//Query Method
		public List<Departamento> getDepartamentoPorNome(String nome) {
			return DepartamentoRepository.findByNome(nome);
	}
	public Departamento salvarDepartamento(Departamento Departamento) {
		return DepartamentoRepository.save(Departamento);
	}

	public Departamento updateDepartamento(Long id, Departamento updatedDepartamento) {
		Optional<Departamento> existingDepartamento = DepartamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			updatedDepartamento.setId(id);
			return DepartamentoRepository.save(updatedDepartamento);
		}
		return null;
	}

	public boolean deleteDepartamento(Long id) {
		Optional<Departamento> existingDepartamento = DepartamentoRepository.findById(id);
		if (existingDepartamento.isPresent()) {
			DepartamentoRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
