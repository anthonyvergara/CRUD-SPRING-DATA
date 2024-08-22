package com.spring.datajpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Telefone {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String tipo;
	
	@Column(nullable = false)
	private Long numero;
	
	@ManyToOne(optional = false)
	private EstudosModel estudosModel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public EstudosModel getEstudosModel() {
		return estudosModel;
	}

	public void setEstudosModel(EstudosModel estudosModel) {
		this.estudosModel = estudosModel;
	}
	
	
}
