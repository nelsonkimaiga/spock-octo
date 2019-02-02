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

import com.example.jobonicafrika.model.CompanyAccount;
import com.example.jobonicafrika.service.CompanyAccountService;
import com.example.jobonicafrika.service.CompanyProfileDetailsService;
import com.example.jobonicafrika.service.CreateProfileService;

@Controller

public class CompanyAccountController {

	@Autowired
	private CompanyAccountService CAS;

	@RequestMapping(value = "/kompanyaccount", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		CompanyAccount createprofile = new CompanyAccount();
		model.addAttribute("kompanyacc", createprofile);
		return "kampunaccount";
	}

	@RequestMapping(value = "/savekompanyaccount", method = RequestMethod.POST)
	public String saveRegistration(@Valid CompanyAccount createprofile, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
			System.out.println("has errors");
			return "kampunaccount";
		}

		CAS.save(createprofile);

		return "redirect:/viewkompanyaccount";
	}

	@RequestMapping(value = "/viewkompanyaccount")
	public ModelAndView getAll() {

		List<CompanyAccount> list = CAS.findAll();
		return new ModelAndView("viewkompanyaccount", "list", list);
	}

	/*
	 * @RequestMapping(value="/editprofile/{id}") public String edit (@PathVariable
	 * int id,ModelMap model) {
	 * 
	 * CompanyAccount createprofile=CAS.findOne(id);
	 * model.addAttribute("kompanyacc",createprofile); return "editprofile"; }
	 */

	//////////// ngorireee
	/*
	 * @RequestMapping(value="/editsave",method=RequestMethod.POST) public
	 * ModelAndView editsave(@ModelAttribute("kompanyacc") CompanyAccount p)
	 * {
	 * 
	 * CompanyAccount createprofile=CAS.findOne(p.getId());
	 * 
	 * createprofile.setFirstName(p.getFirstName());
	 * createprofile.setLastName(p.getLastName());
	 * createprofile.setCountry(p.getCountry());
	 * createprofile.setEmail(p.getEmail());
	 * createprofile.setSection(p.getSection()); createprofile.setSex(p.getSex());
	 * 
	 * CAS.save(createprofile); return new ModelAndView("redirect:/viewjobos"); }
	 * 
	 * 
	 */
	/*
	 * 
	 * @RequestMapping(value="/deleteprofile/{id}",method=RequestMethod.GET) public
	 * ModelAndView delete(@PathVariable int id) { CompanyAccount
	 * createprofile=CAS.findOne(id); CAS.delete(createprofile); return new
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
