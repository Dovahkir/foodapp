package com.dovahkir.foodapp.foodItem;


import com.dovahkir.foodapp.coldbox.ColdBox;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
    //@JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonSerialize
//    @JsonDeserialize
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    //@DateTimeFormat(iso = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    //@JsonIgnore
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",shape = JsonFormat.Shape.STRING)
    private LocalDateTime creationTime;

    @Column(name = "ExpiryTime", nullable = true, columnDefinition = "TIMESTAMP")
    //@JsonInclude(JsonInclude.Include.NON_NULL)
//    @JsonSerialize
//    @JsonDeserialize
//    @JsonFormat(shape = JsonFormat.Shape.STRING)
    //@JsonIgnore
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
    private LocalDateTime expiryTime;


    //I really dont understand why we needed that annotation really
    @JsonIgnore
    @OneToMany(mappedBy = "foodItem")
    private List<ColdBox> coldBox;

    @Column(name = "remainingDays", nullable = true)
    private Duration remainingDays;


    public FoodItem() {
    }

    public FoodItem(Long id, String foodItemName, LocalDateTime creationTime, LocalDateTime expiryTime, List<ColdBox> coldBox, Duration remainingDays) {
        this.id = id;
        this.foodItemName = foodItemName;
        this.creationTime = creationTime;
        this.expiryTime = expiryTime;
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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setAddedTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(LocalDateTime expiryTime) {
        this.expiryTime = expiryTime;
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
