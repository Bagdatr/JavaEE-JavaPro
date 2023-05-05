package kz.bitlab.RestApp.services;

import kz.bitlab.RestApp.entities.Item;

import java.util.List;

public interface ItemService {
    Item addItem(Item item);
    List<Item> getAllItems();
    Item getItem(Long id);
    Item updateItem(Item updItem);
    void deleteItem(Long id);
}
