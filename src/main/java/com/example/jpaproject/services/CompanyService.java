package com.example.jpaproject.services;

import com.example.jpaproject.entities.Company;
import com.example.jpaproject.entities.Coupon;
import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.repository.CompanyRepository;
import com.example.jpaproject.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService extends Login{
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CouponRepository couponRepository;

    @Override
    public String login(Credentional credentional) {
        Company company = companyRepository.getByCredentionalEmail(credentional.getEmail());
        if(company!=null && company.getCredentional().getPassword().equals(credentional.getPassword()))
            return "exists";
        else
            return "null";
    }
    public List<Company> getAllCompany(){
        return (List<Company>)companyRepository.findAll();
    }
    public Company getCompanyById(long id){
        return companyRepository.findById(id).get();
    }
    public Company createCompany(Company company){
        Company existsCompany = companyRepository.getByCredentionalEmail(company.getCredentional().getEmail());
        if(existsCompany!=null){
            System.out.printf("exists");
            return null;
        } else {
            existsCompany = companyRepository.getByCredentionalPassword(company.getCredentional().getPassword());
            if (existsCompany != null) {
                System.out.printf("exists");
                return null;
            }
        }
        return companyRepository.save(company);
    }
    public Company updataCompany(long id ,Company company){
        Company getcompany = getCompanyById(id);
        if(company.getCredentional()!=null)
            getcompany.setCredentional(company.getCredentional());
        if(company.getName()!=null)
            getcompany.setName(company.getName());
        companyRepository.save(getcompany);
        return companyRepository.findById(id).get();
    }
    public void deleteCompany(long id){
        companyRepository.deleteById(id);
    }
    public void addCouponToCompanyById(Coupon coupon, long id){
        Company company1 = getCompanyById(id);
        if(!company1.getCoupons().stream().anyMatch(c -> c.getTitle().equals(coupon.getTitle())))
        {
            couponRepository.save(coupon);
            Company company = getCompanyById(id);
            company.getCoupons().add(coupon);
            companyRepository.save(company);
        }else{
            System.out.println("title exists");
        }
    }

//signal coupon
    public void deleteCouponFromCompany(long idcoupon , long idcompany){
    }

    public void deleteCouponsByIdCompany(long id){
        Company company = getCompanyById(id);
        company.getCoupons().remove(company.getCoupons());
    }
}