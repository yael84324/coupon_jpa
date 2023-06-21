package com.example.jpaproject.services;

import com.example.jpaproject.entities.Company;
import com.example.jpaproject.entities.Coupon;
import com.example.jpaproject.entities.Credentional;
import com.example.jpaproject.entities.Customer;
import com.example.jpaproject.repository.CouponRepository;
import com.example.jpaproject.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService extends Login{
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;


    @Override
    public String login(Credentional credentional) {
        Customer customer = customerRepository.getByCredentionalEmail(credentional.getEmail());
        if(customer!=null && customer.getCredentional().getPassword().equals(credentional.getPassword()))
            return "exists";
        else
            return "null";
    }
    public List<Customer> getAllCustomer(){
        return (List<Customer>)customerRepository.findAll();
    }
    public Customer getCustomerById(long id){
        Customer cust=customerRepository.findById(id).orElse(null);//.get() // optional לחלץ לקוח מתוך מעטפת
        return cust;
    }
    public Customer createCustomer(Customer customer){

        Customer existsCustomer = customerRepository.getByCredentionalEmail(customer.getCredentional().getEmail());
        if(existsCustomer!=null){
            System.out.printf("exists");
            return null;
        } else {
            existsCustomer = customerRepository.getByCredentionalPassword(customer.getCredentional().getPassword());
            if (existsCustomer != null) {
                System.out.printf("exists");
                return null;
            }
        }
        return customerRepository.save(customer);
    }
    public Customer updateCustomer(long id,Customer customer){
        Customer getcustomer = getCustomerById(id);
        if(customer.getCredentional()!=null)
            getcustomer.setCredentional(customer.getCredentional());
        if(customer.getFirstName()!=null)
            getcustomer.setFirstName(customer.getFirstName());
        if(customer.getLastName()!=null)
            getcustomer.setLastName(customer.getLastName());
        customerRepository.save(getcustomer);
        return customerRepository.findById(id).get();
    }

    public void deleteCustomer(long id){
        customerRepository.deleteById(id);
    }
    public void addCouponToCustomerById(long idCoupon, long idCustomer){
        //בהנחה שהלקוח קיים כבר
        Customer customer = getCustomerById(idCustomer);
        Coupon coupon = couponRepository.getById(idCoupon);
        if(coupon==null)
            return;
        if(coupon.getEmount()<1)
            return;
        if(customer.getCoupons().stream().anyMatch(c -> c.getTitle().equals(coupon.getTitle())))
           return;
        coupon.setEmount(coupon.getEmount()-1);
        customer.getCoupons().add(coupon);
        customerRepository.save(customer);
    }

    public void deleteCouponFromCustomerById(long idcoupon, long idcustomer)
    {
        Customer customer = getCustomerById(idcustomer);
        Coupon coupon = couponRepository.getById(idcoupon);
        if(coupon!=null) {
            customer.setCoupons(customer.getCoupons().stream()
                    .filter(c -> c.getId() != idcoupon)
                    .collect(Collectors.toList()));
            customerRepository.save(customer);
        }else System.out.println("coupon not exists");
    }

    public void deleteCouponsByIdCustomer(long id){
        Customer customer = getCustomerById(id);
        customer.getCoupons().remove(customer.getCoupons());
    }
}
