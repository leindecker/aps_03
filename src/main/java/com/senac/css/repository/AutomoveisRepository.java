package com.senac.css.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.senac.css.repository.entity.AutomoveisEntity;

public class AutomoveisRepository {

	private final EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public AutomoveisRepository() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence_unit_honda");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	
	public void SalvarAutomovel(AutomoveisEntity automoveisEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.persist(automoveisEntity);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}
	
	public void AlterarAutomovel(AutomoveisEntity automoveisEntity) {
		this.entityManager.getTransaction().begin();
		this.entityManager.merge(automoveisEntity);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<AutomoveisEntity> TodosAutomoveis(){
		return this.entityManager.createQuery("SELECT p FROM AutomoveisEntity p ORDER BY p.modelo").getResultList();
	}
	
	public AutomoveisEntity GetAutomovel(Integer id) {
		return this.entityManager.find(AutomoveisEntity.class, id);
	}
	
	public void ExcluirAutomovel(Integer id) {
		AutomoveisEntity automovel = this.GetAutomovel(id);
		this.entityManager.getTransaction().begin();
		this.entityManager.remove(automovel);
		this.entityManager.getTransaction().commit();
		this.entityManager.close();
	}
	
}
