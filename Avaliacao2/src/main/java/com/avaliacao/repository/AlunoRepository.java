package com.avaliacao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.entities.Aluno;

public interface AlunoRepository extends JpaRepository <Aluno,Long> {
	List<Aluno> findByCidade(String cidade);
	List<Aluno> findByNome(String nome);
	List<Aluno> findByCidadeAndRenda(String cidade, Double renda);
	List<Aluno> findByRa(String ra);
}
