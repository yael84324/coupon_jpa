package com.example.jpaproject.repository;

import com.example.jpaproject.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepository extends JpaRepository<Coupon,Long> {
     Coupon getById(long idCoupon);
}
