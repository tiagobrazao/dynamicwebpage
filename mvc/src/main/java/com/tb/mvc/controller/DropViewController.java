package com.tb.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tb.mvc.model.DropLabel;
import com.tb.mvc.model.DropView;
import com.tb.mvc.service.impl.IDropViewService;

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
    private IDropViewService drop_view_service;

	@RequestMapping(value = "form_project2/add_view", method = RequestMethod.POST)
	public String addDropView(DropView dropview) {
		
		//Drop Labels (before save / managed dropview)
		List<DropLabel> labels = dropview.getDrop_labels();
		
	    //Save DropView
		drop_view_service.create(dropview);
		
		//Put managed dropview in labels and save
		
		
		//Save Labels with managed dropview
		drop_view_service.saveLabels(dropview, labels);
		
	    return "home";
	}

}
