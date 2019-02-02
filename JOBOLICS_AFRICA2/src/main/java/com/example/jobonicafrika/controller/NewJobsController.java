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

import com.example.jobonicafrika.model.NewJobs;
import com.example.jobonicafrika.service.NewJobsService;



@Controller

public class NewJobsController {
	
	@Autowired
	private NewJobsService NJS;
	
	@RequestMapping(value="/jobos",method=RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		NewJobs newJobs = new NewJobs();
		model.addAttribute("janta",newJobs);
		return "jobos";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveRegistration(@Valid NewJobs newJobs,BindingResult result,ModelMap model,RedirectAttributes redirectAttributes) {
		
		if(result.hasErrors()) {
			System.out.println("has errors");
			return "jobos";
		}
	
		NJS.save(newJobs);
		
		return "redirect:/viewjobos";
	}
	
	
	@RequestMapping(value="/viewjobos")
	public ModelAndView getAll() {
		
		List<NewJobs> list=NJS.findAll();
		return new ModelAndView("viewjobos","list",list);
	}
	
	/*
	@RequestMapping(value="/editstudent/{id}")
	public String edit (@PathVariable int id,ModelMap model) {
		
		NewJobs newJobs=NJS.findOne(id);
		model.addAttribute("janta",newJobs);
		return "editstudent";
	}
	
	*/
	////////////ngorireee
	/*
	@RequestMapping(value="/editsave",method=RequestMethod.POST)
	public ModelAndView editsave(@ModelAttribute("janta") NewJobs p) {
		
		NewJobs newJobs=NJS.findOne(p.getId());
		
		newJobs.setFirstName(p.getFirstName());
		newJobs.setLastName(p.getLastName());
		newJobs.setCountry(p.getCountry());
		newJobs.setEmail(p.getEmail());
		newJobs.setSection(p.getSection());
		newJobs.setSex(p.getSex());
		
		NJS.save(newJobs);
		return new ModelAndView("redirect:/viewjobos");
	}
	
	
	*//*
	
	@RequestMapping(value="/deletestudent/{id}",method=RequestMethod.GET)
	public ModelAndView delete(@PathVariable int id) {
		NewJobs newJobs=NJS.findOne(id);
		NJS.delete(newJobs);
		return new ModelAndView("redirect:/viewjobos");
	}
	
	*/
/*
	@ModelAttribute("sections")
	public List<String> intializeSections(){
		List<String> sections = new ArrayList<String>();
		sections.add("Graduate");
		sections.add("Post Graduate");
		sections.add("Reasearch");
		return sections;
	}
	*/
	
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
