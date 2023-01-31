package com.dovahkir.foodapp.foodItem;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String foodItemName;

    @Column(name = "CreatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime creationTime;
    @Column(name = "ExpiryTime", nullable = true, columnDefinition = "TIMESTAMP")

    private LocalDateTime expiryTime;
    public FoodItem() {
    }


}
