package kz.bitlab.crmNewProject.services.impl;

import kz.bitlab.crmNewProject.entities.Operator;
import kz.bitlab.crmNewProject.repositories.OperatorRepository;
import kz.bitlab.crmNewProject.services.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OperatorServiceImpl implements OperatorService {
    @Autowired
    private OperatorRepository operatorRepository;
    @Override
    public List<Operator> getAllOperators() {
        return operatorRepository.findAll();
    }

    @Override
    public Operator getOperator(Long id) {
        return operatorRepository.findAllById(id);
    }
}
