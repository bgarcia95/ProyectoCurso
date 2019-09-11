package com.mitocode.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "config") //, schema = "prueba"
public class Config implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;//byte id;
	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;
	@Column(name = "valor", length = 100, nullable = false)
	private String valor;

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
