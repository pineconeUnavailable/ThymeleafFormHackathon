package com.example.thymeleafformdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping()
public class RegistrationController {

    @Autowired
    EphemeralPeristanceStore peristanceStore;

    @GetMapping("/register")
    public String registrationForm(Model model) {
        model.addAttribute("mylogin", new LoginPOJO());
        return "register";
    }

    @PostMapping("/save-register")
    public String saveRegistrationSubmission(Model model, LoginPOJO mylogin, HttpServletResponse resp) {
        System.out.println(">>>>>> saveRegistrationSubmission");
        System.out.println(">>>>>> uname="+mylogin.getUname());
        System.out.println(">>>>>> pass ="+mylogin.getPassword());
        // TODO:
        model.addAttribute("mylogin", mylogin);
        if(peristanceStore.store(mylogin)) {
            CookieUtil.setupSession(peristanceStore, mylogin.getUname(), resp);
            return "login-result";
        } else {
            return "index";
        }
    }

}
