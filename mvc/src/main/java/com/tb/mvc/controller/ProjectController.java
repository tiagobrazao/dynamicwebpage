package com.tb.mvc.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tb.mvc.model.Project;
import com.tb.mvc.model.UploadFile;
import com.tb.mvc.service.impl.IProjectService;

/**
 * Controller for Project actions related.
 * Autowireds a ProjectService 
 * 
 * @author Tiago Brazão
 *
 */
@Controller
public class ProjectController {
	
	@Autowired
    private IProjectService project_service;

	@RequestMapping(value = "form_project/add_project", method = RequestMethod.POST)
	public String addProject(Project project, 
			@RequestParam CommonsMultipartFile[] fileUpload) {
		
			/**
			 * Saves file creating a new persisted pojo
			 * Warning: needs to check if image already in db
			 */
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	              
	            	UploadFile uploadFile = new UploadFile();
	                uploadFile.setFileName(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());
	                
	                System.out.println("Ficheiro: " + aFile.getOriginalFilename());
	                //fileUploadDao.save(uploadFile);               
	            }
	        }
	  		
	        //Save project
	        project_service.create(project);
	
	        return "project_view";
	}
	
	@RequestMapping({"/view_project", "form_project/view_project"})
	public String view_project(int id, Model model) {
		Project project = project_service.findOne(id);
		model.addAttribute("project", project);
		
		return "project_view";
	}
	
	@RequestMapping({"/remove_project", "form_project/remove_project"})
	public String remove_project(Integer id) {
		 Project project = project_service.findOne(id);
		 project_service.delete(project);
		 
		 return "form_test";
	}
	
	@RequestMapping("/form_project/close_project")
	public void close_project(Integer id, HttpServletResponse response) {
	  //Project project = (Project) DAOUtils.getFromID(Project.class, id);
	  //project.setClosed(true);
	  //project.merge();
	  //project.save();
	
	  //response.setStatus(200);
	}

}
