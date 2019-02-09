package com.example.jobonics.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.model.CompanyAccount;
import com.example.jobonics.model.NewJobs;

import com.example.jobonics.service.CompanyAccountService;
import com.example.jobonics.service.NewJobsService;



@Controller
@SessionAttributes("newjobs")
public class NewJobsController {
	
	@Autowired
	private NewJobsService NJS;
	@Autowired
	private CompanyAccountService CAS;
	
	
	
	/// this code controls creation of  new jobs
	@ModelAttribute("newjobs")
	@RequestMapping(value="/newjob",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		NewJobs newJobs = new NewJobs();
		model.addAttribute("newjobs",newJobs);
		return "new_job";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegistration(@Valid NewJobs newJobs,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "new_job";
		}
	
		NJS.save(newJobs);
		///after new job creation....testing if the job appears in the job seekers UI
		
		return "redirect:/newjob";
	}
	
	
	@RequestMapping(value="/openings")
	public ModelAndView getAll() {
		
		List<NewJobs> list=NJS.findAll();
		return new ModelAndView("openings","list",list);
	}
	

}