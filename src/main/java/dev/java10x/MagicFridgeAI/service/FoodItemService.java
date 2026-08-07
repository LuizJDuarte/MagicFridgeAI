package dev.java10x.MagicFridgeAI.service;

import dev.java10x.MagicFridgeAI.model.Fooditem;
import dev.java10x.MagicFridgeAI.repository.FoodItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }

    // Funcionalidades Service

    public Fooditem salvar(Fooditem fooditem){
        return repository.save(fooditem);
    }

    public List<Fooditem> listar(){
        return repository.findAll();
    }

    public Fooditem listarPorId(Long id){
        Optional<Fooditem> foodPorId = repository.findById(id);
        return foodPorId.orElse(null);
    }

    public Optional<Fooditem> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Fooditem atualizar(Long id, Fooditem foodAtualizado){
        if(repository.existsById(id)){
            foodAtualizado.setId(id);
            return repository.save(foodAtualizado);
        }
        return null;
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
