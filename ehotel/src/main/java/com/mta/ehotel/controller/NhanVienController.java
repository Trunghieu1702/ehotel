package com.mta.ehotel.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.utils.WebUtils;

@Controller
public class NhanVienController {

	@Autowired
	private NhanVienDao nhanVienDao;
	
	@RequestMapping(value = "/ViewNhanVien", method = RequestMethod.GET)
	public String adminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		DbNhanVien nv = nhanVienDao.findUserAccount(loginedUser.getUsername());
		model.addAttribute("user", nv);
		model.addAttribute("readonly", true);
		return "adminPage";
	}
	@RequestMapping(value = "/UpdteNhanVien", method = RequestMethod.GET)
	public String updateAdminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		DbNhanVien nv = nhanVienDao.findUserAccount(loginedUser.getUsername());
		model.addAttribute("user", nv);
		model.addAttribute("readonly", false);
		return "adminPage";
	}
	
	@RequestMapping(value = "/saveNhanVien", method = RequestMethod.GET)
	public String saveAdminPage(Model model, Principal principal) {

		User loginedUser = (User) ((Authentication) principal).getPrincipal();

		String userInfo = WebUtils.toString(loginedUser);
		model.addAttribute("userInfo", userInfo);
		DbNhanVien nv = nhanVienDao.findUserAccount(loginedUser.getUsername());
		model.addAttribute("user", nv);
		model.addAttribute("readonly", true);
		return "adminPage";
	}
}
