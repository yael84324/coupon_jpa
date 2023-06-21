package com.example.jpaproject.services;

import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.repository.CompanyRepository;
import com.example.jpaproject.repository.CouponRepository;
import com.example.jpaproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService  extends Login {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public String login(Credentional credentional) {
        if(credentional.getPassword().equals("admin") && credentional.getEmail().equals("admin@gmail.com"))
        {
            System.out.println(credentional);
            return "you are admin";
        }
        else
            return "you are not admin";
    }

}
