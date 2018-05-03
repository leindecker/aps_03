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

import com.senac.css.http.Automoveis;
import com.senac.css.repository.AutomoveisRepository;
import com.senac.css.repository.entity.AutomoveisEntity;

@Path("/automoveis")
public class AutomoveisController {

	private final AutomoveisRepository repository = new AutomoveisRepository();

	@POST
	@Consumes("application/json; charset=UTF-8")
	@Produces("application/json; charset=UTF-8")
	@Path("/cadastrarAutomovel")
	public String CadastrarAutomovel(Automoveis automoveis) {
		AutomoveisEntity entity = new AutomoveisEntity();

		try {
			entity.setModelo(automoveis.getModelo());
			entity.setCor(automoveis.getCor());
			entity.setPlaca(automoveis.getPlaca());

			repository.SalvarAutomovel(entity);

			return "Automovel Cadastrado com Sucesso !!!";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao Cadastrar o Automovel" + e.getMessage();
		}
	}

	@PUT
	@Produces("application/json; charset=UTF-8")
	@Consumes("application/json; charset=UTF-8")
	@Path("/alterarAutomovel")
	public String AlterarAutomovel(Automoveis automoveis) {
		AutomoveisEntity entity = new AutomoveisEntity();

		try {
			entity.setId(automoveis.getId());
			entity.setModelo(automoveis.getModelo());
			entity.setCor(automoveis.getCor());
			entity.setPlaca(automoveis.getPlaca());

			repository.AlterarAutomovel(entity);

			return "Automovel Alterado com Sucesso";
		} catch (Exception e) {
			// TODO: handle exception
			return "Erro ao Alterar Automovel" + e.getMessage();
		}
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/listarAutomoveis")
	public List<Automoveis> TodosAutomoveis() {
		List<Automoveis> automoveis = new ArrayList<Automoveis>();

		List<AutomoveisEntity> listEntityAutomoveis = repository.TodosAutomoveis();

		for (AutomoveisEntity entity : listEntityAutomoveis) {
			automoveis.add(new Automoveis(entity.getId(), entity.getModelo(), entity.getCor(), entity.getPlaca()));
		}

		return automoveis;
	}

	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("/getAutomovel/{id}")
	public Automoveis GetAutomovel(@PathParam("id") Integer id) {
		AutomoveisEntity entity = repository.GetAutomovel(id);

		if (entity != null)
			return new Automoveis(entity.getId(), entity.getModelo(), entity.getCor(), entity.getPlaca());
		return null;
	}

	@DELETE
	@Produces("application/json; charset=UTF-8")
	@Path("/excluirAutomovel/{id}")
	public String ExcluirAutomovel(@PathParam("id") Integer id) {

		try {

			repository.ExcluirAutomovel(id);

			return "Automovel excluido com sucesso!";

		} catch (Exception e) {

			return "Erro ao excluir o Automovel! " + e.getMessage();
		}

	}
}
