package kz.rakhimov.myProjectRestAndDto.repositories;

import jakarta.transaction.Transactional;
import kz.rakhimov.myProjectRestAndDto.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface StudentRepository extends JpaRepository<Student,Long> {
    Student findAllById(Long id);
}
