package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.Fooditem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {

    private FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    public Fooditem salvar(Fooditem fooditem){
        return repository.save(fooditem);
    }

    public List<Fooditem> listar(){
        return repository.findAll();
    }
}
