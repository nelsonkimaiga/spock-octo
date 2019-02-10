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

import com.example.jobonics.model.CreateProfile;
import com.example.jobonics.service.CreateProfileService;



@Controller

public class CreateProfileController {
	
	
	@Autowired
	private CreateProfileService CPS;
	
	///this is for jobseekers to create their profile
	
	@RequestMapping(value="/newprofile",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CreateProfile createprofile = new CreateProfile();
		model.addAttribute("profile",createprofile);
		return "newprofile";
	}
	
	///save jobseekers profile
	@RequestMapping(value="/saveprofiles",method=RequestMethod.POST)
	public String saveRegistration(@Valid CreateProfile createprofile,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "newprofile";
		}
	
		CPS.save(createprofile);
		
		return "redirect:/viewprofiles";
	}
	
	//redirected to a list of job seekers profiles////advise if ther are any necessar templates
	@RequestMapping(value="/viewprofiles")
	public ModelAndView getAll() {
		
		List<CreateProfile> list=CPS.findAll();
		return new ModelAndView("viewprofile","list",list);
	}
	
	
}
