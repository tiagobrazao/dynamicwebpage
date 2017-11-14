package com.tb.mvc.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.tb.mvc.model.Project;
import com.tb.mvc.model.UploadFile;
import com.tb.mvc.service.impl.IProjectService;
import com.tb.mvc.service.impl.IUploadFileService;

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
	
	@Autowired
    private IUploadFileService file_service;
	
	private Validator validator;
	
	public ProjectController()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        this.validator = validatorFactory.getValidator();
    }

	
	/**
	 * Get method to retrieve form erros or display first time
	 * @param personForm
	 * @return
	 */
	@GetMapping("/form_project")
    public String showForm(Project project) {
        return "form_test";
    }
	
	//deprecaded show all projects in add project
	/*@RequestMapping({"/form_project"})
	public String project_form(Model model) {
		List<Project> projects = project_service.findAll(); 
		model.addAttribute("projects", projects);
		return "form_test";
	}*/
	
	//@RequestMapping(value = "form_project/add_project", method = RequestMethod.POST)
	//public String addProject(@Valid @ModelAttribute("project")Project project, BindingResult result,
		//	@RequestParam CommonsMultipartFile[] fileUpload) {
	
	//public String addProject(Project project, @RequestParam CommonsMultipartFile[] fileUpload) {
			
	//		if (result.hasErrors()) return "form_test";
	@PostMapping(value = "form_project/add_project")
    public String addProject(@ModelAttribute("project") @Valid Project project, BindingResult result,
    		@RequestParam CommonsMultipartFile[] fileUpload) {
 
        if (result.hasErrors()) return "form_test";
        			
        	/**
			 * Saves file creating a new persisted pojo
			 * Warning: needs to check if image already in db
			 */
	        if (fileUpload != null && fileUpload.length > 0) {
	            for (CommonsMultipartFile aFile : fileUpload){
	              
	            	UploadFile uploadFile = new UploadFile();
	                uploadFile.setFileName(aFile.getOriginalFilename());
	                uploadFile.setData(aFile.getBytes());
	                
	                //save file- Warning -put file already exists control
	                file_service.create(uploadFile);
	                
	                UploadFile newUploadFile = file_service.findOne(uploadFile.getId());
	                
	                /*
	                //Test Persisted image
	                Toolkit tk = Toolkit.getDefaultToolkit();  
	                Image icon = tk.createImage(newUploadFile.getData());  
	                ImageIcon im = new ImageIcon(icon);  
	                JFrame frame = new JFrame();  
	                frame.setSize(600, 600);  
	                JLabel lFoto = new JLabel();  
	                lFoto.setIcon(im);  
	                frame.add(lFoto);  z
	                frame.setVisible(true);
	                */
	                
	                project.setPhoto(newUploadFile);
	            }
	        }
	  		
	        //Save project
	        project_service.create(project);
	        
	        return "redirect:project_view";
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
