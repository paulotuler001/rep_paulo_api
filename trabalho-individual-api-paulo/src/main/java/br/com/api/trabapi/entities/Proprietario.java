package br.com.api.trabapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proprietario")
public class Proprietario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	valor_pagamento;
	posses; //criar outra entity
	valor_cobrado; //tem q estar no apartmnto
	porcentagem_comissao;
	
	ativo;
	
}
