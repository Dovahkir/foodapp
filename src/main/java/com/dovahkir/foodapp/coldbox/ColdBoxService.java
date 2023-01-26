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
        ColdBox coldBox = (ColdBox) coldBoxRepo.findById(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Sorry, box not found."));
        Fridge fridge = coldBox.getFridge();
        FoodItem foodItemToBeAdded = foodItemRepo.findById(foodItemId).orElseThrow(() -> new FoodItemNotFoundException("Soz no such food item exist in our midst."));
        fridge.getFridgeContent().add(foodItemToBeAdded);
        coldBoxRepo.save(coldBox);
    }

    public void addFoodItemFreezer(Long coldBoxId, Long foodItemId) throws Throwable {
        ColdBox coldBox = (ColdBox) coldBoxRepo.findById(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("Sorry, box not found."));
        Freezer freezer = coldBox.getFreezer();
        FoodItem foodItemToBeAdded = foodItemRepo.findById(foodItemId).orElseThrow(() -> new FoodItemNotFoundException("Soz no such food item exist in our midst."));
        freezer.getFreezerContent().add(foodItemToBeAdded);
        coldBoxRepo.save(coldBox);
    }

    List<ColdBox> getAllColdBox(){
        return (List<ColdBox>) coldBoxRepo.findAll();
    }
}
