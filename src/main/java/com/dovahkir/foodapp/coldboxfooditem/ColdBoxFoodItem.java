package com.dovahkir.foodapp.coldboxfooditem;

import com.dovahkir.foodapp.coldbox.ColdBox;
import com.dovahkir.foodapp.foodItem.FoodItem;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class ColdBoxFoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nbReplica;
    @Column
    private LocalDateTime addedTime;
    @Column
    private LocalDateTime expiryDate;
    @ManyToOne
    @JoinColumn(name = "coldBoxId")
    private ColdBox coldBox;

    @ManyToOne
    @JoinColumn(name = "foodItemId")
    private FoodItem foodItem;

    public ColdBoxFoodItem() {
    }
}
