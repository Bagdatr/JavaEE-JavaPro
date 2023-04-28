package kz.bitlab.crmNewProject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.crmNewProject.entities.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface OperatorRepository extends JpaRepository<Operator,Long> {
    Operator findAllById(Long id);
}
