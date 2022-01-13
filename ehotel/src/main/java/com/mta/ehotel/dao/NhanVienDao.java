package com.mta.ehotel.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mta.ehotel.entity.DbNhanVien;

@Repository
@Transactional
public class NhanVienDao {

	@Autowired
	private EntityManager entityManager;

	public DbNhanVien findUserAccount(String userName) {
		try {
			String sql = "Select e from " + DbNhanVien.class.getName() + " e " //
					+ " Where e.code = :userName ";

			Query query = entityManager.createQuery(sql, DbNhanVien.class);
			query.setParameter("userName", userName);

			return (DbNhanVien) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}