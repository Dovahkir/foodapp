package com.dovahkir.foodapp.foodItem;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class FoodItemDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long FoodItemDateId;
    private LocalDateTime addedTime;
    private LocalDateTime expiryTime;
    @OneToOne(mappedBy = "foodItemDate")
    private FoodItem foodItem;

    public FoodItemDate() {
    }
    public FoodItemDate(Long foodItemDateId, LocalDateTime addedTime, LocalDateTime expiryTime, FoodItem foodItem) {
        FoodItemDateId = foodItemDateId;
        this.addedTime = addedTime;
        this.expiryTime = expiryTime;
        this.foodItem = foodItem;
    }

    public Long getFoodItemDateId() {²
        return FoodItemDateId;
    }

    public void setFoodItemDateId(Long foodItemDateId) {
        FoodItemDateId = foodItemDateId;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
