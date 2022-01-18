package com.mta.ehotel.mgr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.mta.ehotel.dao.BaseDao;
import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.object.CtxUser;
import com.mta.ehotel.object.NhanVien;

@Component
public class NhanVienMgr  extends BaseMgr{

	static NhanVienMgr instance;
	
	@Autowired
	private NhanVienDao nhanVienDao;
	
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
	
	public NhanVien findUserAccount(String username) {
		DbNhanVien nv = nhanVienDao.findUserAccount(username);
		if(nv==null) return new NhanVien();
		return new NhanVien(nv);
	}
	
	public CtxUser getContextUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			try {
				return (CtxUser) authentication.getPrincipal();
			} catch (ClassCastException e) {
				return null;
			}
		}
		return null;
	}
}
