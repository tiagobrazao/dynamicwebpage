package com.tb.mvc.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tb.mvc.model.Project;
import com.tb.mvc.service.impl.IProjectService;
 
@Controller
public class ImageController  {
 
	@Autowired
    private IProjectService project_service;
	
	//@RequestMapping({"/form_project/image/*", "/image/*"})
    public void handleRequest(Integer id, HttpServletResponse response)  {
        
		Project project= project_service.findOne(id);
        byte[] thumb = project.getPhoto().getData();
        
        String name = project.getPhoto().getFileName();
        response.setContentType("image/png");
        response.setContentLength(thumb.length);
        response.setHeader("Content-Disposition", "inline; filename=\"" + name + "\"");
 
        BufferedInputStream input = null;
        BufferedOutputStream output = null;
 
        try {
            input = new BufferedInputStream(new ByteArrayInputStream(thumb));
            output = new BufferedOutputStream(response.getOutputStream());
            byte[] buffer = new byte[8192];
            int length;
            while ((length = input.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
        } catch (IOException e) {
            System.out.println("There are errors in reading/writing image stream "
                    + e.getMessage());
        } finally {
            if (output != null)
                try {
                    output.close();
                } catch (IOException ignore) {
                }
            if (input != null)
                try {
                    input.close();
                } catch (IOException ignore) {
                }
        }
 
    }
}