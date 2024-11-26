package com.example.crudspring.controller;

import com.example.crudspring.model.Item;
import com.example.crudspring.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping
    public String getItems(Model model,
                              @RequestParam(required = false) String successMessage,
                              @RequestParam(required = false) String errorMessage) {
        model.addAttribute("items", itemService.getAllItems());
        model.addAttribute("newItem", new Item());
        model.addAttribute("editItem", new Item());
        model.addAttribute("successMessage", successMessage);
        model.addAttribute("errorMessage", errorMessage);

        return "items";
    }


    @PostMapping
    public String createItem(@ModelAttribute("item") Item item) {
        try {
            itemService.createItem(item);
            return "redirect:/items?successMessage=Item successfully added!";
        } catch (Exception e) {
            return "redirect:/items?errorMessage=Failed to add item.";
        }
    }

    @PostMapping("/{id}/edit")
    public String updateItem(@PathVariable String id, @ModelAttribute("item") Item item) {
        try {
            itemService.updateItem(id, item);
            return "redirect:/items?successMessage=Item successfully updated!";
        } catch (Exception e) {
            return "redirect:/items?errorMessage=Failed to update item.";
        }
    }

    @GetMapping("/{id}/delete")
    public String deleteItem(@PathVariable String id) {
        try {
            itemService.deleteItem(id);
            return "redirect:/items?successMessage=Item successfully deleted!";
        } catch (Exception e) {
            return "redirect:/items?errorMessage=Failed to delete item.";
        }
    }
}
