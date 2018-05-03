package com.senac.css.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senac.css.repository.entity.FuncionariosEntity;

public class FuncionariosRepository {
	
	private final EntityManagerFactory entityManagerFactory;
	private final EntityManager entityManager;
	
	public FuncionariosRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_honda");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void SalvarFuncionario(FuncionariosEntity funcionariosEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(funcionariosEntity);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}
	
	public void AlterarFuncionario(FuncionariosEntity funcionariosEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(funcionariosEntity);
		this.entityManager.getTransaction().commit();
		// this.entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<FuncionariosEntity> TodosFuncionarios(){
		return this.entityManager.createQuery("SELECT p FROM FuncionariosEntity p ORDER BY p.nome").getResultList();
	}
	
	
	public FuncionariosEntity GetFuncionario(Integer id) {
		return this.entityManager.find(FuncionariosEntity.class, id);
	}
	
	public void ExcluirFuncionario(Integer id) {
		FuncionariosEntity funcionario = this.GetFuncionario(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(funcionario);
		this.entityManager.getTransaction().commit();
	}

}
