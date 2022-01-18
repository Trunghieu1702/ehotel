package com.mta.ehotel.dto;

import java.time.format.DateTimeFormatter;

import com.mta.ehotel.object.NhanVien;

public class UserDisplay {
	private String code;

	private String name;

	private String password;

	private String birthday;

	private String sex;

	private String address;

	private String email;

	private String phone_number;

	private String start_date;

	private String role;

	private int status;

	private int deleteflag;

	private String imgurl;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}
	
	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public UserDisplay() {}
	
	public UserDisplay(NhanVien nv) {
		DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.name=nv.getName();
		this.code= nv.getCode();
		this.address = nv.getAddress();
		this.birthday= nv.getBirthday().toLocalDateTime().format(FORMATTER);
		this.email = nv.getEmail();
		this.password=nv.getPassword();
		this.phone_number=nv.getPhone_number();
		this.role=nv.getRole();
		this.sex=nv.getSex();
		this.start_date = nv.getStart_date().toLocalDateTime().format(FORMATTER);
		this.status = nv.getStatus();
		this.imgurl = nv.getImgurl();
	}

	public String getAvatarImagePath() {
		if(imgurl==null||code ==null) return null;
		return "/Upload/Avatar/"+code+"/"+imgurl;
	}
}
