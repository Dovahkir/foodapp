package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.coldboxfooditem.ColdBoxFoodItem;
import com.dovahkir.foodapp.user.User;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "coldbox")
public class ColdBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coldBoxId;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @OneToMany(mappedBy = "coldBox")
    private List<ColdBoxFoodItem> coldBoxFoodItems;
    @Column
    private String coldBoxName;

    public ColdBox(){}

    public ColdBox(Long coldBoxId, User user, List<ColdBoxFoodItem> coldBoxFoodItems, String coldBoxName) {
        this.coldBoxId = coldBoxId;
        this.user = user;
        this.coldBoxFoodItems = coldBoxFoodItems;
        this.coldBoxName = coldBoxName;
    }

    public Long getColdBoxId() {
        return coldBoxId;
    }

    public void setColdBoxId(Long coldBoxId) {
        this.coldBoxId = coldBoxId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<ColdBoxFoodItem> getColdBoxFoodItems() {
        return coldBoxFoodItems;
    }

    public void setColdBoxFoodItems(List<ColdBoxFoodItem> coldBoxFoodItems) {
        this.coldBoxFoodItems = coldBoxFoodItems;
    }

    public String getColdBoxName() {
        return coldBoxName;
    }

    public void setColdBoxName(String coldBoxName) {
        this.coldBoxName = coldBoxName;
    }

    //    public void removeFoodItem(FoodItem foodItem){
//        if(coldBoxContent.contains(foodItem)){
//            coldBoxContent.remove(foodItem);
//        }
//    }


}
