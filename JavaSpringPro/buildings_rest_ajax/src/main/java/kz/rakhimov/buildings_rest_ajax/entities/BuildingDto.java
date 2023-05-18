package kz.rakhimov.buildings_rest_ajax.entities;

import lombok.*;

import java.util.List;

@Getter
@Setter
public class BuildingDto {
    private Long id;
    private String name;
    private String location;
    private int floors;
    private Developer developer;
    private List<ServiceCompany> serviceCompanies;
}
