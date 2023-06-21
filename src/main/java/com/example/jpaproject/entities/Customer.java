package com.example.jpaproject.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )  // שהמפתח הראשי ייווצר מעצמו
    private long id;
    private String firstName;
    private String lastName;
    @Embedded
    private Credentional credentional;
    @OneToMany
    private List<Coupon> coupons;

    public Customer() {
    }

    public Customer(long id, String firstName, String lastName, Credentional credentional,
                     List<Coupon> coupons) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.credentional = credentional;
        this.coupons = coupons;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Credentional getCredentional() {
        return credentional;
    }

    public void setCredentional(Credentional credentional) {
        this.credentional = credentional;
    }

    public List<Coupon> getCoupons() {
        return coupons;
    }

    public void setCoupons(List<Coupon> coupons) {
        this.coupons = coupons;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", credentional=" + credentional +
                ", coupons : \n" + coupons.toString() +
                '}';
    }
}

