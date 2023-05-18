package kz.rakhimov.buildings_rest_ajax.services;

import kz.rakhimov.buildings_rest_ajax.entities.Developer;

import java.util.List;

public interface DeveloperService {
    Developer addDeveloper(Developer developer);
    List<Developer> getAllDevelopers();
    Developer getDeveloper(Long id);
    Developer updateDeveloper(Developer updDeveloper);
    void deleteDeveloper(Long id);
}
