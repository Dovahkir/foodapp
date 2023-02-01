package com.dovahkir.foodapp.user;

import com.dovahkir.foodapp.coldbox.ColdBox;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long userId;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<ColdBox> coldBoxes;

    public User() {
    }

    public User(Long userId, String firstName, String lastName, String email, List<ColdBox> coldBoxes) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.coldBoxes = coldBoxes;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<ColdBox> getColdBoxes() {
        return coldBoxes;
    }

    public void setColdBoxes(List<ColdBox> coldBoxes) {
        this.coldBoxes = coldBoxes;
    }
}
