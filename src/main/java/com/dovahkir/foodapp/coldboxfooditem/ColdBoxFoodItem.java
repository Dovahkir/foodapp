package com.dovahkir.foodapp.coldboxfooditem;

import com.dovahkir.foodapp.coldbox.ColdBox;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table
public class ColdBoxFoodItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer nbReplica;

    @Column(name = "addedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime addedTime;
    @Column
    private LocalDateTime expiryDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "coldBoxId")
    private ColdBox coldBox;

    @ManyToOne
    @JoinColumn(name = "foodItemId")
    private FoodItem foodItem;

    public ColdBoxFoodItem() {
    }

    public ColdBoxFoodItem(ColdBox coldBox, FoodItem foodItem) {
        this();
        this.coldBox = coldBox;
        this.foodItem = foodItem;
    }

    public ColdBoxFoodItem(Long id, Integer nbReplica, LocalDateTime addedTime, LocalDateTime expiryDate, ColdBox coldBox, FoodItem foodItem) {
        this.id = id;
        this.nbReplica = nbReplica;
        this.addedTime = addedTime;
        this.expiryDate = expiryDate;
        this.coldBox = coldBox;
        this.foodItem = foodItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbReplica() {
        return nbReplica;
    }

    public void setNbReplica(Integer nbReplica) {
        this.nbReplica = nbReplica;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public ColdBox getColdBox() {
        return coldBox;
    }

    public void setColdBox(ColdBox coldBox) {
        this.coldBox = coldBox;
    }

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
