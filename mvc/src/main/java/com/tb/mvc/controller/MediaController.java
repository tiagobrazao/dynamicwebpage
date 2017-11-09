package com.tb.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tb.mvc.model.UploadFile;
import com.tb.mvc.service.impl.IUploadFileService;

/**
 * Media controller take advantage of the Message Conversion and Content Negotiation features of the Spring MVC Framework. 
 * In spring-context we register an appropriate message converter based on the return type of the controller method 
 * (ByteArrayHttpMessageConverter for example needed for correct conversion of bytes array to an image file).
 * 
 * @author Tiago Brazão
 *
 */
@Controller
public class MediaController {
	
	@Autowired 
	IUploadFileService file_service;
	
	/**
	 * Returns a the image byte[] in ResponseBody
	 * {id} the id of the uploadFile instance
	 */
	@RequestMapping (
			value= {"/image/{id}", 
					"/form_project/image/{id}", 
					"/gallery_view/image/{id}"}, 
					method = RequestMethod.GET)
	public @ResponseBody byte[] getImageAsByteArray(@PathVariable final String id) {
		UploadFile uploadFile = file_service.findOne(new Integer(id));
		return uploadFile.getData();
	}
}
