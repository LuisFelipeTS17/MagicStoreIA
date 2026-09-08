package dev.java10x.MagicStoreIA.service;

import dev.java10x.MagicStoreIA.model.FoodItem;
import dev.java10x.MagicStoreIA.repository.FoodItemRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    private final FoodItemRepository repository;

    public FoodItemService(FoodItemRepository repository) {
        this.repository = repository;
    }


    public FoodItem salvar(FoodItem fooditem){
        return repository.save(fooditem);
    }

    public List<FoodItem>listar() {
        return repository.findAll();
    }

    // LISTAR POR ID: busca um item; retorna null se nao existir
    public Optional<FoodItem> buscarPorId(Long id){
        return repository.findById(id);
    }

    // ALTERAR: acha o item, copia os novos dados e salva por cima
    public FoodItem atualizarItem(FoodItem foodItem) {
        return repository.save(foodItem);
    }

    // DELETAR: remove pelo id
    public void deletarItem(Long id){
        repository.deleteById(id);
    }

}
