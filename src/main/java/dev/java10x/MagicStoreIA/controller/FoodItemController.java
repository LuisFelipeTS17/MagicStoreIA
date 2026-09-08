package dev.java10x.MagicStoreIA.controller;

import dev.java10x.MagicStoreIA.model.FoodItem;
import dev.java10x.MagicStoreIA.service.FoodItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodItemController {

    private final FoodItemService service;

    public FoodItemController(FoodItemService service) {
        this.service = service;
    }

    // GET - listar todos
    @GetMapping("/listar")
    public ResponseEntity<List <FoodItem>> listar(){
    List<FoodItem> lista = service.listar();
    return ResponseEntity.ok(lista);
    }
    // POST - cria
    @PostMapping("/criar")
    public ResponseEntity<FoodItem> criar(@RequestBody FoodItem foodItem) {
        FoodItem salvo = service.salvar(foodItem);
        return ResponseEntity.ok(salvo);
    }

    // UPDATE - altera pelo id
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> atualizar(@RequestBody FoodItem foodItem, @PathVariable Long id) {
        return service.buscarPorId(id)
                .map(itemExistente -> {
                    foodItem.setId(itemExistente.getId());
                    FoodItem atualizado = service.atualizarItem(foodItem);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }


    // DELETE - remove pelo id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id){
    service.deletarItem(id);
    return ResponseEntity.noContent().build();
    }
}
