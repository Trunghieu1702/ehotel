package com.mta.ehotel.controller;

import java.util.Map;

import org.springframework.ui.Model;

public abstract class BaseController {
	
	
	protected void GetTitle(Model model,String Page,Map<String,String> function) {
		model.addAttribute("title", Page);
		model.addAttribute("btnFunction", function);
	}
}
