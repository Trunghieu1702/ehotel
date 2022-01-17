package com.mta.ehotel.mgr;

import org.springframework.beans.factory.annotation.Autowired;

import com.mta.ehotel.dao.BaseDao;
import com.mta.ehotel.dao.NhanVienDao;

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
}
