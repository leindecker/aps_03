package com.senac.css.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Automoveis {
	
	private int id;
	private String modelo;
	private String cor;
	private String placa;
	
	public Automoveis() {
		
	}
	
	public Automoveis(int id, String modelo, String cor, String placa) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}
