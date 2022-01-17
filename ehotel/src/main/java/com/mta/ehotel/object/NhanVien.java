package com.mta.ehotel.object;

import com.mta.ehotel.entity.BaseEntity;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.utils.StrUtils;

public class NhanVien extends BaseObject implements BaseUser{

	private DbNhanVien dbNhanVien;
	
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	public DbNhanVien getDbNhanVien() {
		return dbNhanVien;
	}

	public void setDbNhanVien(DbNhanVien dbNhanVien) {
		this.dbNhanVien = dbNhanVien;
	}

	public NhanVien() {
		this(new DbNhanVien());
	}
	
	public NhanVien(DbNhanVien dbNhanVien) {
		setDbNhanVien(dbNhanVien);
	}
	
	@Override
	public BaseEntity getDbEntity() {
		return getDbNhanVien();
	}
	/*
	 * addd method
	 */

	@Override
	public boolean validate() {
		return validateUsername()&& validateEmail();
	}

	@Override
	public void finishUpdate() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean validateUsername() {
		// Name must not be empty or null
		String name = getUsername();
		return name != null && name.length() > 0;
	}
	
	public boolean validateEmail() {
		return StrUtils.isEmailAddress(getEmail());
	}
	 
}
