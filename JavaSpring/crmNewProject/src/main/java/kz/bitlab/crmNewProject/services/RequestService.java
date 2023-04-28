package kz.bitlab.crmNewProject.services;

import kz.bitlab.crmNewProject.entities.Request;

import java.util.List;

public interface RequestService {
    Request addRequest(Request request);
    List<Request> getAllRequests();
    Request getRequest(Long id);
}
