package com.example.demo.hyper;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

import com.example.demo.model.Aluno;

public class AlunoResource extends Resource<Aluno> {

	public AlunoResource(Aluno aluno, Link... links) {
		super(aluno, links);
	}

}
