package kz.bitlab.crmNewProject.services.impl;

import kz.bitlab.crmNewProject.entities.Request;
import kz.bitlab.crmNewProject.repositories.CourseRepository;
import kz.bitlab.crmNewProject.repositories.RequestRepository;
import kz.bitlab.crmNewProject.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {
    @Autowired
    RequestRepository requestRepository;

    @Override
    public Request addRequest(Request request) {
        return requestRepository.save(request);
    }

    @Override
    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    @Override
    public Request getRequest(Long id) {
        return requestRepository.findAllById(id);
    }
}
