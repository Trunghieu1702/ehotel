package com.mta.ehotel.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BaseDao {

	@Autowired
	protected EntityManager entityManager;
	
//	protected void persist(object<T> object) {
//		
//	}
}
