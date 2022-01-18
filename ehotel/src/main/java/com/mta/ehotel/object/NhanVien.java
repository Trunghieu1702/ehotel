package com.mta.ehotel.object;

import java.sql.Timestamp;

import com.mta.ehotel.dto.UserDisplay;
import com.mta.ehotel.entity.BaseEntity;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.utils.StrUtils;

public class NhanVien extends BaseObject implements BaseUser{

	private DbNhanVien dbNhanVien;
	
	@Override
	public String getUsername() {
		dbNhanVien.getCode();
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
//	public void setNhanVien(UserDisplay user) {
//		
//		setAddress(user.getAddress());
//		setBirthday(user.getBirthday());
////		setCode(user.getCode());
//		setEmail(user.getEmail());
//		setName(user.getName());
//		setPassword(user.getPassword());
//		setPhone_number(user.getPhone_number());
//		setRole(user.getRole());
//		setSex(user.getSex());
//		setStart_date(user.getStart_date());
//		setStatus(user.getStatus());
//	}
	/*
	 * addd method
	 */
	
	public String getCode() {
		return dbNhanVien.getCode();
	}

	public void setCode(String code) {
		dbNhanVien.setCode(code);
	}

	public String getName() {
		return dbNhanVien.getName();
	}

	public void setName(String name) {
		dbNhanVien.setName(name);
	}

	public String getPassword() {
		return dbNhanVien.getPassword();
	}

	public void setPassword(String password) {
		dbNhanVien.setPassword(password);
	}

	public Timestamp getBirthday() {
		return dbNhanVien.getBirthday();
	}

	public void setBirthday(Timestamp birthday) {
		dbNhanVien.setBirthday(birthday);
	}
	
	public void setBirthday(String birthday) {
		dbNhanVien.setBirthday(birthday);
	}

	public String getSex() {
		return dbNhanVien.getSex();
	}

	public void setSex(String sex) {
		dbNhanVien.setSex(sex);
	}

	public String getAddress() {
		return dbNhanVien.getAddress();
	}

	public void setAddress(String address) {
		dbNhanVien.setAddress(address);
	}

	public String getEmail() {
		return dbNhanVien.getEmail();
	}

	public void setEmail(String email) {
		dbNhanVien.setEmail(email);
	}

	public String getPhone_number() {
		return dbNhanVien.getPhone_number();
	}

	public void setPhone_number(String phone_number) {
		dbNhanVien.setPhone_number(phone_number);
	}

	public Timestamp getStart_date() {
		return dbNhanVien.getStart_date();
	}

	public void setStart_date(Timestamp start_date) {
		dbNhanVien.setStart_date(start_date);
	}
	
	public void setStart_date(String start_date) {
		dbNhanVien.setStart_date(start_date);
	}

	public String getRole() {
		return dbNhanVien.getRole();
	}

	public void setRole(String role) {
		dbNhanVien.setRole(role);
	}

	public int getStatus() {
		return dbNhanVien.getStatus();
	}

	public void setStatus(int status) {
		dbNhanVien.setStatus(status);
	}

	public int getDeleteflag() {
		return dbNhanVien.getDeleteflag();
	}

	public void setDeleteflag(int deleteflag) {
		dbNhanVien.setDeleteflag(deleteflag);
	}
	
	
	@Override
	public BaseEntity getDbEntity() {
		return getDbNhanVien();
	}
	
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
