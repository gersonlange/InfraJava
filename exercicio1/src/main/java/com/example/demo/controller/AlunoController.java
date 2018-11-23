package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Aluno;
import com.example.demo.repo.AlunoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AlunoController
 */
@RestController
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping(path = "/alunos", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Aluno>> findAll() {
        List<Aluno> lista = alunoRepository.findAll();

        return ResponseEntity.ok().body(lista);
    }

    @GetMapping(path = "/aluno/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Aluno> findOne(
    		@PathVariable("id") Long id) {
    	Aluno aluno = alunoRepository.findOne(id);

    	if ( aluno == null )
        	return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(aluno);
    }

    @PostMapping(path = "/aluno", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Aluno> novo(
    		@RequestBody Aluno aluno) {
    	aluno = alunoRepository.save(aluno);

    	return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }
    
    @PutMapping(path = "/aluno/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Aluno> altera(
    		@PathVariable("id") Long id,
    		@RequestBody Aluno aluno) {

    	if ( alunoRepository.findOne(id) == null )
        	return ResponseEntity.notFound().build();

    	aluno.setId(id);
    	aluno = alunoRepository.save(aluno);

    	return ResponseEntity.status(HttpStatus.ACCEPTED).body(aluno);
    }

    @DeleteMapping("/aluno/{id}")
    public ResponseEntity<Aluno> exclui(
    		@PathVariable("id") Long id ){

    	if ( alunoRepository.findOne(id) == null )
        	return ResponseEntity.notFound().build();
    	
    	alunoRepository.delete(id);

    	return ResponseEntity.ok().build();
    }
}