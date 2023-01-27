package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.beans.Freezer;
import com.dovahkir.foodapp.beans.Fridge;
import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import com.dovahkir.foodapp.exceptions.FoodItemNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.foodItem.FoodItemRepo;
import com.dovahkir.foodapp.foodItem.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    // REMOVE THE ResponseEntity return type in the service class. Not  good practice.
    void addFoodItemToColdBox(Long coldBoxId, Long foodItemId){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
        Optional<FoodItem> foodItem = foodItemRepo.findById(foodItemId);
        if(coldBox.isPresent() && foodItem.isPresent()) {
            coldBox.get().getColdBoxContent().add(foodItem.get());
            coldBoxRepo.save(coldBox.get());
        }
    }

    void deleteFoodItemFromColdBox(Long coldBoxId, Long foodItemId){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
        if(coldBox.isPresent()){
            List<FoodItem> coldBoxFoodItemList = coldBox.get().getColdBoxContent();
            coldBoxFoodItemList.
        }
    }

    Optional<List<FoodItem>> getFoodItemsInColdBox(Long coldBoxId){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
        return coldBox.map(ColdBox::getColdBoxContent);
    }



    List<ColdBox> getAllColdBox(){
        return (List<ColdBox>) coldBoxRepo.findAll();
    }
}
