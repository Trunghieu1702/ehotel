package com.mta.ehotel.mgr;

import javax.annotation.PostConstruct;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.mta.ehotel.dao.BaseDao;
import com.mta.ehotel.entity.BaseEntity;
import com.mta.ehotel.object.BaseObject;

public abstract class BaseMgr {

	@PostConstruct
	public void init() {
		onPostConstruct();
	}

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		onApplicationStarted();
	}

	protected void onPostConstruct() {
		// Override this
	}

	protected void onApplicationStarted() {
		// Override this
	}

	/**
	 * Get DAO object.
	 * @return
	 */
	public BaseDao getDAO() {
		return null;
	}
	
	/**
	 * Find entity by primary key.
	 * @param clazz
	 * @param primaryKey
	 * @return
	 */
	public BaseEntity find(Class<?> clazz, Object primaryKey) {
		return getDAO().find(clazz, primaryKey);
	}
	
	/**
	 * Write entity.
	 * @param object
	 */
	public void persist(BaseObject object) {
		object.finishUpdate();
		BaseEntity entity = object.getDbEntity();
		getDAO().persist(entity);
		object.onDbEntityPersisted(entity);
	}
	
	/**
	 * Write entity.
	 * @param entity
	 */
	public void persist(BaseEntity entity) {
		getDAO().persist(entity);
	}
	
	/**
	 * Remove entity.
	 * @param object
	 */
	public void remove(BaseObject object) {
		BaseEntity entity = object.getDbEntity();
		getDAO().remove(entity);
		object.onDbEntityRemoved(entity);
	}
	
	/**
	 * Write entity.
	 * @param entity
	 */
	public void remove(BaseEntity entity) {
		getDAO().remove(entity);
	}
	
	/**
	 * Refresh entity.
	 * @param object
	 */
	public void refresh(BaseObject object) {
		BaseEntity entity = object.getDbEntity();
		getDAO().refresh(entity);
		object.onDbEntityRefreshed(entity);
	}
	
	/**
	 * Write entity.
	 * @param entity
	 */
	public void refresh(BaseEntity entity) {
		getDAO().refresh(entity);
	}
	
}
