package com.senac.css.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senac.css.repository.entity.ClientesEntity;

public class ClientesRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public ClientesRepository() {
		// Criando o Entity Manager com as propriedas do persistence.xml
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_honda");
		this.entityManager = this.entityManagerFactory.createEntityManager();	
	}
	
	// Cria Novo Registro no BD
	public void Salvar(ClientesEntity clientesEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(clientesEntity);
		this.entityManager.getTransaction().commit();
	}
	
	// Altera registro no BD
	public void Alterar(ClientesEntity clientesEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(clientesEntity);
		this.entityManager.getTransaction().commit();
	}
	
	// Retorna todos os clientes
	@SuppressWarnings("unchecked")	
	public List<ClientesEntity> TodosClientes(){
		return this.entityManager.createQuery("SELECT p FROM ClientesEntity p ORDER BY p.nome").getResultList();
	}
	
	// Consulta um cliente pelo código
	public ClientesEntity GetCliente(Integer id) {
		return this.entityManager.find(ClientesEntity.class, id);
	}
	
	// Excluindo cliente pelo código
	public void Excluir(Integer id) {
		ClientesEntity cliente = this.GetCliente(id);
		
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cliente);
		this.entityManager.getTransaction().commit();
	}

}
