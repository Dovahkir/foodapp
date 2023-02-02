package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.coldboxfooditem.ColdBoxFoodItem;
import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import com.dovahkir.foodapp.exceptions.FoodItemNotFoundException;
import com.dovahkir.foodapp.exceptions.UserNotFoundException;
import com.dovahkir.foodapp.foodItem.FoodItem;
import com.dovahkir.foodapp.foodItem.FoodItemRepo;
import com.dovahkir.foodapp.user.User;
import com.dovahkir.foodapp.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ColdBoxService {

    private UserRepo userRepo;
    private ColdBoxRepo coldBoxRepo;
    private FoodItemRepo foodItemRepo;
    @Autowired
    public ColdBoxService(UserRepo userRepo, ColdBoxRepo coldBoxRepo, FoodItemRepo foodItemRepo) {
        this.userRepo = userRepo;
        this.coldBoxRepo = coldBoxRepo;
        this.foodItemRepo = foodItemRepo;
    }

    ColdBox createColdBox(ColdBox coldBox){
        return (ColdBox) coldBoxRepo.save(coldBox);
    }

    ColdBox createColdBoxForUserId(Long userId){
        ColdBox coldBox = new ColdBox(userRepo.findById(userId).orElseThrow(()-> new UserNotFoundException("Sorry matey. Not user by that ID found.")));
        return coldBoxRepo.save(coldBox);
    }

    Optional<ColdBox> getColdBoxByID(Long id){
        return coldBoxRepo.findById(id);
    }
    List<ColdBox> getAllColdBox(){
        return (List<ColdBox>) coldBoxRepo.findAll();
    }
    ColdBox addFoodItemToColdBox(Long coldBoxId, Long foodItemId){
        ColdBox coldBox = coldBoxRepo.findById(coldBoxId).orElseThrow(() -> new ColdBoxNotFoundException("No coldbox found by that ID.Please create one"));
        FoodItem foodItemToBeAdded = foodItemRepo.findById(foodItemId).orElseThrow(()-> new FoodItemNotFoundException("Sorry mate. There doesn't appear to be any food by that ID"));

        ColdBoxFoodItem foodItemReadyTobeAdded = new ColdBoxFoodItem(coldBox,foodItemToBeAdded);

        //DEBUG
        System.out.println(foodItemReadyTobeAdded.getFoodItem().getFoodItemName());
        System.out.println(foodItemReadyTobeAdded.getColdBox().getColdBoxId());
        //END OF DEBUG

        coldBox.getColdBoxFoodItems().add(foodItemReadyTobeAdded);
        coldBoxRepo.save(coldBox);
        return coldBox;
    }

    // allow us to add a foodItem to the coldbox and set the expiry date of the item at the same time.
    ColdBox addFoodItemToColdBox(Long coldBoxId, Long foodItemId , LocalDateTime expiryDate) {
        ColdBox coldBox = addFoodItemToColdBox(coldBoxId,foodItemId);
        coldBox.getColdBoxFoodItems().stream().max(Comparator.comparing(ColdBoxFoodItem::getAddedTime)).ifPresent(cbfi -> cbfi.setExpiryDate(expiryDate));
        coldBoxRepo.save(coldBox);
        return coldBox;
    }
























    // REMOVE THE ResponseEntity return type in the service class. Not  good practice.
//    void addFoodItemToColdBox(Long coldBoxId, Long foodItemId){
//        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
//        Optional<FoodItem> foodItem = foodItemRepo.findById(foodItemId);
//        if(coldBox.isPresent() && foodItem.isPresent()) {
//            coldBox.get().getColdBoxContent().add(foodItem.get());
//            coldBoxRepo.save(coldBox.get());
//        }
//    }
//
//    Optional<List<FoodItem>> getFoodItemsInColdBox(Long coldBoxId){
//        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
//        return coldBox.map(ColdBox::getColdBoxContent);
//    }
//

//
//
//    void changeFoodItemExpiryDate(Long coldBoxId, Long foodItemId, String newDate){
//        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
//        FoodItem foodItemToBeModified = coldBox.get().getColdBoxContent().stream().filter(foodItem -> foodItemId==foodItem.getId()).findAny().orElseThrow(() -> new FoodItemNotFoundException("There doesn't appear to be a food item by that ID"));
//        foodItemToBeModified.setExpiryTime(LocalDateTime.parse(newDate));
//    }
//
//    void deleteFoodItemFromColdBox(Long coldBoxId, Long foodItemId){
//        Optional<ColdBox> coldBox = coldBoxRepo.findById(coldBoxId);
//
//        //When I use the Optional to check whether or not the FoodItem is present. Im checking if it is present in the global database, not if its present in the current coldBox. I dont know if it makes more sense to check inside coldBox
//        Optional<FoodItem> foodItemToBeRemoved = foodItemRepo.findById(foodItemId);
//
//        if(coldBox.isPresent() && foodItemToBeRemoved.isPresent()){
//            coldBox.get().removeFoodItem(foodItemToBeRemoved.get());
//            coldBoxRepo.save(coldBox.get());
//        }
//    }
}
