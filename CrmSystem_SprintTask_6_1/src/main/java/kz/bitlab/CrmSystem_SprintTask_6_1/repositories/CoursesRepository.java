package kz.bitlab.CrmSystem_SprintTask_6_1.repositories;

import kz.bitlab.CrmSystem_SprintTask_6_1.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CoursesRepository extends JpaRepository<Courses,Long> {
}
