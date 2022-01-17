package com.mta.ehotel.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mta.ehotel.entity.BaseEntity;

@Repository
@Transactional
public class BaseDao {

	@Autowired
	protected EntityManager entityManager;
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Find entity by primary key.
	 * @param clazz
	 * @param primaryKey
	 * @return
	 */
	public BaseEntity find(Class<?> clazz, Object primaryKey) {
		return (BaseEntity) entityManager.find(clazz, primaryKey);
	}
	
	/**
	 * Write entity.
	 * @param entity
	 */
	public void persist(BaseEntity entity) {
		entityManager.persist(entity);
	}
	
	/**
	 * Remove entity.
	 * @param entity
	 */
	public void remove(BaseEntity entity) {
		entityManager.remove(entity);
	}
	
	/**
	 * Refresh entity.
	 * @param entity
	 */
	public void refresh(BaseEntity entity) {
		entityManager.refresh(entity);
	}
	
	public void merge(BaseEntity entity) {
		entityManager.merge(entity);
	}
}
