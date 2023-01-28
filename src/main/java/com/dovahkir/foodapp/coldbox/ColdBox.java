package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.foodItem.FoodItem;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "coldbox")
public class ColdBox {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long coldBoxId;
    @Column
    private String coldBoxName;

    //private User user;

    //@OneToMany(mappedBy = "coldBox",cascade = CascadeType.ALL, orphanRemoval = true)
    @ManyToMany
    @JoinTable(name = "coldBox_foodItem", joinColumns = @JoinColumn(name = "coldBox_id"), inverseJoinColumns = @JoinColumn(name = "foodItem_id"))
    private List<FoodItem> coldBoxContent;

    public ColdBox(){}

    public ColdBox(Long coldBoxId, String coldBoxName, List<FoodItem> coldBoxContent) {
        this.coldBoxId = coldBoxId;
        this.coldBoxName = coldBoxName;
        this.coldBoxContent = coldBoxContent;
    }

    public void removeFoodItem(FoodItem foodItem){
        if(coldBoxContent.contains(foodItem)){
            coldBoxContent.remove(foodItem);
        }
    }

    public Long getColdBoxId() {
        return coldBoxId;
    }

    public void setColdBoxId(Long coldBoxId) {
        this.coldBoxId = coldBoxId;
    }

    public String getColdBoxName() {
        return coldBoxName;
    }

    public void setColdBoxName(String coldBoxName) {
        this.coldBoxName = coldBoxName;
    }

    public List<FoodItem> getColdBoxContent() {
        return coldBoxContent;
    }

    public void setColdBoxContent(List<FoodItem> coldBoxContent) {
        this.coldBoxContent = coldBoxContent;
    }
}
