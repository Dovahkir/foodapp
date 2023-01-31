package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/coldbox")
public class ColdBoxController {

    @Autowired
    private final ColdBoxService coldBoxService;

    public ColdBoxController(ColdBoxService coldBoxService) {
        this.coldBoxService = coldBoxService;
    }

    @GetMapping("/{coldBoxId}")
    ColdBox getColdBox(@PathVariable Long coldBoxId){
        return coldBoxService.getColdBoxByID(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Cold box not found"));
    }

    @GetMapping
    List<ColdBox> getAllColdBox(){
        return coldBoxService.getAllColdBox();
    }

    @GetMapping("/{coldBoxId}/foodItems")
    ResponseEntity<List<FoodItem>> getAllFoodItemsInColdBox(@PathVariable Long coldBoxId){
        Optional<List<FoodItem>> foodItems = coldBoxService.getFoodItemsInColdBox(coldBoxId);
        if (foodItems.isPresent()){
            return ResponseEntity.ok(foodItems.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Fix the fact that the post allows to post the same footItem regardless of its anterior presence
    @PostMapping("/{coldBoxId}/{foodItemId}")
    ResponseEntity<Void> addNewFoodItemToColdBox(@PathVariable("coldBoxId") Long coldBoxId,@PathVariable("foodItemId") Long foodItemId){
        coldBoxService.addFoodItemToColdBox(coldBoxId, foodItemId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{coldBoxId}/{foodItemId}/{newDate}")
    void changeFoodItemExpDate(@PathVariable Long coldBoxId, @PathVariable Long foodItemId, @PathVariable String newDate){
        coldBoxService.changeFoodItemExpiryDate(coldBoxId,foodItemId,newDate);
    }

    //fix: the response when trying to delete an item that is not present should be indicative of that
    @DeleteMapping("/{coldBoxId}/{foodItemId}")
    ResponseEntity<Void> deleteAFoodItemFromColdBox(@PathVariable("coldBoxId") Long coldBoxId,@PathVariable("foodItemId") Long foodItemId){
        coldBoxService.deleteFoodItemFromColdBox(coldBoxId, foodItemId);
        return ResponseEntity.ok().build();
    }
}
