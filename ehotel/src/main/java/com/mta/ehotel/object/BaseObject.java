package com.mta.ehotel.object;

import com.mta.ehotel.entity.BaseEntity;

public abstract class BaseObject {
	/**
	 * Validate the object.
	 * 
	 * @return
	 */
	public abstract boolean validate();

	/**
	 * This method must be called every time before the entity object is persisted
	 * to DB.
	 */
	public abstract void finishUpdate();

	/**
	 * Return the Db entity object under.
	 * 
	 * @return
	 */
	public abstract BaseEntity getDbEntity();

	/**
	 * Called when an under covered entity has been persisted.
	 * 
	 * @param entity
	 */
	public void onDbEntityPersisted(BaseEntity entity) {
		// Override this
	}

	/**
	 * Called when an under covered entity has been removed.
	 * 
	 * @param entity
	 */
	public void onDbEntityRemoved(BaseEntity entity) {
		// Override this
	}

	/**
	 * Called when an under covered entity has been refreshed.
	 * 
	 * @param entity
	 */
	public void onDbEntityRefreshed(BaseEntity entity) {
		// Override this
	}

	protected String checkNullToParseNumber(String input) {
		return input == null || input.isEmpty() ? "0" : input;
	}
}
