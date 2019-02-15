
package com.example.jobonics.Web.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.Persistence.model.NewJobs;
import com.example.jobonics.Persistence.model.User;
import com.example.jobonics.service.NewJobsService;
import com.example.jobonics.service.UserService;

@Controller

public class NewJobsController {
	 @Autowired
	    private UserService userService;
	@Autowired
	private NewJobsService NJS;
	/// this code controls creation of new jobs

	@RequestMapping(value = "/new_job", method = RequestMethod.GET)
	public String newRegistration(ModelMap model) {
		NewJobs newJobs = new NewJobs();
		model.addAttribute("newjobs", newJobs);
		return "new_job";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRegistration(@Valid NewJobs newJobs, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {

		if (result.hasErrors()) {
		 System.out.println("has errors");
			return "new_job";
		}

		NJS.save(newJobs);
		/// after new job creation....testing if the job appears in the job seekers UI

		return "redirect:/new_job";
	}

	@RequestMapping(value = "/openings")
	public ModelAndView getAll() {

		List<NewJobs> list = NJS.findAll();
		return new ModelAndView("openings", "list", list);
	}
	
	

}
