package com.example.jobonics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.model.NewJobs;
import com.example.jobonics.service.NewJobsService;



@Controller

public class JobseekerController {
	
	@Autowired
	private NewJobsService NJS;
	
	///this just trial before i set up a query that will have two tables queried>>>company for the company name and logo
	////jobs for the job desc
	
	@RequestMapping(value="/jobseeker")
	public ModelAndView getAll() {
		
		List<NewJobs> list=NJS.findAll();
		return new ModelAndView("jobseeker","list",list);
	}

}