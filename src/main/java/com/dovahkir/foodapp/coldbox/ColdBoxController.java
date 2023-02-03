package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    ResponseEntity<ColdBox> getColdBox(@PathVariable Long coldBoxId){
        return ResponseEntity.ok(coldBoxService.getColdBoxByID(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Cold box not found")));
    }

    //TODO: try using ResponseEntity.created().....
    @PostMapping("/{userId}/createColdBox")
    ResponseEntity<ColdBox> createNewColdBox(@PathVariable Long userId){
        ColdBox coldBox = coldBoxService.createColdBoxForUserId(userId);
        return ResponseEntity.ok(coldBox);
    }

    @PutMapping("/{coldBoxId}/{foodItemId}")
    ResponseEntity<ColdBox> addFoodItemToColdBox(@PathVariable Long coldBoxId,@PathVariable Long foodItemId){
        ColdBox coldBox = coldBoxService.addFoodItemToColdBox(coldBoxId, foodItemId);
        return ResponseEntity.ok(coldBox);
    }
    @PutMapping("/{coldBoxId}/{foodItemId}/{expiryDate}")
    ResponseEntity<ColdBox> addFoodItemToColdBox(@PathVariable Long coldBoxId, @PathVariable Long foodItemId, @PathVariable LocalDateTime expiryDate){
        ColdBox coldBox = coldBoxService.addFoodItemToColdBox(coldBoxId, foodItemId, expiryDate);
        return ResponseEntity.ok(coldBox);
    }

    //TODO: add a PutMapping to modify the expiryTime of specific food item


    @GetMapping
    ResponseEntity<List<ColdBox>> getAllColdBox(){
        return ResponseEntity.ok(coldBoxService.getAllColdBox());
    }
//
//    @GetMapping("/{coldBoxId}/foodItems")
//    ResponseEntity<List<FoodItem>> getAllFoodItemsInColdBox(@PathVariable Long coldBoxId){
//        Optional<List<FoodItem>> foodItems = coldBoxService.getFoodItemsInColdBox(coldBoxId);
//        if (foodItems.isPresent()){
//            return ResponseEntity.ok(foodItems.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    //Fix the fact that the post allows to post the same footItem regardless of its anterior presence
//    @PostMapping("/{coldBoxId}/{foodItemId}")
//    ResponseEntity<Void> addNewFoodItemToColdBox(@PathVariable("coldBoxId") Long coldBoxId,@PathVariable("foodItemId") Long foodItemId){
//        coldBoxService.addFoodItemToColdBox(coldBoxId, foodItemId);
//        return ResponseEntity.ok().build();
//    }
//
//    @PutMapping("/{coldBoxId}/{foodItemId}/{newDate}")
//    void changeFoodItemExpDate(@PathVariable Long coldBoxId, @PathVariable Long foodItemId, @PathVariable String newDate){
//        coldBoxService.changeFoodItemExpiryDate(coldBoxId,foodItemId,newDate);
//    }
//
//    //fix: the response when trying to delete an item that is not present should be indicative of that
//    @DeleteMapping("/{coldBoxId}/{foodItemId}")
//    ResponseEntity<Void> deleteAFoodItemFromColdBox(@PathVariable("coldBoxId") Long coldBoxId,@PathVariable("foodItemId") Long foodItemId){
//        coldBoxService.deleteFoodItemFromColdBox(coldBoxId, foodItemId);
//        return ResponseEntity.ok().build();
//    }
}
