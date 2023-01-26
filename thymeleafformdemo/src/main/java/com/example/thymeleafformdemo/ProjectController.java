package com.example.thymeleafformdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// sourced from from:
//
// https://attacomsian.com/blog/spring-boot-thymeleaf-form-handling
//

@Controller
public class ProjectController {
    @Autowired
    EphemeralPeristanceStore peristanceStore;

    @GetMapping("/create-project")
    public String createProjectForm(Model model, @CookieValue("session") String sessionCookie, @CookieValue("user") String userCookie) {
        if(CookieUtil.validateSession(peristanceStore, userCookie, sessionCookie)) {
            model.addAttribute("project", new Project());

            return "create-project";
        } else {
            return "error";
        }
    }

    @PostMapping("/save-project")
    public String saveProjectSubmission(@ModelAttribute Project project) {

        // TODO: save project in DB here

        return "result";
    }
}