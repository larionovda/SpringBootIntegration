package com.larionov.epam.controller.rest;

import com.larionov.epam.service.rest.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("user")
public class AuthenticatedController {

    @Autowired
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView getLogin(@RequestParam(value = "error", required = false) String error,
                                 @RequestParam(value = "logout", required = false) String logout) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("error", error != null);
        modelAndView.addObject("logout", logout != null);
        return modelAndView;
    }

    @RequestMapping("/registration")
    public ModelAndView registration() {
        return new ModelAndView("registration");
    }

    @PostMapping("addUser")
    public ModelAndView addNewProduct(@RequestParam(value = "userName") String userName,
                                      @RequestParam(value = "password") String password) {
        userService.addNewUser(userName, "{noop}" + password);
        return new ModelAndView("redirect:/user/login");
    }


}
