package com.example.thymeleafformdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectTableController {
    @Autowired
    EphemeralPeristanceStore peristanceStore;

    @GetMapping("/project-table")
    public String createProjectForm(Model model, @CookieValue("session") String sessionCookie, @CookieValue("user") String userCookie) {
        if(CookieUtil.validateSession(peristanceStore, userCookie, sessionCookie)) { //auth check
            model.addAttribute("projects", peristanceStore.getProjects());
            return "project-table";
        } else {
            return "error";
        }
    }
}