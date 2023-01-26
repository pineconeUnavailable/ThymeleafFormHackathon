package com.example.thymeleafformdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SimpleController {
	@Autowired
	EphemeralPeristanceStore peristanceStore;

	@GetMapping("/login")
	public String loginForm(Model model) {


		model.addAttribute("mylogin", new LoginPOJO());
		return "create-login";
	}

	@PostMapping("/save-login")
	public String saveLoginSubmission(Model model, LoginPOJO mylogin, HttpServletResponse resp) {
		System.out.println(">>>>>> IN saveLoginSubmission");
		System.out.println(">>>>>> uname="+mylogin.getUname());
		System.out.println(">>>>>> pass ="+mylogin.getPassword());
		// TODO:
		LoginPOJO login = peristanceStore.get(mylogin.getUname());
		model.addAttribute("mylogin", mylogin);

		if(login != null && login.getPassword().equals(mylogin.getPassword())) {
			model.addAttribute("error", null);
			CookieUtil.setupSession(peristanceStore, mylogin.getUname(), resp);
			return "login-result";
		} else {
			model.addAttribute("error", "incorrect username or password");
			return "index";
		}
	}

}
