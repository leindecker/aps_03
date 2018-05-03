package com.senac.css.controller;

import java.util.ArrayList;
import java.util.List;
 
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.senac.css.http.Clientes;
import com.senac.css.repository.ClientesRepository;
import com.senac.css.repository.entity.ClientesEntity;

/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/clientes")
public class ClientesController {

	private final ClientesRepository repository = new ClientesRepository();
	/**
	 * @Consumes - determina o formato dos dados que vamos postar
	 * @Produces - determina o formato dos dados que vamos retornar
	 * 
	 * Esse método cadastra uma nova pessoa
	 * */
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarCliente")
	public String Cadastrar(Clientes cliente) {
		ClientesEntity entity = new ClientesEntity();
		
		try {
			
			entity.setNome(cliente.getNome());
			entity.setCpf(cliente.getCpf());
			entity.setCnh(cliente.getCnh());
			entity.setTelefone(cliente.getTelefone());
			
			repository.Salvar(entity);
			
			return "Cliente Cadastrado com Sucesso !!!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao Cadastrar o cliente" + e.getMessage();
		}
	}
	
	// Método p/ alterar cliente
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterarCliente")
	public String Alterar(Clientes cliente) {
		
		ClientesEntity entity = new ClientesEntity();
		
		try {
			entity.setId(cliente.getId());
			entity.setNome(cliente.getNome());
			entity.setCpf(cliente.getCpf());
			entity.setCnh(cliente.getCnh());
			entity.setTelefone(cliente.getTelefone());
			
			repository.Alterar(entity);
			
			return "Cliente alterado com sucesso !!!";
			
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao alterar o cliente" + e.getMessage();
		}
	}
	
	/**
	 * Esse método lista todas pessoas cadastradas na base
	 * */
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listarClientes")
	public List<Clientes> TodosClientes(){
 
		List<Clientes> clientes =  new ArrayList<Clientes>();
 
		List<ClientesEntity> listaEntityClientes = repository.TodosClientes();
 
		for (ClientesEntity entity : listaEntityClientes) {
 
			clientes.add(new Clientes(entity.getId(), entity.getNome(), entity.getCpf(), entity.getCnh(), entity.getTelefone()));
		}
 
		return clientes;
	}
	
	// Método retorna cliente pelo código
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getCliente/{id}")
	public Clientes GetCliente(@PathParam("id") Integer id) {
		ClientesEntity entity = repository.GetCliente(id);
		
		if (entity != null) 
			return new Clientes(entity.getId(), entity.getNome(), entity.getCpf(), entity.getCnh(), entity.getTelefone());
		
		return null;
	}
	
	/**
	 * Excluindo uma pessoa pelo código
	 * */
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirCliente/{id}")	
	public String Excluir(@PathParam("id") Integer id){
 
		try {
 
			repository.Excluir(id);
 
			return "Cliente excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o cliente! " + e.getMessage();
		}
 
	}
 
}
