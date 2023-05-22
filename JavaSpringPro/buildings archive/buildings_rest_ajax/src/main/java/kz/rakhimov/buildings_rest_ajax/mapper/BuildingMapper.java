package kz.rakhimov.buildings_rest_ajax.mapper;

import kz.rakhimov.buildings_rest_ajax.entities.Building;
import kz.rakhimov.buildings_rest_ajax.entities.BuildingDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BuildingMapper {
    BuildingDto mapToDto(Building building);
    List<BuildingDto> mapToDtoList(List<Building> buildings);
}
