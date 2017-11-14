package com.tb.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tb.mvc.model.DropView;
import com.tb.mvc.model.Project;
import com.tb.mvc.model.UploadFile;
import com.tb.mvc.service.impl.IDropViewService;
import com.tb.mvc.service.impl.IProjectService;
import com.tb.mvc.service.impl.IUploadFileService;

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
	
	@Autowired
	private IDropViewService drop_view_service;
	
	@Autowired
	private IUploadFileService uploadfile_service;
	
	@RequestMapping({"/", "/index"})
	public String index_view(Model model) {
		//For project name (link) dropdown
		List<Project> projects = project_service.findAll(); 
		model.addAttribute("projects", projects);
		
		//For drop view dropdown
		List<DropView> drop_views = drop_view_service.findAll();
		model.addAttribute("dropviews", drop_views);
		
		//Logged user
		model.addAttribute("loggedinuser", LoginController.getPrincipal());
		
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

	@RequestMapping({"/form_project2"})
	public String dropview_form(Model model) {
		return "dropviewform";
	}
	
	@RequestMapping({"/gallery_view"})
	public String showGallery(Model model) {
		//For project name (link) dropdown
		List<UploadFile> files = uploadfile_service.findAll(); 
		model.addAttribute("files", files);
		
		return "gallery";
	}
	
	@RequestMapping({"/play"})
	public String playgame() {
		return "game_puzzle";
	}
}
