package com.example.demo.hyper;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import com.example.demo.controller.AlunoController;
import com.example.demo.model.Aluno;

public class AlunoResourceAssembler extends ResourceAssemblerSupport<Aluno, AlunoResource> {
	
	public AlunoResourceAssembler() {
		super(Aluno.class, AlunoResource.class);
	}

	@Override
	public AlunoResource toResource(Aluno aluno) {
		return new AlunoResource(aluno, 
				linkTo(methodOn(AlunoController.class).findOne(aluno.getId())).withSelfRel());
	}
	
	@Override
	protected AlunoResource instantiateResource(Aluno aluno) {
		return new AlunoResource(aluno);
	}

}