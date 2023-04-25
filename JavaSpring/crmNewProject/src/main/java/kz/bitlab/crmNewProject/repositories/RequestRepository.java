package kz.bitlab.crmNewProject.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.crmNewProject.entities.Course;
import kz.bitlab.crmNewProject.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request,Long> {
}