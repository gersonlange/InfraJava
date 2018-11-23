package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

@Entity
@XmlRootElement
public class Aluno {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String nome;

    @Getter @Setter
    private Integer matricula;

    @Getter @Setter
    private String email;
}