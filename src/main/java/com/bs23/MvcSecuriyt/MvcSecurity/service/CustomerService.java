package com.bs23.MvcSecuriyt.MvcSecurity.service;

import com.bs23.MvcSecuriyt.MvcSecurity.entity.Customer;
import com.bs23.MvcSecuriyt.MvcSecurity.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    public void create(Customer customer){
        customerRepository.save(customer);
    }
}
