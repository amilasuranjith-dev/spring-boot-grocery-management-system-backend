package edu.icet.service.impl;

import edu.icet.model.dto.ItemDto;
import edu.icet.repository.ItemRepository;
import edu.icet.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public boolean addItem(ItemDto itemDto) {
        return itemRepository.addItem(itemDto);
    }

    @Override
    public boolean updateItem(ItemDto itemDto) {
        return itemRepository.updateItem(itemDto);
    }

    @Override
    public boolean deleteItem(String id) {
        return itemRepository.deleteItem(id);
    }

    @Override
    public ItemDto searchItemById(String id) {
        return itemRepository.searchItemById(id);
    }

    @Override
    public List<ItemDto> getAll() {
        return itemRepository.getAll();
    }
}
