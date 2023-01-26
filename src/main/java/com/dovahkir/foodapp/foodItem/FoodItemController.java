package com.dovahkir.foodapp.foodItem;

import com.dovahkir.foodapp.exceptions.FoodItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/foodItem")
public class FoodItemController {
    @Autowired
    private final FoodItemService foodItemService;

    public FoodItemController(FoodItemService foodItemService) {
        this.foodItemService = foodItemService;
    }
    @GetMapping("/{id}")
    FoodItem getFoodItem(@PathVariable Long id){
        return foodItemService.getFoodItemByID(id).orElseThrow(() -> new FoodItemNotFoundException("food item not found"));
    }

    @GetMapping
    List<FoodItem> getAllFoodItem(){
        return foodItemService.getAllFoodItem();
    }
    @PostMapping("/newFoodItem")
    FoodItem newFoodItem(@Validated @RequestBody FoodItem newFoodItem){
        return foodItemService.saveFoodItem(newFoodItem);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    String deleteFoodItem(@PathVariable Long id){
        foodItemService.deleteFoodItemByID(id);
        return "Deleted Successfully";
    }
}
