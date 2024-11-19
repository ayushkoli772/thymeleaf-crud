package com.example.crudspring.controller;

import com.example.crudspring.model.Item;
import com.example.crudspring.repository.ItemRepo;
import com.example.crudspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/test")
    public String testRoute(){
        return "Hello World!";
    }

    @PostMapping
    public void createItem(@RequestBody Item item){
        itemService.createItem(item);
    }

    @GetMapping
    public List<Item> getItems(){
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Optional<Item> getItemById(@PathVariable String id){
        return itemService.getItemById(id);
    }

    @PutMapping("/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item){
        Item newItem = itemService.updateItem(id,item);
        return newItem;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable String id){
        itemService.deleteItem(id);
    }

}
