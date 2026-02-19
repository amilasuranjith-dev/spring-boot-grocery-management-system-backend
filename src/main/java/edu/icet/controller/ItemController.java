package edu.icet.controller;

import edu.icet.model.dto.ItemDto;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item")
@CrossOrigin
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/add")
    public boolean addItem(@RequestBody ItemDto itemDto){
        return itemService.addItem(itemDto);
    }

    @PutMapping("/update")
    public boolean updateItem(@RequestBody ItemDto itemDto){
        return itemService.updateItem(itemDto);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public boolean deleteItem(@PathVariable String id){
        return itemService.deleteItem(id);
    }

    @GetMapping("/search-by-id/{id}")
    public ItemDto searchById(@PathVariable String id){
        return itemService.searchItemById(id);
    }

    @GetMapping("/get-all")
    public List<ItemDto> getAll(){
        return itemService.getAll();
    }

}
