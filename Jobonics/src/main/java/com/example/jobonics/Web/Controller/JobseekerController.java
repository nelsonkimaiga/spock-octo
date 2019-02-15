package com.example.jobonics.Web.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.jobonics.Persistence.model.NewJobs;
import com.example.jobonics.service.NewJobsService;



@Controller

public class JobseekerController {
	
	@Autowired
	private NewJobsService NJS;
	
	//the path /jobseeker takes you to the main page where we have the list of jobs and list of new companies 
	//my next job is to work on the double querying of the tables "company" and "newjobs"
	
	@RequestMapping(value="/jobseeker")
	public ModelAndView getAll() {
		
		List<NewJobs> list=NJS.findAll();
		return new ModelAndView("jobseeker","list",list);
		
	}
	
	
	

}