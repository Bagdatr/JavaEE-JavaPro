package kz.bitlab.projectDto.controllers;

import kz.bitlab.projectDto.entities.ItemDto;
import kz.bitlab.projectDto.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemDto> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping
    public ItemDto addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }
    @PutMapping
    public ItemDto updateItem(@RequestBody ItemDto updItemDto){
        return itemService.updateItem(updItemDto);
    }
    @DeleteMapping(value="/{id}")
    public void deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
    }
}
