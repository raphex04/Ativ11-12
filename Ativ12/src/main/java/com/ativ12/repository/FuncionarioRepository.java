package com.ativ12.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ativ12.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository <Funcionario,Long> {
	List<Funcionario> findByNome(String nome);
	List<Funcionario> findByNomeAndSalario(String nome, String salario);
}
