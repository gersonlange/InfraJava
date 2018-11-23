package com.example.demo.repo;

import com.example.demo.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * AlunoRepository
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    
}