package com.senac.css.http;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clientes {
	
	private int id;
	private String nome;
	private String cpf;
	private String cnh;
	private String telefone;
	
	public Clientes() {
		
	}
	
	public Clientes(int id, String nome, String cpf, String cnh, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.cnh = cnh;
		this.telefone = telefone;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
