package com.ativ12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ativ12.entities.Departamento;

public interface DepartamentoRepository extends JpaRepository <Departamento,Long> {
	List<Departamento> findByNome(String nome);
}
