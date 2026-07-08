package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.Fooditem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService service;

    public FoodItemController(FoodItemService foodItemService) {
        this.service = foodItemService;
    }

    // POST
    public ResponseEntity<Fooditem> criar(@RequestBody Fooditem fooditem){
        Fooditem salvo = service.salvar(fooditem);
        return ResponseEntity.ok(salvo);
    }

    // GET

    // UPDATE

    // DELETE
}
