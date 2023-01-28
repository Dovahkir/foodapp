package com.dovahkir.foodapp.foodItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FoodItemService {
    @Autowired
    private FoodItemRepo foodItemRepo;

    public FoodItemService(FoodItemRepo foodItemRepo) {
        this.foodItemRepo = foodItemRepo;
    }

    FoodItem saveFoodItem(FoodItem foodItem){
        return foodItemRepo.save(foodItem);
    }

   public Optional<FoodItem> getFoodItemByID(Long id){
        return foodItemRepo.findById(id);
    }

    List<FoodItem> getAllFoodItem(){
        return (List<FoodItem>) foodItemRepo.findAll();
    }

    //Maybe create a PUT mapping for updting foodItems. Example: I made a mistake in the expiry date and want to fix it
    //Wrting this...The food items belong to everyone so how do I set the expiry date for user 1 and different one for user2
    FoodItem updateFoodItem(FoodItem foodItem){
        return foodItemRepo.save(foodItem);
    }

    void deleteFoodItemByID(Long id){
        foodItemRepo.deleteById(id);
    }


}
