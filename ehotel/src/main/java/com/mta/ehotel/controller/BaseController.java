package com.mta.ehotel.controller;

import java.util.Map;

import org.springframework.ui.Model;

import com.mta.ehotel.mgr.NhanVienMgr;
import com.mta.ehotel.object.CtxUser;

public abstract class BaseController {
	
	
	protected void GetTitle(Model model,String Page,Map<String,String> function) {
		model.addAttribute("title", Page);
		model.addAttribute("btnFunction", function);
	}
	

	
	protected NhanVienMgr nhanVienMgr() {
		return NhanVienMgr.get();
	}
	
	protected CtxUser getCtxUser() {
		return NhanVienMgr.get().getContextUser();
	}
}
