package com.mta.ehotel.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mta.ehotel.dto.UserDisplay;
import com.mta.ehotel.object.CtxUser;
import com.mta.ehotel.object.NhanVien;
import com.mta.ehotel.utils.EncrytedPasswordUtils;

@Controller
public class NhanVienController extends BaseController {

	Map<String, String> funtionTitle = new HashMap<String, String>();

	@RequestMapping(value = "/ViewNhanVien", method = RequestMethod.GET)
	public String userPage(Model model, Principal principal) {
		try {
			funtionTitle.put("edit", "UpdteNhanVien");
			GetTitle(model, "Tài Khoản của tôi", funtionTitle);
			CtxUser user = getCtxUser();
			NhanVien nv = nhanVienMgr().findUserAccount(user.getUsername());
			model.addAttribute("user", user);
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
			CtxUser user = getCtxUser();
			
			NhanVien nv = nhanVienMgr().findUserAccount(user.getUsername());
			
			model.addAttribute("user", user);
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
			CtxUser ctxUser = getCtxUser();
			
			NhanVien nv = nhanVienMgr().findUserAccount(ctxUser.getUsername());
			
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
			nhanVienMgr().persist(nv);
			
			model.addAttribute("user", ctxUser);
			model.addAttribute("readonly", true);
			return "nhanvienPage";
		} catch (Exception e) {
			model.addAttribute("message", e);
			return "403Page";
		}
	}
}
