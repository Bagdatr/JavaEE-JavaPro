package kz.bitlab.projectDto.mapper;

import kz.bitlab.projectDto.entities.Item;
import kz.bitlab.projectDto.entities.ItemDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    List<ItemDto> mapToDtoList (List<Item> items);
    ItemDto mapToDto(Item item);
    Item mapToEntity(ItemDto itemDto);
}
