package edu.icet.service;

import edu.icet.model.dto.ItemDto;

import java.util.List;

public interface ItemService {
    boolean addItem(ItemDto itemDto);
    boolean updateItem(ItemDto itemDto);
    boolean deleteItem(String id);
    ItemDto searchItemById(String id);
    List<ItemDto> getAll();
}
