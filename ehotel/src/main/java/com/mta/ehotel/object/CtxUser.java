package com.mta.ehotel.object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.mta.ehotel.entity.DbNhanVien;
@SuppressWarnings("serial")
public class CtxUser extends User implements BaseUser{

	private String role;
	private String name;
	private String email;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private DbNhanVien userObject;
	
	public CtxUser(DbNhanVien dbNhanVien) {
		super(dbNhanVien.getCode(), dbNhanVien.getPassword(), (dbNhanVien.getStatus()==0), true, true, true, createAuthority(dbNhanVien));
		setUser(dbNhanVien);
	}

	public DbNhanVien getUserObject() {
		return userObject;
	}

	public void setUserObject(DbNhanVien userObject) {
		this.userObject = userObject;
	}

	public static List<GrantedAuthority> createAuthority(DbNhanVien dbNhanVien) {
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + dbNhanVien.getRole().toString());
		grantList.add(authority);
		return grantList;
	}
	
	

	public void setUser(DbNhanVien user) {
		userObject = user;
		setEmail(user.getEmail());
		setRole(user.getRole());
		setName(user.getName());
	}
}
