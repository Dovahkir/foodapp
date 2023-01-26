package com.dovahkir.foodapp.foodItem;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.Date;
@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String foodItemName;

    @Column(name = "intakeDate", nullable = false)
    private ZonedDateTime intakeDate = ZonedDateTime.now();
    @DateTimeFormat/*(pattern = "dd-MM-yyyy")*/
    @Column(name = "expiryDate", nullable = false)
    private Date expiryDate;

    @Column(name = "remainingDays", nullable = true)
    private Duration remainingDays;

    public FoodItem() {
    }

    public FoodItem(Long id, String foodItemName, ZonedDateTime intakeDate, Date expiryDate, Duration remainingDays) {
        this.id = id;
        this.foodItemName = foodItemName;
        this.intakeDate = intakeDate;
        this.expiryDate = expiryDate;
        this.remainingDays = Duration.between(intakeDate, expiryDate.toInstant().atZone(intakeDate.getZone()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public ZonedDateTime getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(ZonedDateTime intakeDate) {
        this.intakeDate = intakeDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Duration getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Duration remainingDays) {
        this.remainingDays = remainingDays;
    }
}
