package dev.java10x.MagicFridgeAI.controller;

import dev.java10x.MagicFridgeAI.model.Fooditem;
import dev.java10x.MagicFridgeAI.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private FoodItemService service;

    public FoodItemController(FoodItemService foodItemService) {
        this.service = foodItemService;
    }

    // POST
    @PostMapping("food/criar")
    public ResponseEntity<Fooditem> criar(@RequestBody Fooditem fooditem){
        Fooditem salvo = service.salvar(fooditem);
        return ResponseEntity.ok(salvo);
    }

    // GET
    @GetMapping("/food/listar")
    public List<Fooditem> listarTodos(){
        return service.listar();
    }

    // GET - Por ID
    @GetMapping("food/listar/{id}")
    public Fooditem listarPorId(@PathVariable Long id){
        return service.listarPorId(id);
    }

    // UPDATE
    @PutMapping("/food/atualizar/{id}")
    public Fooditem atualizar(@PathVariable Long id, @RequestBody Fooditem foodItemAtualizado){
        return service.atualizar(id,foodItemAtualizado);
    }

    // DELETE
    @DeleteMapping("food/delete/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);
    }
}
