package com.simplecrud.simplecrud.controller;

import com.simplecrud.simplecrud.Model.Item;
import com.simplecrud.simplecrud.Repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class APIController {
    @Autowired
    private ItemRepo itemRepo;

    @GetMapping(value = "/")
    public String homepage(){
        return "Hello World";
    }

    @GetMapping(value = "/item")
    public List<Item> getAllItem(){
        return itemRepo.findAll();
    }

    @GetMapping(value = "/item/{id}")
    public Item getItem(@PathVariable long id){
        return itemRepo.findById(id).get();
    }
    @PostMapping(value = "item")
    public Item createItem(@RequestBody Item item){
        itemRepo.save(item);
        return item;
    }

    @PutMapping(value = "/item/{id}")
    public Item updateItem(@RequestBody Item item, @PathVariable long id){
        Item updatedItem = itemRepo.findById(id).get();
        updatedItem.setName(item.getName());
        updatedItem.setQuantity(item.getQuantity());
        itemRepo.save(updatedItem);
        return updatedItem;
    }

    @DeleteMapping(value = "/item/{id}")
    public Item deleteItem(@PathVariable long id){
        Item deletedItem = itemRepo.findById(id).get();
        itemRepo.delete(deletedItem);
        return deletedItem;
    }
}
