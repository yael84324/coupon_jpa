package com.example.jpaproject.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "coupons")
public class Coupon {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO )  // שהמפתח הראשי ייווצר מעצמו
    private long id;

    private int companyID;
    @Enumerated(EnumType.STRING)  // לשמור את הערך של enum בצורה של מחרוזת
    private Category category;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private int emount;
    private double price;
    private String image;

    public Coupon() {
    }

    public Coupon(long id, int companyID, Category category, String title, String description,
                  LocalDate startDate, LocalDate endDate, int emount, double price, String image) {
        this.id = id;
        this.companyID = companyID;
        this.category = category;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.emount = emount;
        this.price = price;
        this.image = image;
    }

    public long getId() {
        return id;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getEmount() {
        return emount;
    }

    public void setEmount(int emount) {
        this.emount = emount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "id=" + id +
                ", companyID=" + companyID +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", emount=" + emount +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
