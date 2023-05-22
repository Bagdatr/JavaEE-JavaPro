package kz.rakhimov.migration.services.impl;

import kz.rakhimov.migration.entities.Item;
import kz.rakhimov.migration.repositories.ItemRepository;
import kz.rakhimov.migration.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }
}
