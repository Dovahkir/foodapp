package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.beans.Freezer;
import com.dovahkir.foodapp.beans.Fridge;
import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import com.dovahkir.foodapp.exceptions.FoodItemNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.foodItem.FoodItemRepo;
import com.dovahkir.foodapp.foodItem.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColdBoxService {

    private ColdBoxRepo coldBoxRepo;
    private FoodItemRepo foodItemRepo;
    @Autowired
    public ColdBoxService(ColdBoxRepo coldBoxRepo, FoodItemRepo foodItemRepo) {
        this.coldBoxRepo = coldBoxRepo;
        this.foodItemRepo = foodItemRepo;
    }

    ColdBox createColdBox(ColdBox coldBox){
        return (ColdBox) coldBoxRepo.save(coldBox);
    }

    Optional<ColdBox> getColdBoxByID(Long id){
        return coldBoxRepo.findById(id);
    }

    public void addFoodItemFridge(Long coldBoxId, Long foodItemId) throws Throwable {
        //Here, I find the correct fridge to be modified. Later I should add the ability to search by user instead of id.
        ColdBox coldBox = (ColdBox) coldBoxRepo.findById(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Sorry, box not found."));

        List<FoodItem> fridge = coldBox.getFridgeContent();

        //Here, I find the correct food Item to be added to the coldbox. Same goes here. I should prob implement the ability to search by food name.
        FoodItem foodItemToBeAdded = foodItemRepo.findById(foodItemId).orElseThrow(() -> new FoodItemNotFoundException("Soz no such food item exist in our midst."));
        fridge.add(foodItemToBeAdded);

        coldBox.setFridgeContent(fridge);
        coldBoxRepo.save(coldBox);
    }

    public void addFoodItemFreezer(Long coldBoxId, Long foodItemId) throws Throwable {
        //Here, I find the correct freezer to be modified. Later I should add the ability to search by user instead of id.
        ColdBox coldBox = (ColdBox) coldBoxRepo.findById(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Sorry, box not found."));

        List<FoodItem> freezer = coldBox.getFreezerContent();

        //Here, I find the correct food Item to be added to the coldbox. Same goes here. I should prob implement the ability to search by food name.
        FoodItem foodItemToBeAdded = foodItemRepo.findById(foodItemId).orElseThrow(() -> new FoodItemNotFoundException("Soz no such food item exist in our midst."));
        freezer.add(foodItemToBeAdded);

        coldBox.setFreezerContent(freezer);
        coldBoxRepo.save(coldBox);
    }

    List<ColdBox> getAllColdBox(){
        return (List<ColdBox>) coldBoxRepo.findAll();
    }
}
