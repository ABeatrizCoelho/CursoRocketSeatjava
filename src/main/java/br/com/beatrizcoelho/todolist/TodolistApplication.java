package br.com.beatrizcoelho.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //anotation - interface que vai executar algo - toda anotation e uma funcao - classe inicial do projeto
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args); //tem o conteinet tomcat por baixo dos planos para roda a aplicacao
	}

}
//metodo main e aquele metodo principal onde a gente consegue executar alguma coisa na aplicacao a
