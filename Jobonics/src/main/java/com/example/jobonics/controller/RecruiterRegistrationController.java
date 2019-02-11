package com.example.jobonics.controller;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.jobonics.model.UserRecruiter;
import com.example.jobonics.service.UserRecruiterService;
import com.example.jobonics.Dto.UserDto;
import com.example.jobonics.captcha.ICaptchaService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class RecruiterRegistrationController{
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRecruiterService userRecruiterService;

    @Autowired
    private ICaptchaService captchaService;

    @RequestMapping(value = "/signup_employer", method = RequestMethod.GET)
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView();
        UserDto user = new UserDto();
        modelAndView.addObject("userDto", user);
        modelAndView.setViewName("recruiter_signup");
        return modelAndView;
    }


    @RequestMapping(value = "/signup_employer", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid final UserDto accountDto, BindingResult bindingResult, final HttpServletRequest request) {

        final String response = request.getParameter("g-recaptcha-response");
        ModelAndView modelAndView = new ModelAndView();
        System.out.println(accountDto.toString());
        try {
            captchaService.processResponse(response);
        } catch (NullPointerException e) {
            modelAndView.setViewName("recruiter_signup");
        }


        UserRecruiter userExists = userRecruiterService.findUserByEmail(accountDto.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("recruiter_signup");
        } else {
            userRecruiterService.createUserAccount(accountDto);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new UserRecruiter());
            modelAndView.setViewName("successRegister");
            LOGGER.debug("Registering user account with information: {}", accountDto);
        }
        return modelAndView;
    }
}

