package com.example.jobonics.Web.Controller;

import com.example.jobonics.Persistence.model.User;
import com.example.jobonics.Service.UserService;
import com.example.jobonics.Web.dto.UserDto;
import com.example.jobonics.captcha.ICaptchaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
public class RegistrationController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

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


        User userExists = userService.findUserByEmail(accountDto.getEmail());
        if (userExists != null) {
            bindingResult
                    .rejectValue("email", "error.user",
                            "There is already a user registered with the email provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("recruiter_signup");
        } else {
            userService.createUserAccount(accountDto);
            modelAndView.addObject("successMessage", "User has been registered successfully");
            modelAndView.addObject("user", new User());
            modelAndView.setViewName("success");
            LOGGER.debug("Registering user account with information: {}", accountDto);
        }
        return modelAndView;
    }
}
