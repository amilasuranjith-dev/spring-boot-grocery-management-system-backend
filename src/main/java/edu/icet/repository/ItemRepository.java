package edu.icet.repository;

import edu.icet.model.dto.ItemDto;

import java.util.List;

public interface ItemRepository {
    boolean addItem(ItemDto itemDto);
    boolean updateItem(ItemDto itemDto);
    boolean deleteItem(String id);
    ItemDto searchItemById(String id);
    List<ItemDto> getAll();
}
