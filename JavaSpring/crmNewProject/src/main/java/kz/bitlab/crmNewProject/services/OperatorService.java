package kz.bitlab.crmNewProject.services;

import kz.bitlab.crmNewProject.entities.Operator;

import java.util.List;

public interface OperatorService {
    List<Operator> getAllOperators();
    Operator getOperator(Long id);
}
