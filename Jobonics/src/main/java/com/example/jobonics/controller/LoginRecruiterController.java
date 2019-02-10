package com.example.jobonics.controller;

import javax.validation.Valid;

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



@Controller
public class LoginRecruiterController {

    @Autowired
    private UserRecruiterService userService;

    @RequestMapping(value={"/login_recruiter"}, method = RequestMethod.GET)
    public ModelAndView loginrecruiter(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login_recruiter");
        return modelAndView;
    }

    @RequestMapping(value="/registration", method = RequestMethod.GET)
    public ModelAndView registration(){
        ModelAndView modelAndView = new ModelAndView();
        UserRecruiter userRecruiter = new UserRecruiter();
        modelAndView.addObject("user2", userRecruiter);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView createNewUser(@Valid UserRecruiter userRecruiter, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        UserRecruiter userExists = userService.findUserByEmail(userRecruiter.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user2",
                            "There is already a user2 registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("registration");
        } else {
            userService.saveUser(userRecruiter);
            modelAndView.addObject("successMessage", "User2 has been registered successfully");
            modelAndView.addObject("user2", new UserRecruiter());
            modelAndView.setViewName("login_recruiter");
        }
    
    @RequestMapping(value="/new_job", method = RequestMethod.GET)
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserRecruiter userRecruiter = userService.findUserByEmail(auth.getName());
        modelAndView.addObject("userName", "Welcome " + userRecruiter.getName() + " " + userRecruiter.getLastName() + " (" + userRecruiter.getEmail() + ")");
        modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
        modelAndView.setViewName("/new_job");
        return modelAndView;
    }
///////////////<span th:utext="${userName}"></span>
}
