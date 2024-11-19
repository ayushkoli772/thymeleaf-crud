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

    public Item updateItem(String id, Item newItem){
        Optional<Item> old = itemRepo.findById(id);
        if(old.isPresent()){
            Item i = old.get();
            i.setTitle(newItem.getTitle());
            i.setNote(newItem.getNote());
            i.setDays(newItem.getDays());
            return itemRepo.save(i);
        }
        else {
            return null;
        }
    }

    public void deleteItem(String id){
        itemRepo.deleteById(id);
    }
}
