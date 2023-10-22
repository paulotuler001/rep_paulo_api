package br.com.api.trabapi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "apartamento")
public class Apartamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	numero;
	cor;
	juros;
	inquilino;
	proprietario;
	valor;
	mobilidado;
	
	ativo;
}
