package com.example.jobonics.Web.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.Persistence.model.CompanyProfileDetails;
import com.example.jobonics.service.CompanyProfileDetailsService;

@Controller

public class CompanyProfileDetailsController {

	@Autowired
	private CompanyProfileDetailsService CPDS;
///create comp profile
	@RequestMapping(value = "/company_profile", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CompanyProfileDetails createprofile = new CompanyProfileDetails();
		model.addAttribute("kompanyprof", createprofile);
		return "recruiter_create_profile";
	}
	
	////saving company profiles >>>template not yet 

	@RequestMapping(value = "/create_profile", method = RequestMethod.POST)
	public String saveRegistration(@Valid CompanyProfileDetails createprofile, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "recruiter_create_profile";
		}

		CPDS.save(createprofile);
		///after a company creates its profile ...redirects to its own page

		return "redirect:/company_profile";
	}

	
}
