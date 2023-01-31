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
    private List<ColdBoxFoodItem> coldBoxFoodItem;
    @Column
    private String coldBoxName;

    public ColdBox(){}











    //    public void removeFoodItem(FoodItem foodItem){
//        if(coldBoxContent.contains(foodItem)){
//            coldBoxContent.remove(foodItem);
//        }
//    }


}
