package com.example.jpaproject.entities;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "companys")
public class Company {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )  // שהמפתח הראשי ייווצר מעצמו
    private long id;
    private String name;
    @Embedded
    private Credentional credentional;
    @OneToMany
    private List<Coupon> coupons;

    public Company() {
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Company(long id, String name, Credentional credentional) {
        this.id = id;
        this.name = name;
        this.credentional = credentional;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credentional=" + credentional +
                ", coupons : \n" + coupons.toString() +
                '}';
    }
}
