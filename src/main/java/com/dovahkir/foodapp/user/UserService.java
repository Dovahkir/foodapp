package com.dovahkir.foodapp.user;

import com.dovahkir.foodapp.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepo userRepo;
    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    Optional<User> getUserById(Long userId){
        return userRepo.findById(userId);
    }
}
