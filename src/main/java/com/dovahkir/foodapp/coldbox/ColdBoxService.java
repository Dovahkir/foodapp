package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.exceptions.FoodItemNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.foodItem.FoodItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    Optional<List<FoodItem>> getFoodItemsInColdBox(Long coldBoxId){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
        return coldBox.map(ColdBox::getColdBoxContent);
    }

    List<ColdBox> getAllColdBox(){
        return (List<ColdBox>) coldBoxRepo.findAll();
    }


    void changeFoodItemExpiryDate(Long coldBoxId, Long foodItemId, String newDate){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
        FoodItem foodItemToBeModified = coldBox.get().getColdBoxContent().stream().filter(foodItem -> foodItemId==foodItem.getId()).findAny().orElseThrow(() -> new FoodItemNotFoundException("There doesn't appear to be a food item by that ID"));
        foodItemToBeModified.setExpiryTime(LocalDateTime.parse(newDate));
    }

    void deleteFoodItemFromColdBox(Long coldBoxId, Long foodItemId){
        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);

        //When I use the Optional to check whether or not the FoodItem is present. Im checking if it is present in the global database, not if its present in the current coldBox. I dont know if it makes more sense to check inside coldBox
        Optional<FoodItem> foodItemToBeRemoved = foodItemRepo.findById(foodItemId);

        if(coldBox.isPresent() && foodItemToBeRemoved.isPresent()){
            coldBox.get().removeFoodItem(foodItemToBeRemoved.get());
            coldBoxRepo.save(coldBox.get());
        }
    }
}
