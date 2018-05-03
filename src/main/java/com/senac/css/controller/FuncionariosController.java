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

import com.senac.css.http.Funcionarios;
import com.senac.css.repository.FuncionariosRepository;
import com.senac.css.repository.entity.FuncionariosEntity;

@Path("/funcionarios")
public class FuncionariosController {

	private final FuncionariosRepository repository = new FuncionariosRepository();
	
	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarFuncionario")
	public String CadastrarFuncionario(Funcionarios funcionario) {
		FuncionariosEntity entity = new FuncionariosEntity();
		
		try {
			entity.setNome(funcionario.getNome());
			entity.setSetor(funcionario.getSetor());
			
			repository.SalvarFuncionario(entity);
			
			return "Funcionario Cadastrado com Sucesso !! ";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao Cadastrar o Funcionário" + e.getMessage();
		}
	}
	
	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")	
	@Path("/alterarFuncionario")
	public String AlterarFuncionario(Funcionarios funcionario) {
		FuncionariosEntity entity = new FuncionariosEntity();
		
		try {
			entity.setId(funcionario.getId());
			entity.setNome(funcionario.getNome());
			entity.setSetor(funcionario.getSetor());
			
			repository.AlterarFuncionario(entity);
			
			return "Funcionário Alterado com sucesso !!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao Alterar Funcionário" + e.getMessage();
		}
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listarFuncionarios")
	public List<Funcionarios> TodosFuncionarios() {
		List<Funcionarios> funcionarios = new ArrayList<Funcionarios>();
		
		List<FuncionariosEntity> listEntityFuncionarios = repository.TodosFuncionarios();
		
		for(FuncionariosEntity entity : listEntityFuncionarios) {
			funcionarios.add(new Funcionarios(entity.getId(), entity.getNome(), entity.getSetor()));
		}
		
		return funcionarios;
	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getFuncionario/{id}")
	public Funcionarios GetFuncionario(@PathParam("id") Integer id) {
		FuncionariosEntity entity = repository.GetFuncionario(id);
		
		if (entity != null) 
			return new Funcionarios(entity.getId(), entity.getNome(), entity.getSetor());
		
		return null;
	}
	
	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirFuncionario/{id}")	
	public String ExcluirFuncionario(@PathParam("id") Integer id){
 
		try {
 
			repository.ExcluirFuncionario(id);
 
			return "Funcionario excluido com sucesso!";
 
		} catch (Exception e) {
 
			return "Erro ao excluir o Funcionario! " + e.getMessage();
		}
 
	}
}
