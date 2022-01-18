package com.mta.ehotel.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mta.ehotel.dao.NhanVienDao;
import com.mta.ehotel.dto.UserDisplay;
import com.mta.ehotel.entity.DbNhanVien;
import com.mta.ehotel.object.NhanVien;
import com.mta.ehotel.utils.EncrytedPasswordUtils;
import com.mta.ehotel.utils.WebUtils;

@Controller
public class NhanVienController extends BaseController {

	@Autowired
	private NhanVienDao nhanVienDao;

	Map<String, String> funtionTitle = new HashMap<String, String>();

	@RequestMapping(value = "/ViewNhanVien", method = RequestMethod.GET)
	public String userPage(Model model, Principal principal) {
		try {
			funtionTitle.put("edit", "UpdteNhanVien");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
			DbNhanVien dbNV = nhanVienDao.findUserAccount(loginedUser.getUsername());
			NhanVien nv = new NhanVien(dbNV);
			model.addAttribute("user", nv);
			model.addAttribute("UserDisplay", new UserDisplay(nv));
			model.addAttribute("readonly", true);
			return "nhanvienPage";
			
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/UpdteNhanVien", method = RequestMethod.GET)
	public String updateUserPage(Model model, Principal principal) {
		try {
			funtionTitle.put("edit", "UpdteNhanVien");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
			DbNhanVien dbNV = nhanVienDao.findUserAccount(loginedUser.getUsername());
			NhanVien nv = new NhanVien(dbNV);
			model.addAttribute("user", nv);
			model.addAttribute("UserDisplay", new UserDisplay(nv));
			model.addAttribute("readonly", false);
			return "nhanvienPage";

		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}

	@RequestMapping(value = "/saveNhanVien", method = RequestMethod.POST)
	public String saveUserPage(Model model, Principal principal, @ModelAttribute("UserDisplay") UserDisplay user) {
		try {
			funtionTitle.put("edit", "UpdteNhanVien");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			User loginedUser = (User) ((Authentication) principal).getPrincipal();
			String userInfo = WebUtils.toString(loginedUser);
			model.addAttribute("userInfo", userInfo);
			DbNhanVien nv = nhanVienDao.findUserAccount(loginedUser.getUsername());
			nv.setAddress(user.getAddress());
			nv.setBirthday(user.getBirthday());
			nv.setCode(user.getCode());
			nv.setEmail(user.getEmail());
			nv.setName(user.getName());
			nv.setPassword(EncrytedPasswordUtils.encrytePassword(user.getPassword()));
			nv.setPhone_number(user.getPhone_number());
			nv.setRole(user.getRole());
			nv.setSex(user.getSex());
			nv.setStart_date(user.getStart_date());
			nv.setStatus(user.getStatus());
			nhanVienDao.persist(nv);
			return "nhanvienPage";
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}
}
