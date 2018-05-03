package com.senac.css.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funcionarios {
	
	private int id;
	private String nome;
	private String setor;
	
	public Funcionarios() {
		
	}
	
	public Funcionarios(int id, String nome, String setor) {
		super();
		this.id = id;
		this.nome = nome;
		this.setor = setor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

}
