package kz.rakhimov.buildings_rest_ajax.services;

import kz.rakhimov.buildings_rest_ajax.entities.Building;
import kz.rakhimov.buildings_rest_ajax.entities.BuildingDto;

import java.util.List;

public interface BuildingService {
    BuildingDto addBuilding(BuildingDto buildingDto);
    List<BuildingDto> getAllBuildings();
    BuildingDto getBuilding(Long id);
    BuildingDto updateBuilding(BuildingDto updBuildingDto);
    void deleteBuilding(Long id);

}
