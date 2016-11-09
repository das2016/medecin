package com.rdvmedecin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author SKAN
 * 
 */
@Controller
@RequestMapping("/")
public class IndexController {

	private static final String INDEX = "static/index.html";

	/**
	 * Welcome Page
	 * 
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return INDEX;
	}
}
