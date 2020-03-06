package com.jamey.summer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
public class DairyController {
	
	
	@RequestMapping(value = "/summer/diary/upload", method = RequestMethod.POST)
	@ResponseBody
	public boolean imageUpload(HttpServletRequest request) {
		MultipartHttpServletRequest params=((MultipartHttpServletRequest) request); 
		List<MultipartFile> files=((MultipartHttpServletRequest) request).getFiles("file");   
        String name=params.getParameter("userid");  
        System.out.println("userid:"+name);  
        
		
		
		System.out.println("hehe:"+"files:"+files.size());
		return true;
	}
}
