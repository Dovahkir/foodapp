package com.dovahkir.foodapp.beans;

import com.dovahkir.foodapp.foodItem.FoodItem;
import jakarta.persistence.*;

import java.util.List;

//@Entity
@Embeddable
public class Fridge {

    private Long fridgeId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> fridgeContent;

    public Fridge(Long fridgeId, List<FoodItem> fridgeContent) {
        this.fridgeId = fridgeId;
        this.fridgeContent = fridgeContent;
    }

    public Long getFridgeId() {
        return fridgeId;
    }

    public void setFridgeId(Long fridgeId) {
        this.fridgeId = fridgeId;
    }

    public List<FoodItem> getFridgeContent() {
        return fridgeContent;
    }

    public void setFridgeContent(List<FoodItem> fridgeContent) {
        this.fridgeContent = fridgeContent;
    }
}
