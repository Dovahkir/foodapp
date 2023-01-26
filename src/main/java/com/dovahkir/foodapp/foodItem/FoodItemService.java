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

    FoodItem updateFoodItem(FoodItem foodItem){
        return foodItemRepo.save(foodItem);
    }

    void deleteFoodItemByID(Long id){
        foodItemRepo.deleteById(id);
    }


}
