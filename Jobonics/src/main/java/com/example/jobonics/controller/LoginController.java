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

import com.example.jobonics.model.User2;
import com.example.jobonics.service.User2Service;



@Controller
public class LoginController {

    // @Autowired
    // private User2Service userService;

    // @RequestMapping(value={"/login2"}, method = RequestMethod.GET)
    // public ModelAndView login2(){
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("login2");
    //     return modelAndView;
    // }

    // @RequestMapping(value="/registration", method = RequestMethod.GET)
    // public ModelAndView registration(){
    //     ModelAndView modelAndView = new ModelAndView();
    //     User2 user2 = new User2();
    //     modelAndView.addObject("user2", user2);
    //     modelAndView.setViewName("registration");
    //     return modelAndView;
    // }
    

    // @RequestMapping(value = "/registration", method = RequestMethod.POST)
    // public ModelAndView createNewUser(@Valid User2 user2, BindingResult bindingResult) {
    //     ModelAndView modelAndView = new ModelAndView();
    //     User2 userExists = userService.findUserByEmail(user2.getEmail());
    //     if (userExists != null) {
    //         bindingResult
    //                 .rejectValue("email", "error.user2",
    //                         "There is already a user2 registered with the email provided");
    //     }
    //     if (bindingResult.hasErrors()) {
    //         modelAndView.setViewName("registration");
    //     } else {
    //         userService.saveUser(user2);
    //         modelAndView.addObject("successMessage", "User2 has been registered successfully");
    //         modelAndView.addObject("user2", new User2());
    //         modelAndView.setViewName("registration");

    //     }
    //     return modelAndView;
    // }
    


    // @RequestMapping(value="/home", method = RequestMethod.GET)
    // public ModelAndView home(){
    //     ModelAndView modelAndView = new ModelAndView();
    //     Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    //     User2 user2 = userService.findUserByEmail(auth.getName());
    //     modelAndView.addObject("userName", "Welcome " + user2.getName() + " " + user2.getLastName() + " (" + user2.getEmail() + ")");
    //     modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
    //     modelAndView.setViewName("home");
    //     return modelAndView;
    // }
////////////////////////////////////////////////////////////////////////////job creation object
    //

}
