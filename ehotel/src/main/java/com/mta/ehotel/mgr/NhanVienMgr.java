package com.mta.ehotel.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.mta.ehotel.dao.BaseDao;
import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.exception.UserNotFoundException;
import com.mta.ehotel.object.NhanVien;

public class NhanVienMgr  extends BaseMgr{

	static NhanVienMgr instance;
	
	@Autowired
	private static NhanVienDao nhanVienDao;
	
	public NhanVienMgr() {
		super();
		instance = this;
	}
	
	@Override
	public BaseDao getDAO() {
		return nhanVienDao;
	}
	
	public static NhanVienMgr get() {
		return instance;
	}
	
	public static NhanVien findUserAccount(String username) {
		DbNhanVien nv = nhanVienDao.findUserAccount(username);
		if(nv==null) return new NhanVien();
		return new NhanVien(nv);
	}
}
