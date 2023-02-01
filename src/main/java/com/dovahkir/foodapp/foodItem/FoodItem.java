package com.dovahkir.foodapp.foodItem;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long foodItemId;

    @Column(name = "name", nullable = false)
    private String foodItemName;

    @Column(name = "CreatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime creationTime;

    @Column(name = "ExpiryTime", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDateTime expiryTime;

    public FoodItem() {
    }

    public FoodItem(Long foodItemId, String foodItemName, LocalDateTime creationTime, LocalDateTime expiryTime) {
        this.foodItemId = foodItemId;
        this.foodItemName = foodItemName;
        this.creationTime = creationTime;
        this.expiryTime = expiryTime;
    }

    public Long getFoodItemId() {
        return foodItemId;
    }

    public void setFoodItemId(Long foodItemId) {
        this.foodItemId = foodItemId;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
