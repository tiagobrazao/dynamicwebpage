package com.tb.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for login.
 * 
 * @author Tiago Braz�o
 *
 */
@Controller
public class LoginController {
	
	@RequestMapping("doLogin")
	public String doLogin() {
	    return "home";
	}
}
