package kz.bitlab.CrmSystem_SprintTask_6_1.repositories;

import kz.bitlab.CrmSystem_SprintTask_6_1.entities.Operators;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface OperatorsRepository extends JpaRepository<Operators,Long> {
    Operators findAllById(Long id);
}
