package com.dovahkir.foodapp.foodItem;


import com.dovahkir.foodapp.coldbox.ColdBox;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "food_item")
public class FoodItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String foodItemName;

    @Column(name = "CreatedDate", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @CreationTimestamp
    //@DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    private LocalDateTime addedTime;

    @Column(name = "ExpiryTime", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime expiryTime;

    @Column(name = "intakeDate", nullable = false)
    private ZonedDateTime intakeDate = ZonedDateTime.now();
    @DateTimeFormat/*(pattern = "dd-MM-yyyy")*/
    @Column(name = "expiryDate", nullable = false)
    private LocalDateTime expiryDate;

    @ManyToMany(mappedBy = "coldBoxContent")
    private List<ColdBox> coldBox;

    @Column(name = "remainingDays", nullable = true)
    private Duration remainingDays;


    public FoodItem() {
    }

    public FoodItem(Long id, String foodItemName, LocalDateTime addedTime, LocalDateTime expiryTime, ZonedDateTime intakeDate, Date expiryDate, List<ColdBox> coldBox, Duration remainingDays) {
        this.id = id;
        this.foodItemName = foodItemName;
        this.addedTime = addedTime;
        this.expiryTime = expiryTime;
        this.intakeDate = intakeDate;
        this.expiryDate = addedTime.plusDays(7);
        this.coldBox = coldBox;
        this.remainingDays = remainingDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFoodItemName() {
        return foodItemName;
    }

    public void setFoodItemName(String foodItemName) {
        this.foodItemName = foodItemName;
    }

    public LocalDateTime getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(LocalDateTime addedTime) {
        this.addedTime = addedTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
    }

    public ZonedDateTime getIntakeDate() {
        return intakeDate;
    }

    public void setIntakeDate(ZonedDateTime intakeDate) {
        this.intakeDate = intakeDate;
    }

    public LocalDateTime getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDateTime expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<ColdBox> getColdBox() {
        return coldBox;
    }

    public void setColdBox(List<ColdBox> coldBox) {
        this.coldBox = coldBox;
    }

    public Duration getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(Duration remainingDays) {
        this.remainingDays = remainingDays;
    }
}
