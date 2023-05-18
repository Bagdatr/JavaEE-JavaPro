package kz.bitlab.projectDto.services.impl;

import kz.bitlab.projectDto.entities.Item;
import kz.bitlab.projectDto.entities.ItemDto;
import kz.bitlab.projectDto.mapper.ItemMapper;
import kz.bitlab.projectDto.repositories.ItemRepository;
import kz.bitlab.projectDto.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemMapper itemMapper;

    @Override
    public ItemDto addItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setPrice(itemDto.getPrice());
        item.setAmount(itemDto.getAmount());
        item.setPromo(UUID.randomUUID().toString());
        return itemMapper.mapToDto(itemRepository.save(item));
    }

    @Override
    public ItemDto updateItem(ItemDto updItemDto) {
        Item item = itemRepository.findAllById(updItemDto.getId());
        item.setName(updItemDto.getName());
        item.setPrice(updItemDto.getPrice());
        item.setAmount(updItemDto.getAmount());
        return itemMapper.mapToDto(itemRepository.save(item));
    }

    @Override
    public List<ItemDto> getAllItems() {
        return itemMapper.mapToDtoList(itemRepository.findAll());
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}
