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


    public FoodItem() {
    }

    public FoodItem(Long foodItemId, String foodItemName, LocalDateTime creationTime) {
        this.foodItemId = foodItemId;
        this.foodItemName = foodItemName;
        this.creationTime = creationTime;

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


}
