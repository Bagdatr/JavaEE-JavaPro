package kz.bitlab.projectDto.services;

import kz.bitlab.projectDto.entities.Item;
import kz.bitlab.projectDto.entities.ItemDto;

import java.util.List;

public interface ItemService {
    ItemDto addItem(ItemDto itemDto);
    ItemDto updateItem(ItemDto itemDto);
    List<ItemDto> getAllItems();
    void deleteItem(Long id);

}
