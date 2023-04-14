package kz.bitlab.CrmSystem_SprintTask_6_1.repositories;

import kz.bitlab.CrmSystem_SprintTask_6_1.entities.ApplicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<ApplicationRequest,Long> {
    ApplicationRequest findAllById(Long id);
    List <ApplicationRequest> findAllByHandled(boolean handle);
    List<ApplicationRequest> findAllByUserNameContainsIgnoreCase(String name);

}
