package br.com.api.trabapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inquilino")
public class Inquilino {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Integer id;
	private String nome;
	private String telefone;
	private String cpf;
	contracheque;
	end_comercial;
	cargo;
	desc_cargo;
	//pessoas com ele
	num_apartamento;
	preco_aluguel;
	ativo;
}
