package kz.rakhimov.buildings_rest_ajax.controllers;

import kz.rakhimov.buildings_rest_ajax.entities.BuildingDto;
import kz.rakhimov.buildings_rest_ajax.entities.ServiceCompany;
import kz.rakhimov.buildings_rest_ajax.services.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api")
public class BuildingController {
    @Autowired
    public BuildingService buildingService;
    @GetMapping
    public List<BuildingDto> openAllBuildings(){
        return buildingService.getAllBuildings();
    }
    @PostMapping
    public BuildingDto addBuildingPost(@RequestBody BuildingDto buildingDto){
        return buildingService.addBuilding(buildingDto);
    }
    @GetMapping(value="/{id}")
    public BuildingDto getBuilding(@PathVariable("id") Long id){
        return buildingService.getBuilding(id);
    }
    @PutMapping
    public BuildingDto updateBuilding(@RequestBody BuildingDto buildingDto){
        return buildingService.updateBuilding(buildingDto);
    }
    @DeleteMapping(value="/{id}")
    public void deleteBuilding(@PathVariable("id") Long id){
        buildingService.deleteBuilding(id);
    }
}
