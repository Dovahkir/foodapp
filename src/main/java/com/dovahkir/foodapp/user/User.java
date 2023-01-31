package com.dovahkir.foodapp.user;

import com.dovahkir.foodapp.coldbox.ColdBox;
import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String email;
    @OneToMany(mappedBy = "user")
    private List<ColdBox> coldBoxes;

}
