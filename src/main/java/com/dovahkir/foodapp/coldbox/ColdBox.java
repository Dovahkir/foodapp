package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.beans.Freezer;
import com.dovahkir.foodapp.beans.Fridge;
import jakarta.persistence.*;

@Entity
@Table(name = "cold_box")
public class ColdBox {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long coldBoxID;
    //private User user;
    @Column
    @Embedded
    private Fridge fridge;
    @Column
    @Embedded
    private Freezer freezer;

    public ColdBox(Long coldBoxID, Fridge fridge, Freezer freezer) {
        this.coldBoxID = coldBoxID;
        this.fridge = fridge;
        this.freezer = freezer;
    }

    public Long getColdBoxID() {
        return coldBoxID;
    }

    public void setColdBoxID(Long coldBoxID) {
        this.coldBoxID = coldBoxID;
    }

    public Fridge getFridge() {
        return fridge;
    }

    public void setFridge(Fridge fridge) {
        this.fridge = fridge;
    }

    public Freezer getFreezer() {
        return freezer;
    }

    public void setFreezer(Freezer freezer) {
        this.freezer = freezer;
    }
}
