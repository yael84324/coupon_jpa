package com.example.jpaproject.controllers;

import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.entities.Customer;
import com.example.jpaproject.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerController  {
    @Autowired
    private CustomerService service;

    @GetMapping("/login")
    public String login(@RequestBody Credentional credentional){
        return service.login(credentional);
    }

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable long id){
        return service.getCustomerById(id);
    }

    @PostMapping("/{idCoupon}/{idCustomer}")
    public void addCouponToCustomerById(@PathVariable long idCoupon,
                                            @PathVariable long idCustomer){
         service.addCouponToCustomerById(idCoupon, idCustomer);
    }

    @PutMapping("/{id}")
    public Customer updataCustomer(@PathVariable long id,@RequestBody Customer customer){
        return service.updateCustomer(id,customer);
    }

    @DeleteMapping("/{idcoupon}/{idcustomer}")
    public  void deleteCouponFromCustomerById(@PathVariable long idcoupon,
                                              @PathVariable long idcustomer){
        service.deleteCouponFromCustomerById(idcoupon, idcustomer);
    }

    @DeleteMapping("/coupons/{id}")
    public  void deleteCouponsById(@PathVariable long id){
        service.deleteCouponsByIdCustomer(id);
    }
}

