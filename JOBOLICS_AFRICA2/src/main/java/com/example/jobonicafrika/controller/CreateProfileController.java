package com.example.jobonicafrika.controller;

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

import com.example.jobonicafrika.model.CreateProfile;
import com.example.jobonicafrika.service.CreateProfileService;



@Controller

public class CreateProfileController {
	
	
	@Autowired
	private CreateProfileService CPS;
	
	@RequestMapping(value="/newprofile",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CreateProfile createprofile = new CreateProfile();
		model.addAttribute("prof",createprofile);
		return "newprofile";
	}
	
	@RequestMapping(value="/saveprofiles",method=RequestMethod.POST)
	public String saveRegistration(@Valid CreateProfile createprofile,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "newprofile";
		}
	
		CPS.save(createprofile);
		
		return "redirect:/viewprofiles";
	}
	
	
	@RequestMapping(value="/viewprofiles")
	public ModelAndView getAll() {
		
		List<CreateProfile> list=CPS.findAll();
		return new ModelAndView("viewprofile","list",list);
	}
	
	/*
	@RequestMapping(value="/editprofile/{id}")
	public String edit (@PathVariable int id,ModelMap model) {
		
		CreateProfile createprofile=CPS.findOne(id);
		model.addAttribute("prof",createprofile);
		return "editprofile";
	}
	*/
	
	////////////ngorireee
	/*
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("prof") CreateProfile p) {
		
		CreateProfile createprofile=CPS.findOne(p.getId());
		
		createprofile.setFirstName(p.getFirstName());
		createprofile.setLastName(p.getLastName());
		createprofile.setCountry(p.getCountry());
		createprofile.setEmail(p.getEmail());
		createprofile.setSection(p.getSection());
		createprofile.setSex(p.getSex());
		
		CPS.save(createprofile);
		return new ModelAndView("redirect:/viewjobos");
	}
	
	
	*/
	/*
	
	@RequestMapping(value="/deleteprofile/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		CreateProfile createprofile=CPS.findOne(id);
		CPS.delete(createprofile);
		return new ModelAndView("redirect:/viewjobos");
	}
	
	

	@ModelAttribute("sections")
	public List<String> intializeSections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Reasearch");
		return sections;
	}
	/*
	
	/*
	 * Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 *//*
	@ModelAttribute("countries")
	public List<String> initializeCountries() {

		List<String> countries = new ArrayList<String>();
		countries.add("INDIA");
		countries.add("USA");
		countries.add("CANADA");
		countries.add("FRANCE");
		countries.add("GERMANY");
		countries.add("ITALY");
		countries.add("OTHER");
		return countries;
	}

	
	*/
	

}
