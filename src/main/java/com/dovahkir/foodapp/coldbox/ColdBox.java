package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.user.User;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "coldbox")
public class ColdBox {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long coldBoxId;
    @ManyToOne
    @JoinColumn("userId")
    private User user;
    @ManyToOne
    @JoinColumn(name = "foodItemId")
    private FoodItem foodItem;
    @Column
    private String coldBoxName;
    @Column
    private Integer nbReplica;
    @Column
    @CreationTimestamp
    private LocalDateTime addedTime;
    public ColdBox(){}

    public ColdBox(Long coldBoxId, User user, FoodItem foodItem, String coldBoxName, Integer nbReplica, LocalDateTime addedTime) {
        this.coldBoxId = coldBoxId;
        this.user = user;
        this.foodItem = foodItem;
        this.coldBoxName = coldBoxName;
        this.nbReplica = nbReplica;
        this.addedTime = addedTime;
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

    public FoodItem getFoodItem() {
        return foodItem;
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    public String getColdBoxName() {
        return coldBoxName;
    }

    public void setColdBoxName(String coldBoxName) {
        this.coldBoxName = coldBoxName;
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

    //    public void removeFoodItem(FoodItem foodItem){
//        if(coldBoxContent.contains(foodItem)){
//            coldBoxContent.remove(foodItem);
//        }
//    }


}
