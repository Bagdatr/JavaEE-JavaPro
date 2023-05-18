package kz.rakhimov.buildings_rest_ajax.services.impl;

import kz.rakhimov.buildings_rest_ajax.entities.ServiceCompany;
import kz.rakhimov.buildings_rest_ajax.repositories.ServiceCompanyRepository;
import kz.rakhimov.buildings_rest_ajax.services.ServiceCompanyService;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCompanyServiceImpl implements ServiceCompanyService {
    @Autowired
    private ServiceCompanyRepository serviceCompanyRepository;
    @Override
    public ServiceCompany addServiceCompany(ServiceCompany serviceCompany) {
        return serviceCompanyRepository.save(serviceCompany);
    }

    @Override
    public List<ServiceCompany> getAllServiceCompanies() {
        return serviceCompanyRepository.findAll();
    }

    @Override
    public void deleteServiceCompany(Long id) {
        serviceCompanyRepository.deleteById(id);
    }
}
