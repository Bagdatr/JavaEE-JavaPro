package kz.rakhimov.buildings_rest_ajax.services.impl;

import kz.rakhimov.buildings_rest_ajax.entities.Developer;
import kz.rakhimov.buildings_rest_ajax.repositories.DeveloperRepository;
import kz.rakhimov.buildings_rest_ajax.services.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
    @Autowired
    DeveloperRepository developerRepository;
    @Override
    public Developer addDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    @Override
    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    @Override
    public Developer getDeveloper(Long id) {
        return developerRepository.findAllById(id);
    }

    @Override
    public Developer updateDeveloper(Developer updDeveloper) {
        Developer developer = developerRepository.findAllById(updDeveloper.getId());
        developer.setName(updDeveloper.getName());
        developer.setExperience(updDeveloper.getExperience());
        developer.setAssets(updDeveloper.getAssets());
        return developerRepository.save(developer);
    }

    @Override
    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }
}
