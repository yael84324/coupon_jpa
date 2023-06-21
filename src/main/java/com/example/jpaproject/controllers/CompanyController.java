package com.example.jpaproject.controllers;

import com.example.jpaproject.entities.Company;
import com.example.jpaproject.entities.Coupon;
import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService service ;


    @GetMapping("/login")
    public String login(@RequestBody Credentional credentional){
        return service.login(credentional);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable long id){
        return service.getCompanyById(id);
    }

    @PostMapping("/{id}")
    public void addCouponToCompany(@RequestBody Coupon coupon,@PathVariable long id){
         service.addCouponToCompanyById(coupon,id);
    }

    @PutMapping("/{id}")
    public Company updataCompany(@PathVariable long id,@RequestBody Company company){
        return service.updataCompany(id,company);
    }

    @DeleteMapping("/coupons/{id}")
    public  void deleteCouponsById(@PathVariable long id){
        service.deleteCouponsByIdCompany(id);
    }
    @DeleteMapping("/{idcoupon}/{idcustomer}")
    public  void deleteCouponFromCompanyById(@PathVariable long idcoupon,
                                              @PathVariable long idcustomer){
        service.deleteCouponFromCompany(idcoupon, idcustomer);
    }
}
