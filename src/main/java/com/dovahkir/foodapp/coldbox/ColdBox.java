package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.beans.Freezer;
import com.dovahkir.foodapp.beans.Fridge;
import com.dovahkir.foodapp.foodItem.FoodItem;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "cold_box")
public class ColdBox {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long coldBoxID;
    //private User user;
    @Column
    @Embedded
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> fridgeContent;
    @Column
    @Embedded
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> freezerContent;

    public ColdBox(Long coldBoxID, List<FoodItem> fridgeContent, List<FoodItem> freezerContent) {
        this.coldBoxID = coldBoxID;
        this.fridgeContent = fridgeContent;
        this.freezerContent = freezerContent;
    }

    public Long getColdBoxID() {
        return coldBoxID;
    }

    public void setColdBoxID(Long coldBoxID) {
        this.coldBoxID = coldBoxID;
    }

    public List<FoodItem> getFridgeContent() {
        return fridgeContent;
    }

    public void setFridgeContent(List<FoodItem> fridgeContent) {
        this.fridgeContent = fridgeContent;
    }

    public List<FoodItem> getFreezerContent() {
        return freezerContent;
    }

    public void setFreezerContent(List<FoodItem> freezerContent) {
        this.freezerContent = freezerContent;
    }
}
