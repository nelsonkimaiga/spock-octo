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

import com.example.jobonics.model.CompanyProfileDetails;
import com.example.jobonics.service.CompanyProfileDetailsService;
import com.example.jobonics.service.CreateProfileService;

@Controller

public class CompanyProfileDetailsController {

	@Autowired
	private CompanyProfileDetailsService CPDS;

	@RequestMapping(value = "/kompanyprofile", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CompanyProfileDetails createprofile = new CompanyProfileDetails();
		model.addAttribute("kompanyprof", createprofile);
		return "kampun";
	}

	@RequestMapping(value = "/savekompanyprofiles", method = RequestMethod.POST)
	public String saveRegistration(@Valid CompanyProfileDetails createprofile, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "kampun";
		}

		CPDS.save(createprofile);

		return "redirect:/viewkompanyprofiles";
	}

	@RequestMapping(value = "/viewkompanyprofiles")
	public ModelAndView getAll() {

		List<CompanyProfileDetails> list = CPDS.findAll();
		return new ModelAndView("viewkompanyprofiles", "list", list);
	}

	/*
	 * @RequestMapping(value="/editprofile/{id}") public String edit (@PathVariable
	 * int id,ModelMap model) {
	 * 
	 * CompanyProfileDetails createprofile=CPDS.findOne(id);
	 * model.addAttribute("kompanyprof",createprofile); return "editprofile"; }
	 */

	//////////// ngorireee
	/*
	 * @RequestMapping(value="/editsave",method=RequestMethod.POST) public
	 * ModelAndView editsave(@ModelAttribute("kompanyprof") CompanyProfileDetails p)
	 * {
	 * 
	 * CompanyProfileDetails createprofile=CPDS.findOne(p.getId());
	 * 
	 * createprofile.setFirstName(p.getFirstName());
	 * createprofile.setLastName(p.getLastName());
	 * createprofile.setCountry(p.getCountry());
	 * createprofile.setEmail(p.getEmail());
	 * createprofile.setSection(p.getSection()); createprofile.setSex(p.getSex());
	 * 
	 * CPDS.save(createprofile); return new ModelAndView("redirect:/viewjobos"); }
	 * 
	 * 
	 */
	/*
	 * 
	 * @RequestMapping(value="/deleteprofile/{id}",method=RequestMethod.GET) public
	 * ModelAndView delete(@PathVariable int id) { CompanyProfileDetails
	 * createprofile=CPDS.findOne(id); CPDS.delete(createprofile); return new
	 * ModelAndView("redirect:/viewjobos"); }
	 * 
	 * 
	 * 
	 * @ModelAttribute("sections") public List<String> intializeSections(){
	 * List<String> sections = new ArrayList<String>(); sections.add("Graduate");
	 * sections.add("Post Graduate"); sections.add("Reasearch"); return sections; }
	 * /*
	 * 
	 * /* Method used to populate the country list in view. Note that here you can
	 * call external systems to provide real data.
	 *//*
		 * @ModelAttribute("countries") public List<String> initializeCountries() {
		 * 
		 * List<String> countries = new ArrayList<String>(); countries.add("INDIA");
		 * countries.add("USA"); countries.add("CANADA"); countries.add("FRANCE");
		 * countries.add("GERMANY"); countries.add("ITALY"); countries.add("OTHER");
		 * return countries; }
		 * 
		 * 
		 */

}
