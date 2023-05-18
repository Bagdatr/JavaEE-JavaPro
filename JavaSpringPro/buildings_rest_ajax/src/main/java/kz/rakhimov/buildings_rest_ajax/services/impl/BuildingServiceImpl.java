package kz.rakhimov.buildings_rest_ajax.services.impl;

import kz.rakhimov.buildings_rest_ajax.entities.Building;
import kz.rakhimov.buildings_rest_ajax.entities.BuildingDto;
import kz.rakhimov.buildings_rest_ajax.mapper.BuildingMapper;
import kz.rakhimov.buildings_rest_ajax.repositories.BuildingRepository;
import kz.rakhimov.buildings_rest_ajax.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BuildingServiceImpl implements BuildingService {
    @Autowired
    BuildingRepository buildingRepository;
    @Autowired
    BuildingMapper buildingMapper;
    @Override
    public BuildingDto addBuilding(BuildingDto buildingDto) {
        Building building = new Building();
        building.setName(buildingDto.getName());
        building.setLocation(buildingDto.getLocation());
        building.setFloors(buildingDto.getFloors());
        building.setDeveloper(buildingDto.getDeveloper());
        building.setCadastralNumber(String.valueOf(UUID.randomUUID()));
        building.setServiceCompanies(buildingDto.getServiceCompanies());
        return buildingMapper.mapToDto(buildingRepository.save(building));
    }

    @Override
    public List<BuildingDto> getAllBuildings() {
        return buildingMapper.mapToDtoList(buildingRepository.findAll());
    }

    @Override
    public BuildingDto getBuilding(Long id) {
        return buildingMapper.mapToDto(buildingRepository.findAllById(id));
    }

    @Override
    public BuildingDto updateBuilding(BuildingDto updBuildingDto) {
        Building building = buildingRepository.findAllById(updBuildingDto.getId());
        building.setName(updBuildingDto.getName());
        building.setLocation(updBuildingDto.getLocation());
        building.setFloors(updBuildingDto.getFloors());
        building.setDeveloper(updBuildingDto.getDeveloper());
        building.setServiceCompanies(updBuildingDto.getServiceCompanies());
        return buildingMapper.mapToDto(buildingRepository.save(building));
    }

    @Override
    public void deleteBuilding(Long id) {
        buildingRepository.deleteById(id);
    }
}
