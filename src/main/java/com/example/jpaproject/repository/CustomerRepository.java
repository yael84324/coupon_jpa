package com.example.jpaproject.repository;

import com.example.jpaproject.entities.Company;
import com.example.jpaproject.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getByCredentionalEmail(String email);
    Customer getByCredentionalPassword(String password);

}
