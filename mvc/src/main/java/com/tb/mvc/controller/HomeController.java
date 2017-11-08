package com.tb.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tb.mvc.model.Project;
import com.tb.mvc.service.impl.IProjectService;

/**
 * Home page Controller. 
 * Autowireds a Project Service to display dropdown for projects view.
 * 
 * @author Tiago Brazão
 *
 */
@Controller
public class HomeController {
	
	@Autowired
    private IProjectService project_service;
    
	@RequestMapping({"/index"})
	public String index_view(Model model) {
		//For project name (link) dropdown
		List<Project> projects = project_service.findAll(); 
		model.addAttribute("projects", projects);
		
		//return "helloWorld";
		return "home";
	}
	
	@RequestMapping({"/login"})
	public String login_form() {
		return "login";
	}
	
	@RequestMapping({"/about"})
	public String about_view() {
		return "about";
	}
	
	@RequestMapping({"/form_project"})
	public String project_form(Model model) {
		List<Project> projects = project_service.findAll(); 
		model.addAttribute("projects", projects);
		return "form_test";
	}
	
}
