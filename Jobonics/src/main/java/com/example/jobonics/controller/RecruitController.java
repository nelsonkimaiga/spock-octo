package com.example.jobonics.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.jobonics.model.Recruiter;
import com.example.jobonics.service.EmailService;
import com.example.jobonics.service.RecruiterService;
import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

@Controller
public class RecruitController {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private RecruiterService recruiterService;
	private EmailService emailService;
	
	@Autowired
	public RecruitController(BCryptPasswordEncoder bCryptPasswordEncoder,
    RecruiterService recruiterService, EmailService emailService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.recruiterService = recruiterService;
		this.emailService = emailService;
	}
	
	// Return registration form template
	@RequestMapping(value="/signup_employer", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, Recruiter recruiter){
		modelAndView.addObject("recruiter", recruiter);
		modelAndView.setViewName("recruiter_signup");
		return modelAndView;
	}
	
	// Process form input data
	@RequestMapping(value = "/signup_employer", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid Recruiter recruiter, BindingResult bindingResult, HttpServletRequest request) {
				
		// Lookup user in database by e-mail
		Recruiter userExists = recruiterService.findByEmail(recruiter.getEmail());
		
		System.out.println(userExists);
		
		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a recruiter registered with the email provided.");
			modelAndView.setViewName("recruiter_signup");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("recruiter_signup");		
		} else { // new user so we create user and send confirmation e-mail
					
			// Disable user until they click on confirmation link in email
		    recruiter.setEnabled(false);
		      
		    // Generate random 36-character string token for confirmation link
		    recruiter.setConfirmationToken(UUID.randomUUID().toString());
		        
		    recruiterService.saveRecruiter(recruiter);
				
			String appUrl = request.getScheme() + "://" + request.getServerName();
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(recruiter.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm_recruiter?token=" + recruiter.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");
			
			emailService.sendEmail(registrationEmail);
			
			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + recruiter.getEmail());
			modelAndView.setViewName("recruiter_signup");
		}
			
		return modelAndView;
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm_recruiter", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {
			
		Recruiter recruiter = recruiterService.findByConfirmationToken(token);
			
		if (recruiter == null) { // No token found in DB
			modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
		} else { // Token found
			modelAndView.addObject("confirmationToken", recruiter.getConfirmationToken());
		}
			
		modelAndView.setViewName("confirm_recruiter");
		return modelAndView;		
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm_recruiter", method = RequestMethod.POST)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
				
		modelAndView.setViewName("confirm_recruiter");
		
		Zxcvbn passwordCheck = new Zxcvbn();
		
		Strength strength = passwordCheck.measure(requestParams.get("password"));
		
		if (strength.getScore() < 3) {
			//modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
			bindingResult.reject("password");
			
			redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

			modelAndView.setViewName("redirect:confirm_recruiter?token=" + requestParams.get("token"));
			System.out.println(requestParams.get("token"));
			return modelAndView;
		}
	
		// Find the user associated with the reset token
		Recruiter recruiter = recruiterService.findByConfirmationToken(requestParams.get("token"));

		// Set new password
		recruiter.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

		// Set user to enabled
		recruiter.setEnabled(true);
		
		// Save user
		recruiterService.saveRecruiter(recruiter);
		
		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;
			
	}
	
}
