package com.example.crudspring.service;

import com.example.crudspring.model.Item;
import com.example.crudspring.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {
    @Autowired
    private ItemRepo itemRepo;

    public void createItem(Item item){
        itemRepo.save(item);
    }

    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

    public Optional<Item> getItemById(String id){
        return itemRepo.findById(id);
    }

    public Item updateItem(String id, Item updatedItem) {
        Optional<Item> existingItemOpt = itemRepo.findById(id);
        if (existingItemOpt.isPresent()) {
            Item existingItem = existingItemOpt.get();
            existingItem.setTitle(updatedItem.getTitle());
            existingItem.setNote(updatedItem.getNote());
            existingItem.setDays(updatedItem.getDays());
            return itemRepo.save(existingItem); // Save the updated item to the database
        } else {
            return null;
        }
    }

    public void deleteItem(String id){
        itemRepo.deleteById(id);
    }
}
