package com.dovahkir.foodapp.beans;

import com.dovahkir.foodapp.foodItem.FoodItem;
import jakarta.persistence.*;

import java.util.List;

@Embeddable
public class Freezer {

    private Long freezerId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FoodItem> freezerContent;

    public Freezer(Long freezerId, List<FoodItem> freezerContent) {
        this.freezerId = freezerId;
        this.freezerContent = freezerContent;
    }

    public Long getFreezerId() {
        return freezerId;
    }

    public void setFreezerId(Long freezerId) {
        this.freezerId = freezerId;
    }

    public List<FoodItem> getFreezerContent() {
        return freezerContent;
    }

    public void setFreezerContent(List<FoodItem> freezerContent) {
        this.freezerContent = freezerContent;
    }
}
