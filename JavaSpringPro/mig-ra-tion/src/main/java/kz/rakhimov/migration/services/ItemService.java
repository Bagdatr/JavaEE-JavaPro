package kz.rakhimov.migration.services;

import kz.rakhimov.migration.entities.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();
}
