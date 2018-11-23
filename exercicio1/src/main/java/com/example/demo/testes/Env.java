package com.example.demo.testes;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Env {

    private Logger logger = LoggerFactory.getLogger(Env.class);

    @Value("${teste.mensagem}")
    private String mensagem;

    @PostConstruct
    public void init() {
        logger.info(mensagem);
    }
    
}