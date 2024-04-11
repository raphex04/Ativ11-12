package com.ativ12.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ativ12.entities.Dependente;
import com.ativ12.repository.DependenteRepository;

@Service
public class DependenteService {
	private final DependenteRepository DependenteRepository;
	
	@Autowired
	public DependenteService(DependenteRepository DependenteRepository) {
		this.DependenteRepository = DependenteRepository;
	}

	public List<Dependente> getAllDependente() {
		return DependenteRepository.findAll();
	}

	public Dependente getDependenteById(Long id) {
		Optional<Dependente> Dependente = DependenteRepository.findById(id);
		return Dependente.orElse(null);
	}
	//Query Method
		public List<Dependente> getDependentePorNome(String nome) {
			return DependenteRepository.findByNome(nome);
	}
	public Dependente salvarDependente(Dependente Dependente) {
		return DependenteRepository.save(Dependente);
	}

	public Dependente updateDependente(Long id, Dependente updatedDependente) {
		Optional<Dependente> existingDependente = DependenteRepository.findById(id);
		if (existingDependente.isPresent()) {
			updatedDependente.setId(id);
			return DependenteRepository.save(updatedDependente);
		}
		return null;
	}

	public boolean deleteDependente(Long id) {
		Optional<Dependente> existingDependente = DependenteRepository.findById(id);
		if (existingDependente.isPresent()) {
			DependenteRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
