package com.tb.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tb.mvc.model.DropView;
import com.tb.mvc.service.IService;

/**
 * Controller for Project actions related.
 * Autowireds a ProjectService 
 * 
 * @author Tiago Brazão
 *
 */
@Controller
public class DropViewController {
	
	@Autowired
    private IService<DropView, Integer> drop_view__service;

	@RequestMapping(value = "form_project2/add_view", method = RequestMethod.POST)
	public String addDropView(DropView drop_view) {
	  		
	        //Save project
		drop_view__service.create(drop_view);
	
	    return "home";
	}

}
