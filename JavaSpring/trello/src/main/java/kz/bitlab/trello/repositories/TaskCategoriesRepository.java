package kz.bitlab.trello.repositories;

import jakarta.transaction.Transactional;
import kz.bitlab.trello.entities.TaskCategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TaskCategoriesRepository extends JpaRepository<TaskCategories, Long> {
    TaskCategories findAllById(Long id);
}
