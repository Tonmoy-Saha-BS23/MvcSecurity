package com.bs23.MvcSecuriyt.MvcSecurity.controller;

import com.bs23.MvcSecuriyt.MvcSecurity.entity.Customer;
import com.bs23.MvcSecuriyt.MvcSecurity.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomer")
    public String showAllCustomer(Model theModel){
        List<Customer> customers = customerService.getAllCustomers();
        theModel.addAttribute("theData", customers);
        return "customerTable";
    }

    @GetMapping("/customer-creation")
    public String showCustomerCreationForm(Model theModel){
        Customer customer=new Customer();
        theModel.addAttribute("theStudent", customer);
        return "customer-creation";
    }

    @PostMapping("/save")
    public String savCustomer(@ModelAttribute("theStudent") Customer theCustomer){
        customerService.create(theCustomer);
        return "redirect:/customer/allCustomer";
    }
}
