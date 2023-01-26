package com.dovahkir.foodapp.coldbox;

import com.dovahkir.foodapp.exceptions.ColdBoxNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/coldbox")
public class ColdBoxController {

    @Autowired
    private final ColdBoxService coldBoxService;

    public ColdBoxController(ColdBoxService coldBoxService) {
        this.coldBoxService = coldBoxService;
    }

    @GetMapping("/{id}")
    ColdBox getColdBox(@PathVariable Long id){
        return coldBoxService.getColdBoxByID(id).orElseThrow(() -> new ColdBoxNotFoundException("Cold box not found"));
    }

    @GetMapping
    List<ColdBox> getAllColdBox(){
        return coldBoxService.getAllColdBox();
    }
}
