package kz.bitlab.RestApp.services.impl;

import kz.bitlab.RestApp.entities.Item;
import kz.bitlab.RestApp.repositories.ItemRepository;
import kz.bitlab.RestApp.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItem(Long id) {
        return itemRepository.findAllById(id);
    }

    @Override
    public Item updateItem(Item updItem) {
        Item item = getItem(updItem.getId());
        item.setName(updItem.getName());
        item.setAmount(updItem.getAmount());
        item.setPrice(updItem.getPrice());
        return addItem(item);
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
