package com.bs23.MvcSecuriyt.MvcSecurity.controller;

import com.bs23.MvcSecuriyt.MvcSecurity.entity.Customer;
import com.bs23.MvcSecuriyt.MvcSecurity.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/")
    public String homePage(){
        return "home";
    }
    @GetMapping("/showLoginPage")
    public String loginPage(){
        return "login-form";
    }

    @GetMapping("/leaders")
    public String ShowLeaders(){
        return "leaders";
    }

    @GetMapping("/admin")
    public String ShowAdmin(){
        return "admin";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "access-denied";
    }
}
