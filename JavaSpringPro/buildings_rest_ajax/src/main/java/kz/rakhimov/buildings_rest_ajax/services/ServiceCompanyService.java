package kz.rakhimov.buildings_rest_ajax.services;

import kz.rakhimov.buildings_rest_ajax.entities.ServiceCompany;

import java.util.List;

public interface ServiceCompanyService {
    ServiceCompany addServiceCompany(ServiceCompany serviceCompany);
    List<ServiceCompany> getAllServiceCompanies();
    void deleteServiceCompany(Long id);
}
