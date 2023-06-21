package com.example.jpaproject.repository;


import com.example.jpaproject.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Company getByCredentionalEmail(String email);
    Company getByCredentionalPassword(String password);

}
