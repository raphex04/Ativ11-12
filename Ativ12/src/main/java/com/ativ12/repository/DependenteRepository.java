package com.ativ12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ativ12.entities.Dependente;

public interface DependenteRepository extends JpaRepository <Dependente,Long> {
	List<Dependente> findByNome(String nome);
}
