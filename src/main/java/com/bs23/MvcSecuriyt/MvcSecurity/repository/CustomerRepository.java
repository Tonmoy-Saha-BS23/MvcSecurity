package com.bs23.MvcSecuriyt.MvcSecurity.repository;

import com.bs23.MvcSecuriyt.MvcSecurity.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
