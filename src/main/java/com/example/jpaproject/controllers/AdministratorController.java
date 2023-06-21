package com.example.jpaproject.controllers;

import com.example.jpaproject.entities.Company;
import com.example.jpaproject.entities.Coupon;
import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.entities.Customer;
import com.example.jpaproject.services.AdministratorService;
import com.example.jpaproject.services.CompanyService;
import com.example.jpaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrator")
public class AdministratorController{
    @Autowired
    AdministratorService Adminservice;
    @Autowired
    CustomerService customerService;
    @Autowired
    CompanyService companyService;


    @GetMapping("/login")
    public String login(@RequestBody Credentional credentional){
        return Adminservice.login(credentional);
    }

    @GetMapping("/company")
    public List<Company> getAllCompany(){
        return companyService.getAllCompany();
    }

    @GetMapping("/company/{id}")
    public Company getCompanyById(@PathVariable long id){
        return companyService.getCompanyById(id);
    }

    @PostMapping("/company")
    public Company createCompany(@RequestBody Company company){
        return companyService.createCompany(company);
    }

    @PostMapping("/company/{id}")
    public void addCouponToCompany(@RequestBody Coupon coupon, @PathVariable long id){
        companyService.addCouponToCompanyById(coupon,id);
    }

    @PutMapping("/company/{id}")
    public Company updataCompany(@PathVariable long id,@RequestBody Company company){
        return companyService.updataCompany(id,company);
    }

    @DeleteMapping("/company/{id}")
    public void deleteCompany(@PathVariable long id){
        companyService.deleteCompany(id);
    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomer(){
        return customerService.getAllCustomer();
    }

    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return customerService.getCustomerById(id);
    }

    @PostMapping("/customer")
    public Customer createCustomer(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }

    @PostMapping("/customer/{idCoupon}/{idCustomer}")
    public void addCouponToCustomerById(@PathVariable long idCoupon,
                                        @PathVariable long idCustomer){
        customerService.addCouponToCustomerById(idCoupon, idCustomer);
    }

    @PutMapping("/customer/{id}")
    public Customer updataCustomer(@PathVariable long id,@RequestBody Customer customer){
        return customerService.updateCustomer(id,customer);
    }

    @DeleteMapping("/customer/{id}")
    public void deleteCustomer(@PathVariable long id){
        customerService.deleteCustomer(id);
    }
}
